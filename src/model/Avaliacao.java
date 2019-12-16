package model;

import control.PersistenciaAvaliacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Avaliacao {

    private int  aval_disc_iden;
    private String aval_prof_iden;
    private String aval_alun_iden;
    private double aval_frequencia;
    private double aval_nota1;
    private double aval_nota2;
    private double aval_notafinal;
    private double aval_media;
    private String aval_situacao;
    
    public Avaliacao(){}
    public Avaliacao(int aval_disc_iden, String aval_prof_iden, String aval_alun_iden, double aval_frequencia, double aval_nota1, double aval_nota2, double aval_notafinal, double aval_media, String aval_situacao) {
        this.aval_disc_iden = aval_disc_iden;
        this.aval_prof_iden = aval_prof_iden;
        this.aval_alun_iden = aval_alun_iden;
        this.aval_frequencia = aval_frequencia;
        this.aval_nota1 = aval_nota1;
        this.aval_nota2 = aval_nota2;
        this.aval_notafinal = aval_notafinal;
        this.aval_media = aval_media;
        this.aval_situacao = aval_situacao;
    }

      public static ArrayList<Avaliacao> ListarAvaliacao(String sql) {
        // retorna todas as contas cadastradas
        return PersistenciaAvaliacao.listaAvaliacao(sql);
    }

    public static boolean cadastrarAvaliacao(int aval_disc_iden, String aval_prof_iden,
            String aval_alun_iden, double aval_frequencia, double aval_nota1,
            double aval_nota2, double aval_notafinal, double aval_media, String aval_situacao) throws Exception {

        Avaliacao avaliacao = new Avaliacao(aval_disc_iden, aval_prof_iden,
                aval_alun_iden, aval_frequencia, aval_nota1,
                aval_nota2, aval_notafinal, aval_media, aval_situacao);

        return PersistenciaAvaliacao.cadastraAvaliacao(avaliacao);
    }

    public static boolean AlterarAvaliacao(int aval_disc_iden, String aval_prof_iden,
            String aval_alun_iden, double aval_frequencia, double aval_nota1,
            double aval_nota2, double aval_notafinal, double aval_media, String aval_situacao) throws Exception {

        Avaliacao avaliacao = new Avaliacao(aval_disc_iden, aval_prof_iden,
                aval_alun_iden, aval_frequencia, aval_nota1,
                aval_nota2, aval_notafinal, aval_media,  aval_situacao);

        return PersistenciaAvaliacao.alteraAvaliacao(avaliacao);
    }

    /**
     * @return the aval_disc_iden
     */
    public int getAval_disc_iden() {
        return aval_disc_iden;
    }

    /**
     * @param aval_disc_iden the aval_disc_iden to set
     */
    public void setAval_disc_iden(int aval_disc_iden) {
        this.aval_disc_iden = aval_disc_iden;
    }

    /**
     * @return the aval_prof_iden
     */
    public String getAval_prof_iden() {
        return aval_prof_iden;
    }

    /**
     * @param aval_prof_iden the aval_prof_iden to set
     */
    public void setAval_prof_iden(String aval_prof_iden) {
        this.aval_prof_iden = aval_prof_iden;
    }

    /**
     * @return the aval_alun_iden
     */
    public String getAval_alun_iden() {
        return aval_alun_iden;
    }

    /**
     * @param aval_alun_iden the aval_alun_iden to set
     */
    public void setAval_alun_iden(String aval_alun_iden) {
        this.aval_alun_iden = aval_alun_iden;
    }

    /**
     * @return the aval_frequencia
     */
    public double getAval_frequencia() {
        return aval_frequencia;
    }

    /**
     * @param aval_frequencia the aval_frequencia to set
     */
    public void setAval_frequencia(double aval_frequencia) {
        this.aval_frequencia = aval_frequencia;
    }

    /**
     * @return the aval_nota1
     */
    public double getAval_nota1() {
        return aval_nota1;
        
        
    }

    /**
     * @param aval_nota1 the aval_nota1 to set
     */
    public void setAval_nota1(double aval_nota1) {
        this.aval_nota1 = aval_nota1;
    }

    /**
     * @return the aval_nota2
     */
    public double getAval_nota2() {
        return aval_nota2;
    }

    /**
     * @param aval_nota2 the aval_nota2 to set
     */
    public void setAval_nota2(double aval_nota2) {
        this.aval_nota2 = aval_nota2;
    }

    /**
     * @return the aval_notafinal
     */
    public double getAval_notafinal() {
        return aval_notafinal;
    }

    /**
     * @param aval_notafinal the aval_notafinal to set
     */
    public void setAval_notafinal(double aval_notafinal) {
        this.aval_notafinal = aval_notafinal;
    }

    /**
     * @return the aval_situacao
     */
    public String getAval_situacao() {
        return aval_situacao;
    }

    /**
     * @param aval_situacao the aval_situacao to set
     */
    public void setAval_situacao(String aval_situacao) {
        this.aval_situacao = aval_situacao;
    }

    /**
     * @return the aval_media
     */
    public double getAval_media() {
        return aval_media;
    }

    /**
     * @param aval_media the aval_media to set
     */
    public void setAval_media(double aval_media) {
        this.aval_media = aval_media;
    }
}