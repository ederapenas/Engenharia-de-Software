package control.aluno;

import model.Aluno;
import java.util.LinkedList;

public interface IAlunoController {

    public boolean cadastraAluno();

    public boolean atualizaAluno(Aluno aluno);

    public boolean deletaAluno(Aluno aluno);

    public Aluno getAluno(String matricula);

    public LinkedList<Aluno> getTodosAlunos();
}
