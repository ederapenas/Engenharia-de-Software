package control;

import model.Professor;
import java.util.LinkedList;

public interface IProfessorController {

    public boolean cadastraProfessor();

    public boolean atualizaProfessor();

    public boolean deletaProfessor(String matricula);

    public Professor getProfessor(String matricula);

    public LinkedList<Professor> getTodosProfessores();
}
