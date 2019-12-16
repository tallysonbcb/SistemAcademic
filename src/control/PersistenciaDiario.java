package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Avaliacao;
import model.Diario;

public class PersistenciaDiario {

    public static ArrayList<Diario> listaDiario(String sql) {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();
        if (con == null) {
            return null;
        }

        try {
            String sql_str = sql;
            PreparedStatement comando = con.prepareStatement(sql_str);
            ResultSet rs = comando.executeQuery();

            ArrayList<Diario> diario = new ArrayList<Diario>();
            Diario d;
            while (rs.next()) {
                d = new Diario(rs.getString("diar_pes_iden"), 
                        rs.getString("diar_disc_desc"),
                        rs.getInt("diar_presenca"), 
                        rs.getString("diar_data"));

                diario.add(d);
            }

            comando.close();
            rs.close();

            // encerra conexao
            db.encerra();

            // retorna lista de todas as contas cadastradas
            return diario;
        } catch (SQLException e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean cadastraDiario(Diario diario) throws Exception {
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
                    "INSERT INTO diario (diar_pes_iden, diar_disc_desc, diar_presenca, diar_data) VALUES (?, ?, ?, ?)");

            stmt.setString(1, diario.getDiar_pes_iden());
            stmt.setString(2, diario.getDiar_disc_desc());
            stmt.setInt(3, diario.getDiar_presenca());
            stmt.setString(4, diario.getDiar_data());

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

//    public static boolean alteraAvaliacao(Avaliacao avaliacao) throws Exception {
//        DataBaseSQL db = new DataBaseSQL();
//        Connection con = db.getConnection();
//        if (con == null) {
//            return false;
//        }
//
//        try {
//            String sql_str = "UPDATE avaliacao SET aval_disc_iden = ?, "
//                    + "aval_prof_iden = ?, aval_alun_iden = ?, "
//                    + "aval_frequencia = ?, aval_nota1 = ?, "
//                    + "aval_nota2 = ?, aval_notafinal = ?, aval_media = ?,"
//                    + "aval_situacao = ?"
//                    + "WHERE aval_alun_iden = '" 
//                    + avaliacao.getAval_alun_iden() + "';";
//            PreparedStatement comando = con.prepareStatement(sql_str);
//
//            comando.setInt(1, avaliacao.getAval_disc_iden());
//            comando.setString(2, avaliacao.getAval_prof_iden());
//            comando.setString(3, avaliacao.getAval_alun_iden());
//            comando.setDouble(4, avaliacao.getAval_frequencia());
//            comando.setDouble(5, avaliacao.getAval_nota1());
//            comando.setDouble(6, avaliacao.getAval_nota2());
//            comando.setDouble(7, avaliacao.getAval_notafinal());
//            comando.setDouble(8, avaliacao.getAval_media());
//            comando.setString(9, avaliacao.getAval_situacao());
//            comando.execute();
//
//            comando.close();
//
//            // encerra conexao
//            db.encerra();
//
//            return true;
//        } catch (SQLException e) {
//            System.out.println("Erro na consulta SQL");
//            System.out.println(e.getMessage());
//            db.encerra();
//            return false;
//        }
//    }
}
