package model;

import java.util.Date;

public abstract class Usuario {
    private String nome;
    private String matricula;
    private String senha;
    private Date dataDeNascimento;
    private String numero;
    private String email;

    public Usuario(String nome, String matricula, Date dataDeNascimento, String numero, String email, String senha){
        this.nome = nome;
        this.matricula = matricula;
        this.dataDeNascimento = dataDeNascimento;
        this.numero = numero;
        this.email = email;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public abstract void menu();

    public abstract String toString();
}
