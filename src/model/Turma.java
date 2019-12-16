/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.PersistenciaTurma;
import java.util.ArrayList;

/**
 *
 * @author JON
 */
public class Turma {

    private int turm_iden;
    private int turm_ano;
    private int turm_semestre;
    private String turm_horario;
    private String turm_diasemana;
    private int turm_disc_iden;

    public Turma() {
    }

    public Turma(int turm_iden, int turm_ano, int turm_semestre,
            String turm_horario, String turm_diasemana, int turm_disc_iden) {
        this.turm_iden = turm_iden;
        this.turm_ano = turm_ano;
        this.turm_semestre = turm_semestre;
        this.turm_horario = turm_horario;
        this.turm_diasemana = turm_diasemana;
        this.turm_disc_iden = turm_disc_iden;
    }

    public static ArrayList<Turma> ListarTurma(String sql) {
        // retorna todas as contas cadastradas
        return PersistenciaTurma.ListaTurma(sql);
    }

    public static boolean CadastrarTurma(int turm_iden, int turm_ano,
            int turm_semestre, String turm_horario, String turm_diasemana,
            int turm_disc_iden) {
        Turma turma = new Turma(turm_iden, turm_ano, turm_semestre,
                turm_horario, turm_diasemana, turm_disc_iden);
        return PersistenciaTurma.CadastrarTurma(turma);
    }

    public static boolean AlterarTurma(int turm_iden, int turm_ano,
            int turm_semestre, String turm_horario, String turm_diasemana,
            int turm_disc_iden) {
        Turma turma = new Turma(turm_iden, turm_ano, turm_semestre,
                turm_horario, turm_diasemana, turm_disc_iden);
        return PersistenciaTurma.AlterarTurma(turma);
    }

    /**
     * @return the turm_iden
     */
    public int getTurm_iden() {
        return turm_iden;
    }

    /**
     * @param turm_iden the turm_iden to set
     */
    public void setTurm_iden(int turm_iden) {
        this.turm_iden = turm_iden;
    }

    /**
     * @return the turm_ano
     */
    public int getTurm_ano() {
        return turm_ano;
    }

    /**
     * @param turm_ano the turm_ano to set
     */
    public void setTurm_ano(int turm_ano) {
        this.turm_ano = turm_ano;
    }

    /**
     * @return the turm_semestre
     */
    public int getTurm_semestre() {
        return turm_semestre;
    }

    /**
     * @param turm_semestre the turm_semestre to set
     */
    public void setTurm_semestre(int turm_semestre) {
        this.turm_semestre = turm_semestre;
    }

    /**
     * @return the turm_horario
     */
    public String getTurm_horario() {
        return turm_horario;
    }

    /**
     * @param turm_horario the turm_horario to set
     */
    public void setTurm_horario(String turm_horario) {
        this.turm_horario = turm_horario;
    }

    /**
     * @return the turm_diasemana
     */
    public String getTurm_diasemana() {
        return turm_diasemana;
    }

    /**
     * @param turm_diasemana the turm_diasemana to set
     */
    public void setTurm_diasemana(String turm_diasemana) {
        this.turm_diasemana = turm_diasemana;
    }

    /**
     * @return the turm_disc_iden
     */
    public int getTurm_disc_iden() {
        return turm_disc_iden;
    }

    /**
     * @param turm_disc_iden the turm_disc_iden to set
     */
    public void setTurm_disc_iden(int turm_disc_iden) {
        this.turm_disc_iden = turm_disc_iden;
    }

}
