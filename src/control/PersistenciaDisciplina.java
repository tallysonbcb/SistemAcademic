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
import model.Disciplina;

public class PersistenciaDisciplina {

    // seleciona todas as contas cadastradas no BD
    public static ArrayList<Disciplina> listaDisciplina(String sql) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return null;
        }

        try {
            String sql_str = sql;
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();

            ArrayList<Disciplina> disc = new ArrayList<Disciplina>();
            Disciplina d;
            while (rs.next()) {
                d = new Disciplina(rs.getInt("disc_iden"),
                        rs.getInt("disc_curs_iden"),
                        rs.getString("disc_descricao"),
                        rs.getInt("disc_prerequisito"),
                        rs.getInt("disc_cargahoraria"),
                        rs.getString("disc_bibliografia"),
                        rs.getString("disc_ementa"),
                        rs.getString("disc_prof_iden"));

                disc.add(d);
            }

            comando.close();
            rs.close();

            // encerra conexao
            db.encerra();

            // retorna lista de todas as contas cadastradas
            return disc;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean cadastraDisciplina(Disciplina disc) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return false;
        }

        // insere registro na tabela
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            stmt = con.prepareStatement(
                    "INSERT INTO disciplina (disc_iden, disc_curs_iden, "
                            + "disc_descricao, disc_prerequisito, "
                            + "disc_cargahoraria, disc_bibliografia, "
                            + "disc_ementa, disc_prof_iden)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, disc.getDisc_iden());
            stmt.setInt(2, disc.getDisc_curs_iden());
            stmt.setString(3, disc.getDisc_descricao());
            stmt.setInt(4, disc.getDisc_preRequesito());
            stmt.setInt(5, disc.getDisc_cargaHoraria());
            stmt.setString(6, disc.getDisc_bibliografia());
            stmt.setString(7, disc.getDisc_ementa());
            stmt.setString(8, disc.getDisc_prof_iden());

            stmt.executeUpdate();

            stmt.close();
            con.commit();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir novo registro");
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public static boolean alteraDisciplina(Disciplina disc) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return false;
        }

        try {
            String sql_str = "UPDATE disciplina SET disc_iden = ?, "
                    + "disc_curs_iden = ?, disc_descricao = ?, "
                    + "disc_prerequisito = ?, disc_cargahoraria = ?, "
                    + "disc_bibliografia = ?, disc_ementa = ?, "
                    + "disc_prof_iden = ?"
                    + "WHERE disc_iden = '" + disc.getDisc_iden() + "';";
            
            PreparedStatement comando = con.prepareStatement(sql_str);

            comando.setInt(1, disc.getDisc_iden());
            comando.setInt(2, disc.getDisc_curs_iden());
            comando.setString(3, disc.getDisc_descricao());
            comando.setInt(4, disc.getDisc_preRequesito());
            comando.setInt(5, disc.getDisc_cargaHoraria());
            comando.setString(6, disc.getDisc_bibliografia());
            comando.setString(7, disc.getDisc_ementa());
            comando.setString(8, disc.getDisc_prof_iden());

            comando.execute();

            comando.close();

            // encerra conexao
            db.encerra();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta SQL");
            JOptionPane.showMessageDialog(null, e.getMessage() + e.getErrorCode() + e.toString());
            db.encerra();
            return false;
        }
    }

}
