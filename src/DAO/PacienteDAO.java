/*
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Paciente;
import Util.ConnectionFactory;

public class PacienteDAO {

    public void cadastrar(Paciente p) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("insert into produtos (tipo_sanguineo, peso, idade) values (?,?, ?)");
        comando.setString(1, p.getTipoSanguineo());
        comando.setDouble(2, p.getPeso());
        comando.setInt(3, p.getIdade());
        comando.execute();
        con.close();
    }

    public List<Paciente> consultarPacientes() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from PACIENTE");
        ResultSet rs = comando.executeQuery();

        List<Paciente> lPaciente = new ArrayList<Paciente>();
        while (rs.next()) {
            Paciente paciente = new Paciente();
            paciente.setTipoSanguineo(rs.getString("tipo_sanguineo"));
            paciente.setPeso(rs.getDouble("peso"));
            paciente.setIdade(rs.getInt("idade"));
            lPaciente.add(paciente);
        }
        return lPaciente;
    }
}
*/