package DAO;

import Connection.ConnectionFactory;
import Model.Doador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAO {

    // ── LISTAR TODOS ──────────────────────────────────────────────
    public List<Doador> findAll() throws SQLException {
        List<Doador> lista = new ArrayList<>();
        String sql = "SELECT * FROM doadores";

        // try-with-resources fecha Connection e PreparedStatement automaticamente
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // rs.next() avança linha por linha no resultado da query
                Doador d = new Doador();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setIdade(rs.getInt("idade"));
                d.setTelefone(rs.getString("telefone"));
                d.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                d.setPeso(rs.getDouble("peso"));
                lista.add(d);
            }
        }
        return lista;
    }

    // ── BUSCAR POR ID ─────────────────────────────────────────────
    public Doador findById(int id) throws SQLException {
        String sql = "SELECT * FROM doadores WHERE id = ?";
        // O ? é um placeholder — o valor é injetado depois (evita SQL Injection)

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id); // substitui o 1º ? pelo valor de id
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Doador d = new Doador();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setIdade(rs.getInt("idade"));
                d.setTelefone(rs.getString("telefone"));
                d.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                d.setPeso(rs.getDouble("peso"));
                return d;
            }
        }
        return null;
    }

    // ── INSERIR ───────────────────────────────────────────────────
    public void save(Doador doador) throws SQLException {
        String sql = "INSERT INTO doadores (nome, idade, telefone, tipo_sanguineo, peso) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doador.getNome());
            ps.setInt(2, doador.getIdade());
            ps.setString(3, doador.getTelefone());
            ps.setString(4, doador.getTipoSanguineo());
            ps.setDouble(5, doador.getPeso());
            ps.executeUpdate(); // executeUpdate() para INSERT, UPDATE, DELETE
        }
    }

    // ── DELETAR ───────────────────────────────────────────────────
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM doadores WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}


