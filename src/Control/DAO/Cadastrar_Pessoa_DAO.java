package Control.DAO;

import Conexao_BD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Pessoa;

public class Cadastrar_Pessoa_DAO {
    private Connection conexao;

    public void Adicionar_Pessoa(Pessoa P) {
        conexao = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement comando_sql = null;
        try {
              comando_sql = conexao.prepareStatement("INSERT INTO tbl_pessoa(CPF, nome, idade, Aniversario, telefone) Values (?, ?, ?, ?, ?)");
              comando_sql.setString(1, P.getCPF());
              comando_sql.setString(2, P.getNome());
              comando_sql.setInt(3, P.getIdade());
              comando_sql.setString(4, P.getAniversario());
              comando_sql.setString(5, P.getTelefone());
              comando_sql.execute();
              comando_sql.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
}