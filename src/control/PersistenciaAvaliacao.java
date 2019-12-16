package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Avaliacao;

public class PersistenciaAvaliacao {

    public static ArrayList<Avaliacao> listaAvaliacao(String sql) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return null;
        }

        try {
            String sql_str = sql;
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();

            ArrayList<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
            Avaliacao a;
            while (rs.next()) {
                a = new Avaliacao(rs.getInt("aval_disc_iden"), rs.getString("aval_prof_iden"),
                        rs.getString("aval_alun_iden"), rs.getDouble("aval_frequencia"),
                        rs.getDouble("aval_nota1"), rs.getDouble("aval_nota2"),
                        rs.getDouble("aval_notafinal"),
                        rs.getDouble("aval_media"),
                        rs.getString("aval_situacao"));

                avaliacao.add(a);
            }

            comando.close();
            rs.close();

            // encerra conexao
            db.encerra();

            // retorna lista de todas as contas cadastradas
            return avaliacao;
        } catch (SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean cadastraAvaliacao(Avaliacao avaliacao) throws Exception {
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
                    "INSERT INTO avaliacao (aval_disc_iden, "
                    + "aval_prof_iden, aval_alun_iden, "
                    + "aval_frequencia, aval_nota1, "
                    + "aval_nota2, aval_notafinal, aval_media,"
                    + "aval_situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, avaliacao.getAval_disc_iden());
            stmt.setString(2, avaliacao.getAval_prof_iden());
            stmt.setString(3, avaliacao.getAval_alun_iden());
            stmt.setDouble(4, avaliacao.getAval_frequencia());
            stmt.setDouble(5, avaliacao.getAval_nota1());
            stmt.setDouble(6, avaliacao.getAval_nota2());
            stmt.setDouble(7, avaliacao.getAval_notafinal());
            stmt.setDouble(8, avaliacao.getAval_media());
            stmt.setString(9, avaliacao.getAval_situacao());

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

    public static boolean alteraAvaliacao(Avaliacao avaliacao) throws Exception {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return false;
        }

        try {
            String sql_str = "UPDATE avaliacao SET aval_disc_iden = ?, "
                    + "aval_prof_iden = ?, aval_alun_iden = ?, "
                    + "aval_frequencia = ?, aval_nota1 = ?, "
                    + "aval_nota2 = ?, aval_notafinal = ?, aval_media = ?,"
                    + "aval_situacao = ?"
                    + "WHERE aval_alun_iden = '" 
                    + avaliacao.getAval_alun_iden() + "';";
            PreparedStatement comando = con.prepareStatement(sql_str);

            comando.setInt(1, avaliacao.getAval_disc_iden());
            comando.setString(2, avaliacao.getAval_prof_iden());
            comando.setString(3, avaliacao.getAval_alun_iden());
            comando.setDouble(4, avaliacao.getAval_frequencia());
            comando.setDouble(5, avaliacao.getAval_nota1());
            comando.setDouble(6, avaliacao.getAval_nota2());
            comando.setDouble(7, avaliacao.getAval_notafinal());
            comando.setDouble(8, avaliacao.getAval_media());
            comando.setString(9, avaliacao.getAval_situacao());
            comando.execute();

            comando.close();

            // encerra conexao
            db.encerra();

            return true;
        } catch (SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return false;
        }
    }
}
