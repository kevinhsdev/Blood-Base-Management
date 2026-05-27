package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Estoque;
import Util.ConnectionFactory;

public class EstoqueDAO {

    public void cadastrar(Estoque e) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("insert into ESTOQUE (tipo_sanguineo, qtd_sangue) values (?,?)");
        comando.setString(1, e.getTipoSanguineo());
        comando.setDouble(2, e.getQuantidadeSangue());
        comando.execute();
        con.close();
    }

    /*
    public void deletar(Estoque e) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("delete from ESTOQUE where id = ?");
        comando.setInt(1, e.getId());
        comando.execute();
        con.close();
    }

     */

    public List<Estoque> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement comando = con.prepareStatement("select * from ESTOQUE");
        ResultSet rs = comando.executeQuery();

        List<Estoque> lEstoque = new ArrayList<Estoque>();
        while(rs.next()){
            Estoque estoque = new Estoque();
            estoque.setQuantidadeSangue(rs.getDouble("qtd_sangue"));
            estoque.setTipoSanguineo(rs.getString("tipo_sanguineo"));
            lEstoque.add(estoque);
        }
        return lEstoque;
    }

}
