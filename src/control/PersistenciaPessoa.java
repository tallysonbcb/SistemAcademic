/*
 * Persistência de dados
*/
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.Pessoa;


public class PersistenciaPessoa {
    // seleciona todas as contas cadastradas no BD
    public static ArrayList<Pessoa> ListaPessoas(String sql)
    {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if(con == null)
        {
            return null;
        }
       
        try
        {
            String sql_str = sql;
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();

            ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
            Pessoa p;
            int a = 0;
            while (rs.next())
            {
                p = new Pessoa(rs.getString("pes_iden"), rs.getString("pes_funcao"),
                                  rs.getString("pes_nome"), rs.getString("pes_logradouro"),
                                  rs.getString("pes_cep"), rs.getString("pes_numero"),
                rs.getString("pes_complemento"), rs.getString("pes_bairro"),
                        rs.getString("pes_cidade"), rs.getString("pes_uf"),
                                rs.getString("pes_telCelular"), rs.getString("pes_telResidencial"), rs.getString("pes_situacao"));
                
                pessoa.add(p);
            }
            
            
                    
            comando.close();
            rs.close();
            
            // encerra conexao
            db.encerra();
            
            // retorna lista de todas as contas cadastradas
            return pessoa;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta SQL");
            JOptionPane.showMessageDialog(null, e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean CadastraPessoa(Pessoa pessoa)
    {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if(con == null)
        {
            return false;
        }

        // insere registro na tabela
        PreparedStatement stmt = null;
        try
        {
            con.setAutoCommit(false);
            stmt = con.prepareStatement(
                    "INSERT INTO pessoa (pes_iden, pes_funcao, pes_nome, pes_logradouro, pes_cep, pes_numero, pes_complemento, pes_bairro, pes_cidade, pes_uf, pes_telcelular,pes_telresidencial, pes_situacao)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, pessoa.getPes_iden());
            stmt.setString(2, pessoa.getPes_funcao());
            stmt.setString(3, pessoa.getPes_nome());
            stmt.setString(4, pessoa.getPes_logradouro());
            stmt.setString(5, pessoa.getPes_cep());
            stmt.setString(6, pessoa.getPes_numero());
            stmt.setString(7, pessoa.getPes_complemento());
            stmt.setString(8, pessoa.getPes_bairro());
            stmt.setString(9, pessoa.getPes_cidade());
            stmt.setString(10, pessoa.getPes_uf());
            stmt.setString(11, pessoa.getPes_telCelular());
            stmt.setString(12, pessoa.getPes_telResidencial());
            stmt.setString(13, pessoa.getPes_situacao());

            stmt.executeUpdate();

            stmt.close();
            con.commit();
            
            return true;
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao inserir novo registro.");
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
//    
    public static boolean AlteraPessoa(Pessoa pessoa)
    {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if(con == null)
        {
            return false;
        }

        try
        {
            String sql_str = "UPDATE pessoa SET pes_iden = ?, pes_funcao = ?, pes_nome = ?, pes_logradouro = ?,"
                              + "pes_cep = ?, pes_numero = ?, pes_complemento = ?, pes_bairro = ?,"
                              + "pes_cidade = ?, pes_uf = ?, pes_telcelular = ?, pes_telresidencial = ?, pes_situacao = ?"
                              + "WHERE pes_iden = '" + pessoa.getPes_iden() + "';";
            PreparedStatement comando = con.prepareStatement(sql_str);
            
            comando.setString(1, pessoa.getPes_iden());
            comando.setString(2, pessoa.getPes_funcao());
            comando.setString(3, pessoa.getPes_nome());
            comando.setString(4, pessoa.getPes_logradouro());
            comando.setString(5, pessoa.getPes_cep());
            comando.setString(6, pessoa.getPes_numero());
            comando.setString(7, pessoa.getPes_complemento());
            comando.setString(8, pessoa.getPes_bairro());
            comando.setString(9, pessoa.getPes_cidade());
            comando.setString(10, pessoa.getPes_uf());
            comando.setString(11, pessoa.getPes_telCelular());
            comando.setString(12, pessoa.getPes_telResidencial());
            comando.setString(13, pessoa.getPes_situacao());
            
            comando.execute();
            
            comando.close();
            
            // encerra conexao
            db.encerra();
            
            return true;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta SQL");
            JOptionPane.showMessageDialog(null, e.getMessage());
            db.encerra();
            return false;
        }
    }
    
}
