package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;
import model.Pessoa;
import util.Ordenacao;
import util.OrdenacaoNome;

public class PersistenciaAlocacao {

    public static ArrayList<Pessoa> listaProfessor() throws SQLException {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();

        if (con == null) {
            return null;
        }

        try {
            String sqlQuery = "SELECT * FROM pessoa WHERE pes_funcao = 'Professor'";
            PreparedStatement comando = con.prepareStatement(sqlQuery);
            ResultSet rs = comando.executeQuery();

            ArrayList<Pessoa> listaProfessores = new ArrayList<>();

            while (rs.next()) {
                Pessoa prof = new Pessoa(rs.getString("pes_iden"), rs.getString("pes_funcao"),
                        rs.getString("pes_nome"), rs.getString("pes_logradouro"),
                        rs.getString("pes_cep"), rs.getString("pes_numero"),
                        rs.getString("pes_complemento"), rs.getString("pes_bairro"),
                        rs.getString("pes_cidade"), rs.getString("pes_uf"),
                        rs.getString("pes_telCelular"), rs.getString("pes_telResidencial"),
                        rs.getString("pes_situacao"));
                listaProfessores.add(prof);
            }
            //Ordenacao ord = new OrdenacaoId();
            Ordenacao ord = new OrdenacaoNome();
            ord.ordenar(listaProfessores);

            comando.close();
            rs.close();
            db.encerra();
            return listaProfessores;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            db.encerra();
            return null;
        }
    }

    public static boolean alocarProfessor(Pessoa professor, Disciplina disciplina) throws SQLException {
        DataBaseSQL db = new DataBaseSQL();
        Connection con = db.getConnection();

        if (con == null) {
            return false;
        }

        try {
            //con.setAutoCommit(false);
            String sqlQuery = "UPDATE disciplina SET disc_prof_iden = ? WHERE disc_iden = ?";
            PreparedStatement comando = con.prepareStatement(sqlQuery);
            comando.setString(1, professor.getPes_iden());
            comando.setInt(2, disciplina.getDisc_iden());
            comando.execute();
            comando.close();
            db.encerra();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            db.encerra();
            return false;
        }
    }
}
