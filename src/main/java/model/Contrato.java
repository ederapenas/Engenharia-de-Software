package model;

public class Contrato {
    private Aluno aluno;
    private Vaga vaga;
    private Professor professor;

    private int idContrato;

    public Contrato(Aluno aluno, Vaga vaga, Professor professor, int idContrato){
        this.aluno = aluno;
        this.vaga = vaga;
        this.professor = professor;
        this.idContrato = idContrato;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }
}
