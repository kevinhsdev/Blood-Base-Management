package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Doador;
import Util.ConnectionFactory;

public class DoadorDAO {

    public void cadastrar(Doador d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("insert into DOADOR (nome, idade, tipo_sanguineo, peso) values (?,?,?,?)");
        comando.setString(1, d.getNome());
        comando.setInt(2, d.getIdade());
        comando.setString(3, d.getTipoSanguineo());
        comando.setDouble(4, d.getPeso());
        comando.execute();
        con.close();
    }

    public void deletar(Doador d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("delete from DOADOR where id_doador = ?");
        comando.setInt(1, d.getIdDoador());
        comando.execute();
        con.close();
    }

    public void atualizar(Doador d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("update DOADOR set nome = ?, idade = ?, tipo_sanguineo = ?, peso = ? where id_doador = ?");
        comando.setString(1, d.getNome());
        comando.setInt(2, d.getIdade());
        comando.setString(3, d.getTipoSanguineo());
        comando.setDouble(4, d.getPeso());
        comando.setInt(5, d.getIdDoador());
        comando.execute();
        con.close();
    }

    public List<Doador> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from DOADOR");
        ResultSet rs = comando.executeQuery();

        List<Doador> lDoador = new ArrayList<Doador>();
        while (rs.next()) {
            Doador doador = new Doador();
            doador.setIdDoador(rs.getInt("id_doador"));


            lDoador.add(doador);
        }
        return lDoador;
    }

    public Doador consultarById(Doador d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from DOADOR where id_doador = ?");
        comando.setInt(1, d.getIdDoador());
        ResultSet rs = comando.executeQuery();
        Doador doador = new Doador();
        if (rs.next()){
            doador.setIdDoador(rs.getInt("id_doador"));
            doador.setNome(rs.getString("nome"));
            doador.setIdade(rs.getInt("idade"));
            doador.setTipoSanguineo(rs.getString("tipo_sanguineo"));
            doador.setPeso(rs.getDouble("peso"));
        }
        return doador;
    }
}
