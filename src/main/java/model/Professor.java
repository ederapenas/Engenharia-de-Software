package model;

import java.util.Date;

public class Professor extends Usuario{

    public Professor(String nome, String matricula, Date dataDeNascimento, String numero, String email, String senha) {
        super(nome, matricula, dataDeNascimento, numero, email, senha);
    }

    @Override
    public void menu() {
        System.out.println("O que deseja fazer?");
        System.out.println("Criar uma oportunidade de estagio");
        System.out.println("Aceitar um aluno em um estagio");
        System.out.println("0 - Sair");
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n Matricula: " + this.getMatricula() + "\n Data de nascimento: "
                + this.getDataDeNascimento() + "\n Numero: " + getNumero() + "\n E-mail:" + this.getEmail();
    }
}
