package model;

import control.PersistenciaAvaliacao;
import control.PersistenciaMatricula;
import java.util.ArrayList;


public class Matricula {
 
    private String  matr_pes_iden;
    private int mat_turm_iden;
    private int mat_curso_iden;
    private String situacao;
    
    
  
    public Matricula(){}

    public Matricula(String matr_pes_iden, int mat_turm_iden, int mat_curso_iden, String situacao) {
        this.matr_pes_iden = matr_pes_iden;
        this.mat_turm_iden = mat_turm_iden;
        this.situacao = situacao;
        this.mat_curso_iden = mat_curso_iden;
    }
   

      public static ArrayList<Matricula> ListaMatricula(String sql) {
        // retorna todas as contas cadastradas
        return PersistenciaMatricula.ListaMatricula(sql);
    }

    public static boolean CadastrarMatricula(String matr_pes_iden, int mat_turm_iden, int mat_curso_iden, String situacao) throws Exception {

        Matricula matric = new Matricula(matr_pes_iden, mat_turm_iden, mat_curso_iden, situacao);

        return PersistenciaMatricula.CadastraMatricula(matric);
    }

    public static boolean AlterarMatricula(String matr_pes_iden, int mat_turm_iden, int mat_curso_iden, String situacao) throws Exception {

        Matricula matric = new Matricula(matr_pes_iden, mat_turm_iden, mat_curso_iden, situacao);

        return PersistenciaMatricula.AlteraMatricula(matric);
    }

    /**
     * @return the matr_pes_iden
     */
    public String getMatr_pes_iden() {
        return matr_pes_iden;
    }

    /**
     * @param matr_pes_iden the matr_pes_iden to set
     */
    public void setMatr_pes_iden(String matr_pes_iden) {
        this.matr_pes_iden = matr_pes_iden;
    }

    /**
     * @return the mat_turm_iden
     */
    public int getMat_turm_iden() {
        return mat_turm_iden;
    }

    /**
     * @param mat_turm_iden the mat_turm_iden to set
     */
    public void setMat_turm_iden(int mat_turm_iden) {
        this.mat_turm_iden = mat_turm_iden;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the mat_curso_iden
     */
    public int getMat_curso_iden() {
        return mat_curso_iden;
    }

    /**
     * @param mat_curso_iden the mat_curso_iden to set
     */
    public void setMat_curso_iden(int mat_curso_iden) {
        this.mat_curso_iden = mat_curso_iden;
    }

}