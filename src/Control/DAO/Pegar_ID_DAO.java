package Control.DAO;

import Conexao_BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Pessoa;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;

public class Pegar_ID_DAO {
    private Connection conexao;
    
    public Pessoa Pegar_Pessoa(String CPF) throws SQLException, ParseException{
        conexao = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement comando_sql = null;
        ResultSet resultado = null;
        comando_sql = conexao.prepareStatement("SELECT * FROM tbl_Pessoa WHERE CPF = ?");
        comando_sql.setString(1, CPF);
        resultado = comando_sql.executeQuery();
        if(resultado.next()){
            String CPF_p = resultado.getString("CPF");
            String Nome = resultado.getString("Nome");
            int Idade = resultado.getInt("idade");
            Date D_Nasc = resultado.getDate("Aniversario");
            String Telefone = resultado.getString("Telefone");
            String Aniversario;
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(D_Nasc);
            Aniversario = calendario.get(Calendar.DAY_OF_MONTH)+"/"+(calendario.get(Calendar.MONTH)+1)+"/"+calendario.get(Calendar.YEAR);
            Pessoa P = new Pessoa (CPF_p, Nome, Aniversario, Telefone);
            comando_sql.close();
            conexao.close();
            return P;
        }
        comando_sql.close();
        conexao.close();
        return null;
    }

public int Pegar_IDPessoa(String CPF) throws SQLException, ParseException{
        int ID_pessoa = 0;
        conexao = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement comando_sql = null;
        ResultSet resultado = null;
        comando_sql = conexao.prepareStatement("SELECT ID_pessoa FROM tbl_Pessoa WHERE CPF = ?");
        comando_sql.setString(1, CPF);
        resultado = comando_sql.executeQuery();
        if(resultado.next()){
            ID_pessoa = resultado.getInt("ID_pessoa");
        }
        comando_sql.close();
        conexao.close();
        return ID_pessoa;
    }
}