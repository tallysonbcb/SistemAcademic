package model;

import control.PersistenciaAvaliacao;
import control.PersistenciaDiario;
import java.sql.Date;
import java.util.ArrayList;
import javafx.scene.chart.PieChart.Data;
import javax.swing.JOptionPane;


public class Diario {

    private String diar_pes_iden;
    private String diar_disc_desc;
    private int diar_presenca;
    private String diar_data;
    
    public Diario(){}
    public Diario(String diar_pes_iden, String diar_disc_desc, int diar_presenca, String diar_data) {
        this.diar_pes_iden = diar_pes_iden;
        this.diar_disc_desc = diar_disc_desc;
        this.diar_presenca = diar_presenca;
        this.diar_data = diar_data;
    }

      public static ArrayList<Diario> ListarDiario(String sql) {
        // retorna todas as contas cadastradas
        return PersistenciaDiario.listaDiario(sql);
    }

    public static boolean cadastrarDiario(String diar_pes_iden, String diar_disc_desc, int diar_presenca, String diar_data) throws Exception {

        Diario diario = new Diario(diar_pes_iden, diar_disc_desc, diar_presenca, diar_data);
        return PersistenciaDiario.cadastraDiario(diario);
    }

//    public static boolean AlterarAvaliacao(int aval_disc_iden, String aval_prof_iden,
//            String aval_alun_iden, double aval_frequencia, double aval_nota1,
//            double aval_nota2, double aval_notafinal, double aval_media, String aval_situacao) throws Exception {
//
//        Diario avaliacao = new Diario(aval_disc_iden, aval_prof_iden,
//                aval_alun_iden, aval_frequencia, aval_nota1,
//                aval_nota2, aval_notafinal, aval_media,  aval_situacao);
//
//        return PersistenciaAvaliacao.alteraAvaliacao(avaliacao);
//    }

    /**
     * @return the diar_pes_iden
     */
    public String getDiar_pes_iden() {
        return diar_pes_iden;
    }

    /**
     * @param diar_pes_iden the diar_pes_iden to set
     */
    public void setDiar_pes_iden(String diar_pes_iden) {
        this.diar_pes_iden = diar_pes_iden;
    }

    /**
     * @return the diar_disc_desc
     */
    public String getDiar_disc_desc() {
        return diar_disc_desc;
    }

    /**
     * @param diar_disc_desc the diar_disc_desc to set
     */
    public void setDiar_disc_desc(String diar_disc_desc) {
        this.diar_disc_desc = diar_disc_desc;
    }

    /**
     * @return the diar_presenca
     */
    public int getDiar_presenca() {
        return diar_presenca;
    }

    /**
     * @param diar_presenca the diar_presenca to set
     */
    public void setDiar_presenca(int diar_presenca) {
        this.diar_presenca = diar_presenca;
    }

    /**
     * @return the diar_data
     */
    public String getDiar_data() {
        return diar_data;
    }

    /**
     * @param diar_data the diar_data to set
     */
    public void setDiar_data(String diar_data) {
        this.diar_data = diar_data;
    }

    

}