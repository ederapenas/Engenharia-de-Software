package model;

import java.util.Date;

public class Professor extends Usuario{

    public Professor(String nome, String matricula, Date dataDeNascimento, String numero, String email) {
        super(nome, matricula, dataDeNascimento, numero, email);
    }
}
