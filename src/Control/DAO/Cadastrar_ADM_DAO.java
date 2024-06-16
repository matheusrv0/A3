package Control.DAO;

import Conexao_BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Cadastrar_ADM_DAO {
        private Connection conexao;

    public void Adicionar_ADM(String Login, String Senha) {
        conexao = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement comando_sql = null;
        try {
              comando_sql = conexao.prepareStatement("INSERT INTO tbl_CadastroLogin(Login, Senha) Values (?, ?)");
              comando_sql.setString(1, Login);
              comando_sql.setString(2, Senha);
              comando_sql.execute();
              comando_sql.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
}