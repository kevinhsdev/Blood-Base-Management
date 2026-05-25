package DAO;

import Connection.ConnectionFactory;
import Model.Doacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAO {

    // ── LISTAR TODAS ──────────────────────────────────────────────
    public List<Doacao> findAll() throws SQLException {
        List<Doacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM doacoes";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // ── BUSCAR POR ID ─────────────────────────────────────────────
    public Doacao findById(int id) throws SQLException {
        String sql = "SELECT * FROM doacoes WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }
        }
        return null;
    }

    // ── BUSCAR DOAÇÕES DE UM DOADOR ESPECÍFICO ────────────────────
    public List<Doacao> findByDoador(int idDoador) throws SQLException {
        List<Doacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM doacoes WHERE id_doador = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idDoador);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // ── REGISTRAR DOAÇÃO + ATUALIZAR ESTOQUE (TRANSAÇÃO) ─────────
    // Esse método usa Transaction para garantir que as duas operações
    // aconteçam juntas: se uma falhar, a outra também é desfeita (rollback).
    public void registrar(Doacao doacao, String tipoSanguineo) throws SQLException {
        String sqlDoacao  = "INSERT INTO doacoes (quantidade_sangue, data, id_doador) VALUES (?, ?, ?)";
        String sqlEstoque = "INSERT INTO estoque (tipo_sanguineo, quantidade_sangue) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE quantidade_sangue = quantidade_sangue + ?";

        // Abrimos a conexão manualmente para controlar a transação
        Connection conn = ConnectionFactory.getConnection();

        try {
            conn.setAutoCommit(false); // desativa commit automático

            // 1) Insere a doação
            try (PreparedStatement ps = conn.prepareStatement(sqlDoacao)) {
                ps.setDouble(1, doacao.getQuantidadeSangue());
                ps.setString(2, doacao.getData());
                ps.setInt(3, doacao.getIdDoador());
                ps.executeUpdate();
            }

            // 2) Atualiza ou cria o registro no estoque
            try (PreparedStatement ps = conn.prepareStatement(sqlEstoque)) {
                ps.setString(1, tipoSanguineo);
                ps.setDouble(2, doacao.getQuantidadeSangue()); // para o INSERT
                ps.setDouble(3, doacao.getQuantidadeSangue()); // para o UPDATE
                ps.executeUpdate();
            }

            conn.commit(); // confirma as duas operações juntas

        } catch (SQLException e) {
            conn.rollback(); // se qualquer uma falhar, desfaz tudo
            throw e;         // relança o erro para quem chamou tratar
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    // ── DELETAR ───────────────────────────────────────────────────
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM doacoes WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ── MAPEAMENTO ResultSet → Doacao ─────────────────────────────
    private Doacao mapear(ResultSet rs) throws SQLException {
        Doacao d = new Doacao();
        d.setId(rs.getInt("id"));
        d.setQuantidadeSangue(rs.getDouble("quantidade_sangue"));
        d.setData(rs.getString("data"));
        d.setIdDoador(rs.getInt("id_doador"));
        return d;
    }
}