package model;

public class Contrato {
    private Usuario aluno;
    private Vaga vaga;
    private Usuario professor;

    private int idContrato;

    public Contrato(Usuario aluno, Vaga vaga, Usuario professor, int idContrato){
        this.aluno = aluno;
        this.vaga = vaga;
        this.professor = professor;
        this.idContrato = idContrato;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    @Override
    public String toString() {
        return "Nome do aluno: " + this.aluno.getNome() + "\n Nome do professor: " + this.professor.getNome() + "\n ID da vaga: "
                + this.vaga.getIdVaga() + "\n ID do contrato: " + this.idContrato;
    }
}
