/*
 * Persistência de dados
*/
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Curso;
import model.Pessoa;

public class PersistenciaCurso {
    // seleciona todas as contas cadastradas no BD
    public static ArrayList<Curso> ListaCursos(String sql)
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

            ArrayList<Curso> curso = new ArrayList<Curso>();
            Curso c;
            while (rs.next())
            {
                c = new Curso(rs.getInt("curs_iden"), rs.getString("curs_descricao"),rs.getString("curs_coord_iden"));
                
                curso.add(c);
            }
  
            comando.close();
            rs.close();
            
            // encerra conexao
            db.encerra();
            
            // retorna lista de todas as contas cadastradas
            return curso;
        } catch(SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean CadastraCurso(Curso curso)
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
                    "INSERT INTO curso (curs_iden, curs_descricao, curs_coord_iden)" +
                    " VALUES (?, ?, ?)");
            
            stmt.setInt(1, curso.getCurs_iden());
            stmt.setString(2, curso.getCurs_descricao());
            stmt.setString(3, curso.getCurs_coord_iden());

            stmt.executeUpdate();

            stmt.close();
            con.commit();
            
            return true;
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao inserir novo registro");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean AlteraCurso(Curso curso)
    {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if(con == null)
        {
            return false;
        }

        try
        {
            String sql_str = "UPDATE curso SET curs_iden = ?, curs_descricao = ?, curs_coord_iden = ?"
                              + "WHERE curs_iden = '" + curso.getCurs_iden() + "';";
            PreparedStatement comando = con.prepareStatement(sql_str);
            
            comando.setInt(1, curso.getCurs_iden());
            comando.setString(2, curso.getCurs_descricao());
            comando.setString(3, curso.getCurs_coord_iden());
                     
            comando.execute();
            
            comando.close();
            
            // encerra conexao
            db.encerra();
            
            return true;
        } catch(SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage() + e.getErrorCode() + e.toString());
            db.encerra();
            return false;
        }
    }
    
}
