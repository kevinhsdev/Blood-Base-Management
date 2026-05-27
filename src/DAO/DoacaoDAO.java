package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Doacao;
import Util.ConnectionFactory;

public class DoacaoDAO {
    public void cadastrar(Doacao d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("insert into DOACAO (qtd_sangue, data_coleta, id_doador) values (?,?,?)");
        comando.setDouble(1, d.getQuantidadeSangue());
        comando.setString(2, d.getData());
        comando.setInt(3, d.getIdDoador());
        comando.execute();
        con.close();
    }

    public void deletar(Doacao d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("delete from DOACAO where id = ?");
        comando.setInt(1, d.getId());
        comando.execute();
        con.close();
    }

    public void atualizar(Doacao d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("update DOACAO set qtd_sangue = ?, data_coleta = ? where id_doador = ?");
        comando.setDouble(1, d.getQuantidadeSangue());
        comando.setString(2, d.getData());
        comando.setInt(3, d.getIdDoador());
        comando.execute();
        con.close();
    }

    public List<Doacao> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from DOACAO");
        ResultSet rs = comando.executeQuery();

        List<Doacao> lDoacao = new ArrayList<Doacao>();
        while(rs.next()){
            Doacao doacao = new Doacao();
            doacao.setId(rs.getInt("id"));
            doacao.setQuantidadeSangue(rs.getDouble("qtd_sangue"));
            doacao.setData(rs.getString("data_coleta"));
            doacao.setIdDoador(rs.getInt("id_doador"));
            lDoacao.add(doacao);
        }
        return lDoacao;
    }

    public Doacao consultarById(Doacao d) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from DOACAO where id = ?");
        comando.setInt(1, d.getId());
        ResultSet rs = comando.executeQuery();
        Doacao doacao = new Doacao();
        if (rs.next()){
            doacao.setId(rs.getInt("id"));
            doacao.setData(rs.getString("data_coleta"));
            doacao.setQuantidadeSangue(rs.getDouble("qtd_sangue"));
        }
        return doacao;
    }

}

