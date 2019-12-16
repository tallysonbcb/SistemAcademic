/*
 * Persistência de dados
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Turma;

public class PersistenciaTurma {

    // seleciona todas as contas cadastradas no BD
    public static ArrayList<Turma> ListaTurma(String sql) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return null;
        }

        try {
            String sql_str = sql;
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();

            ArrayList<Turma> turma = new ArrayList<Turma>();
            Turma t;
            while (rs.next()) {
                t = new Turma(rs.getInt("turm_iden"), rs.getInt("turm_ano"),
                        rs.getInt("turm_semestre"), rs.getString("turm_horario"),
                        rs.getString("turm_diasemana"), rs.getInt("turm_disc_iden"));

                turma.add(t);
            }

            comando.close();
            rs.close();

            // encerra conexao
            db.encerra();

            // retorna lista de todas as turmas cadastradas
            return turma;
        } catch (SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean CadastrarTurma(Turma turm) {
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
                    "INSERT INTO turma (turm_iden, turm_ano, turm_semestre,"
                    + " turm_horario, turm_diasemana, turm_disc_iden)"
                    + " VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, turm.getTurm_iden());
            stmt.setInt(2, turm.getTurm_ano());
            stmt.setInt(3, turm.getTurm_semestre());
            stmt.setString(4, turm.getTurm_horario());
            stmt.setString(5, turm.getTurm_diasemana());
            stmt.setInt(6, turm.getTurm_disc_iden());

            stmt.executeUpdate();

            stmt.close();
            con.commit();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir novo registro");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean AlterarTurma(Turma turm) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return false;
        }

        try {
            String sql_str = "UPDATE turma SET turm_iden = ?, "
                    + "turm_ano = ?, turm_semestre = ?, "
                    + "turm_horario = ?, turm_diasemana = ?, "
                    + "turm_disc_iden = ?"
                    + "WHERE turm_iden = '" + turm.getTurm_iden() + "';";
            PreparedStatement comando = con.prepareStatement(sql_str);

            comando.setInt(1, turm.getTurm_iden());
            comando.setInt(2, turm.getTurm_ano());
            comando.setInt(3, turm.getTurm_semestre());
            comando.setString(4, turm.getTurm_horario());
            comando.setString(5, turm.getTurm_diasemana());
            comando.setInt(6, turm.getTurm_disc_iden());

            comando.execute();

            comando.close();

            // encerra conexao
            db.encerra();

            return true;
        } catch (SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage() + e.getErrorCode() + e.toString());
            db.encerra();
            return false;
        }
    }
}
