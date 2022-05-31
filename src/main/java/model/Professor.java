package model;

import java.util.Date;

public class Professor extends Usuario{

    public Professor(String nome, String matricula, Date dataDeNascimento, String numero, String email, String senha) {
        super(nome, matricula, dataDeNascimento, numero, email, senha);
    }

    @Override
    public void menu() {
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Criar uma oportunidade de estagio");
        System.out.println("2 - Aceitar um aluno em um estagio");
        System.out.println("3 - Atualizar uma vaga");
        System.out.println("4 - Atualizar dados de um aluno");
        System.out.println("5 - Ver todos alunos");
        System.out.println("6 - Ver todos alunos que estão estagiando");
        System.out.println("7 - Ver todos alunos que não estão estagiando");
        System.out.println("8 - Ver todos alunos de um determinado periodo");
        System.out.println("9 - Ver todas vagas");
        System.out.println("10 - Ver todos contratos");
        System.out.println("11 - Atualizar um contrato");
        System.out.println("12 - Ver candidatados a uma determinada vaga");
        System.out.println("0 - Sair");
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n Matricula: " + this.getMatricula() + "\n Data de nascimento: "
                + this.getDataDeNascimento() + "\n Numero: " + getNumero() + "\n E-mail:" + this.getEmail();
    }
}
