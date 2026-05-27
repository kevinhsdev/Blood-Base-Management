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
        PreparedStatement comando = con.prepareStatement("insert into DOACAO (qtd_sangue, data_coleta, id_doador, tipo_sanguineo) values (?,?,?,?)");
        comando.setDouble(1, d.getQuantidadeSangue());
        comando.setString(2, d.getData());
        comando.setInt(3, d.getIdDoador());
        //comando.setString(4, d.getTipoSanquineo());
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


    public List<Doacao> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from DOACAO");
        ResultSet rs = comando.executeQuery();

        List<Doacao> lDoacao = new ArrayList<Doacao>();
        while(rs.next()){
            Doacao prod = new Doacao();
            prod.setQuantidadeSangue(rs.getDouble("qtd_sangue"));
            prod.setData(rs.getString("data_coleta"));
            prod.setId(rs.getInt("id"));
            prod.setIdDoador(rs.getInt("id_doador"));
            //prod.setTipoSanguineo(rs.getString("tipo_sanguineo"));
            lDoacao.add(prod);
        }
        return lDoacao;
    }
}

