package Control.DAO;

import Conexao_BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_DAO {
    private Connection conexao;

    public boolean LoginCheck(String Login, String Senha) {
        conexao = (Connection) new ConnectionFactory().getConnection();
        boolean Check = false;
        PreparedStatement comando_sql = null;
        ResultSet resultado = null;
        try {
              comando_sql = conexao.prepareStatement("SELECT * FROM tbm_CadastroLogin WHERE Login = ? and Senha = ?");
              comando_sql.setString(1, Login);
              comando_sql.setString(2, Senha);
              resultado = comando_sql.executeQuery();
              if(resultado.next()){
                  Check = true;
              }
              comando_sql.close();
              conexao.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return Check;
    }
}