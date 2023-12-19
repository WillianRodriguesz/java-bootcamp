/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.tche.ucpel.bd2.bean;

import java.util.Date;

/**
 *
 * @author willian
 */
public class Matricula {

    private Disciplina disciplina;
    private Aluno aluno;

    public Matricula() {
    }

    public Matricula(Aluno aluno) {
        this.aluno = aluno;
    }

    public Matricula(Disciplina disciplina, Aluno aluno) {
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
