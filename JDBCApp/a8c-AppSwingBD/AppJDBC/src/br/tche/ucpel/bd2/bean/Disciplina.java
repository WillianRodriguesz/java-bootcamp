/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.bean;

/**
 *
 * @author willian
 */
public class Disciplina {

    private int cod;
    private String nome;
    private int turma;
    private int numALunos;
    private int cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public Disciplina(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getNumAlunos() {
        return numALunos;
    }

    public void setNumAlunos(int numALunos) {
        this.numALunos = numALunos;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
