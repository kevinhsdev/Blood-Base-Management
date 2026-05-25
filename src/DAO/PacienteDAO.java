package DAO;

import Connection.ConnectionFactory;
import Model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // ── LISTAR TODOS ──────────────────────────────────────────────
    public List<Paciente> findAll() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

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
    public Paciente findById(int id) throws SQLException {
        String sql = "SELECT * FROM pacientes WHERE id = ?";

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

    // ── BUSCAR POR TIPO SANGUÍNEO ─────────────────────────────────
    public List<Paciente> findByTipoSanguineo(String tipoSanguineo) throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes WHERE tipo_sanguineo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tipoSanguineo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // ── INSERIR ───────────────────────────────────────────────────
    public void save(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO pacientes (nome, idade, telefone, tipo_sanguineo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getIdade());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getTipoSanguineo());
            ps.executeUpdate();
        }
    }

    // ── ATUALIZAR ─────────────────────────────────────────────────
    public void update(Paciente paciente) throws SQLException {
        String sql = "UPDATE pacientes SET nome = ?, idade = ?, telefone = ?, tipo_sanguineo = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getIdade());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getTipoSanguineo());
            ps.setInt(5, paciente.getId());
            ps.executeUpdate();
        }
    }

    // ── DELETAR ───────────────────────────────────────────────────
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM pacientes WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // ── MAPEAMENTO ResultSet → Paciente ───────────────────────────
    // Metodo privado para evitar repetição de código nos métodos acima
    private Paciente mapear(ResultSet rs) throws SQLException {
        Paciente p = new Paciente();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setIdade(rs.getInt("idade"));
        p.setTelefone(rs.getString("telefone"));
        p.setTipoSanguineo(rs.getString("tipo_sanguineo"));
        return p;
    }
}