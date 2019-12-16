/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.PersistenciaCurso;
import java.util.ArrayList;

/**
 *
 * @author JON
 */
public class Curso {
    
    private int curs_iden;
    private String curs_descricao;
    private String curs_coord_iden;
    
    public Curso(){}
    public Curso(int curs_iden, String curs_descricao, String curs_coord_iden) {
        this.curs_iden = curs_iden;
        this.curs_descricao = curs_descricao;
        this.curs_coord_iden = curs_coord_iden;
    }

     public static ArrayList<Curso> ListarCursos(String sql)
    {
        // retorna todas as contas cadastradas
        return PersistenciaCurso.ListaCursos(sql);
    }
    
    public static boolean CadastrarCurso(int curs_iden, String curs_descricao, String curs_coord_iden)
    {
        Curso curso = new Curso(curs_iden, curs_descricao, curs_coord_iden);
        return PersistenciaCurso.CadastraCurso(curso);
    }
    
    public static boolean AlterarCurso(int curs_iden, String curs_descricao, String curs_coord_iden)
    {
        Curso curso = new Curso(curs_iden, curs_descricao, curs_coord_iden);
        return PersistenciaCurso.AlteraCurso(curso);
    }
    
    
    public int getCurs_iden() {
        return curs_iden;
    }

    /**
     * @param curs_iden the curs_iden to set
     */
    public void setCurs_iden(int curs_iden) {
        this.curs_iden = curs_iden;
    }

    /**
     * @return the curs_descricao
     */
    public String getCurs_descricao() {
        return curs_descricao;
    }

    /**
     * @param curs_descricao the curs_descricao to set
     */
    public void setCurs_descricao(String curs_descricao) {
        this.curs_descricao = curs_descricao;
    }

    /**
     * @return the curs_coord_iden
     */
    public String getCurs_coord_iden() {
        return curs_coord_iden;
    }

    /**
     * @param curs_coord_iden the curs_coord_iden to set
     */
    public void setCurs_coord_iden(String curs_coord_iden) {
        this.curs_coord_iden = curs_coord_iden;
    }
    
}
