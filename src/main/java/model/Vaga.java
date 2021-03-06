package model;

import java.util.LinkedList;

public class Vaga {
    private String info;
    private int idVaga;
    private double salario;
    private int cargaHoraria;
    private LinkedList<Usuario> candidatos;

    public Vaga(String info, int idVaga, double salario, int cargaHoraria){
        this.info = info;
        this.idVaga = idVaga;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.candidatos = new LinkedList<Usuario>();
    }

    public String getInfo() {
        return info;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public double getSalario() {
        return salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void adicionaCandidato(Usuario aluno){
        this.candidatos.add(aluno);
    }

    public LinkedList<Usuario> getCandidatos(){
        return this.candidatos;
    }

    @Override
    public String toString() {
        return "Info: " + this.info + "\n ID: " + this.idVaga + "\n Salario: " + this.salario + "\n Carga horaria: " + this.cargaHoraria;
    }
}
