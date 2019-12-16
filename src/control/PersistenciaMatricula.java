/*
 * Persistência de dados
*/
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Matricula;


public class PersistenciaMatricula {
    // seleciona todas as contas cadastradas no BD
    public static ArrayList<Matricula> ListaMatricula(String sql)
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

            ArrayList<Matricula> matric = new ArrayList<Matricula>();
            Matricula m;
            
            while (rs.next())
            {
                m = new Matricula(rs.getString("matr_pes_iden"), rs.getInt("matr_turm_iden"),
                                  rs.getInt("matr_curs_iden"), rs.getString("matr_situacao"));
                
                matric.add(m);
            }
            
            comando.close();
            rs.close();
            
            // encerra conexao
            db.encerra();
            
            // retorna lista de todas as contas cadastradas
            return matric;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta SQL");
            JOptionPane.showMessageDialog(null, e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean CadastraMatricula(Matricula matric)
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
                    "INSERT INTO matricula (matr_pes_iden, matr_turm_iden, matr_curs_iden, matr_situacao)" +
                    " VALUES (?, ?, ?, ?)");
            
            stmt.setString(1, matric.getMatr_pes_iden());
            stmt.setInt(2, matric.getMat_turm_iden());
            stmt.setInt(3, matric.getMat_curso_iden());
            stmt.setString(4, matric.getSituacao());

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

    public static boolean AlteraMatricula(Matricula matric)
    {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if(con == null)
        {
            return false;
        }

        try
        {
            String sql_str = "UPDATE matricula SET matr_pes_iden = ?, matr_turm_iden= ?, matr_curs_iden = ?, matr_situacao = ?"
                           + "WHERE matr_pes_iden = '" + matric.getMatr_pes_iden() + "';";
            PreparedStatement comando = con.prepareStatement(sql_str);
            
            comando.setString(1, matric.getMatr_pes_iden());
            comando.setInt(2, matric.getMat_turm_iden());
            comando.setInt(3, matric.getMat_curso_iden());
            comando.setString(4, matric.getSituacao());

            
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
