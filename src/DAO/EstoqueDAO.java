package DAO;

import Connection.ConnectionFactory;
import Model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    // ── LISTAR O ESTOQUE ─────────────────────────────────────
    public List<Estoque> findAll() throws SQLException {
        List<Estoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM estoque ORDER BY tipo_sanguineo";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // ── BUSCAR ESTOQUE DE UM TIPO ESPECÍFICO ──────────────────────
    public Estoque findByTipo(String tipoSanguineo) throws SQLException {
        String sql = "SELECT * FROM estoque WHERE tipo_sanguineo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tipoSanguineo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapear(rs);
            }
        }
        return null;
    }

    // ── ADICIONAR QUANTIDADE AO ESTOQUE ──────────────────────────
    // Usa INSERT ... ON DUPLICATE KEY UPDATE para criar ou somar ao existente
    public void adicionar(String tipoSanguineo, double quantidade) throws SQLException {
        String sql = "INSERT INTO estoque (tipo_sanguineo, quantidade_sangue) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE quantidade_sangue = quantidade_sangue + ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tipoSanguineo);
            ps.setDouble(2, quantidade);
            ps.setDouble(3, quantidade);
            ps.executeUpdate();
        }
    }

    // ── CONSUMIR (SUBTRAIR) DO ESTOQUE ────────────────────────────
    // Usado quando um paciente recebe sangue
    public void consumir(String tipoSanguineo, double quantidade) throws SQLException {

        // Primeiro verifica se há saldo suficiente
        Estoque atual = findByTipo(tipoSanguineo);
        if (atual == null || atual.getQuantidadeSangue() < quantidade) {
            throw new SQLException("Estoque insuficiente para o tipo " + tipoSanguineo
                    + ". Disponível: " + (atual == null ? "0" : atual.getQuantidadeSangue()) + " ml");
        }

        String sql = "UPDATE estoque SET quantidade_sangue = quantidade_sangue - ? WHERE tipo_sanguineo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, quantidade);
            ps.setString(2, tipoSanguineo);
            ps.executeUpdate();
        }
    }

    // ── DEFINIR QUANTIDADE EXATA ──────────────────────────────────
    public void update(String tipoSanguineo, double novaQuantidade) throws SQLException {
        String sql = "UPDATE estoque SET quantidade_sangue = ? WHERE tipo_sanguineo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, novaQuantidade);
            ps.setString(2, tipoSanguineo);
            ps.executeUpdate();
        }
    }

    // ── MAPEAMENTO ResultSet → Estoque ────────────────────────────
    private Estoque mapear(ResultSet rs) throws SQLException {
        Estoque e = new Estoque();
        e.setTipoSanguineo(rs.getString("tipo_sanguineo"));
        e.setQuantidadeSangue(rs.getDouble("quantidade_sangue"));
        return e;
    }
}