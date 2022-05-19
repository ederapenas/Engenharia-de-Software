package model;

import java.util.Date;

public class Professor extends Usuario{

    public Professor(String nome, String matricula, Date dataDeNascimento, String numero, String email) {
        super(nome, matricula, dataDeNascimento, numero, email);
    }

    @Override
    public void menu() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar um aluno");
        System.out.println("2 - ");
        System.out.println("0 - Sair");
    }
}
