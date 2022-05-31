package model;

import java.util.Date;

public class Aluno extends Usuario{
    private int periodo;
    private boolean estagiando;

    public Aluno(String nome, String matricula, Date dataDeNascimento, String numero, String email, String senha, int periodo, boolean estagiando) {
        super(nome, matricula, dataDeNascimento, numero, email, senha);
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
        System.out.println("0 - Sair e fazer log out");
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n Matricula: " + this.getMatricula() + "\n Data de nascimento: "
                + this.getDataDeNascimento() + "\n Numero: " + this.getNumero() + "\n E-mail: "
                + this.getEmail() + "\n Periodo: " + this.periodo + "\n Está estagiando? " + this.estagiando;
    }
}
