package model;

import java.util.Date;

public class Aluno extends Usuario{
    private int periodo;
    private boolean estagiando;

    public Aluno(String nome, String matricula, Date dataDeNascimento, String numero, String email, int periodo, boolean estagiando) {
        super(nome, matricula, dataDeNascimento, numero, email);
        this.periodo = periodo;
        this.estagiando = estagiando;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public boolean isEstagiando() {
        return estagiando;
    }

    public void setEstagiando(boolean estagiando) {
        this.estagiando = estagiando;
    }

    @Override
    public void menu() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Ver oportunidades de estágio");
        System.out.println("2 - Se candidatar a um estágio");
        System.out.println("0 - Sair");
    }
}
