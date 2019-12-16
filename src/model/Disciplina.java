/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.PersistenciaCurso;
import control.PersistenciaDisciplina;
import java.util.ArrayList;

/**
 *
 * @author JON
 */
public class Disciplina {
    
    private int disc_iden;
    private int disc_curs_iden;
    private String disc_descricao;
    private int disc_preRequesito;
    private int disc_cargaHoraria;
    private String disc_bibliografia;
    private String disc_ementa;
    private String disc_prof_iden;
    
    
    public Disciplina(){}
     public Disciplina(int disc_iden, int disc_curs_iden, String disc_descricao, int disc_preRequesito, int disc_cargaHoraria, String disc_bibliografia, String disc_ementa, String disc_prof_iden) {
        this.disc_iden = disc_iden;
        this.disc_curs_iden = disc_curs_iden;
        this.disc_descricao = disc_descricao;
        this.disc_preRequesito = disc_preRequesito;
        this.disc_cargaHoraria = disc_cargaHoraria;
        this.disc_bibliografia = disc_bibliografia;
        this.disc_ementa = disc_ementa;
        this.disc_prof_iden = disc_prof_iden;
    }

     public static ArrayList<Disciplina> ListarDisciplinas(String sql)
    {
        // retorna todas as contas cadastradas
        return PersistenciaDisciplina.listaDisciplina(sql);
    }
    
    public static boolean CadastrarDisciplina(int disc_iden, int disc_curs_iden, String disc_descricao, int disc_preRequesito, int disc_cargaHoraria, String disc_bibliografia, String disc_ementa, String disc_prof_iden)
    {
        Disciplina disc = new Disciplina(disc_iden, disc_curs_iden, disc_descricao, disc_preRequesito, disc_cargaHoraria, disc_bibliografia, disc_ementa, disc_prof_iden);
        return PersistenciaDisciplina.cadastraDisciplina(disc);
    }
    
    public static boolean AlterarDisciplina(int disc_iden, int disc_curs_iden, String disc_descricao, int disc_preRequesito, int disc_cargaHoraria, String disc_bibliografia, String disc_ementa, String disc_prof_iden)
    {
        Disciplina disc = new Disciplina(disc_iden, disc_curs_iden, disc_descricao, disc_preRequesito, disc_cargaHoraria, disc_bibliografia, disc_ementa, disc_prof_iden);
        return PersistenciaDisciplina.alteraDisciplina(disc);
    }

    /**
     * @return the disc_iden
     */
    public int getDisc_iden() {
        return disc_iden;
    }

    /**
     * @param disc_iden the disc_iden to set
     */
    public void setDisc_iden(int disc_iden) {
        this.disc_iden = disc_iden;
    }

    /**
     * @return the disc_curs_iden
     */
    public int getDisc_curs_iden() {
        return disc_curs_iden;
    }

    /**
     * @param disc_curs_iden the disc_curs_iden to set
     */
    public void setDisc_curs_iden(int disc_curs_iden) {
        this.disc_curs_iden = disc_curs_iden;
    }

    /**
     * @return the disc_descricao
     */
    public String getDisc_descricao() {
        return disc_descricao;
    }

    /**
     * @param disc_descricao the disc_descricao to set
     */
    public void setDisc_descricao(String disc_descricao) {
        this.disc_descricao = disc_descricao;
    }

    /**
     * @return the disc_preRequesito
     */
    public int getDisc_preRequesito() {
        return disc_preRequesito;
    }

    /**
     * @param disc_preRequesito the disc_preRequesito to set
     */
    public void setDisc_preRequesito(int disc_preRequesito) {
        this.disc_preRequesito = disc_preRequesito;
    }

    /**
     * @return the disc_cargaHoraria
     */
    public int getDisc_cargaHoraria() {
        return disc_cargaHoraria;
    }

    /**
     * @param disc_cargaHoraria the disc_cargaHoraria to set
     */
    public void setDisc_cargaHoraria(int disc_cargaHoraria) {
        this.disc_cargaHoraria = disc_cargaHoraria;
    }

    /**
     * @return the disc_bibliografia
     */
    public String getDisc_bibliografia() {
        return disc_bibliografia;
    }

    /**
     * @param disc_bibliografia the disc_bibliografia to set
     */
    public void setDisc_bibliografia(String disc_bibliografia) {
        this.disc_bibliografia = disc_bibliografia;
    }

    /**
     * @return the disc_ementa
     */
    public String getDisc_ementa() {
        return disc_ementa;
    }

    /**
     * @param disc_ementa the disc_ementa to set
     */
    public void setDisc_ementa(String disc_ementa) {
        this.disc_ementa = disc_ementa;
    }

    /**
     * @return the disc_prof_iden
     */
    public String getDisc_prof_iden() {
        return disc_prof_iden;
    }

    /**
     * @param disc_prof_iden the disc_prof_iden to set
     */
    public void setDisc_prof_iden(String disc_prof_iden) {
        this.disc_prof_iden = disc_prof_iden;
    }
    
    @Override
    public String toString() {
        return disc_descricao;
    }
}
