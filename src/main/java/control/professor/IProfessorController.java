package control.professor;

import model.Professor;
import java.util.LinkedList;

public interface IProfessorController {

    public boolean cadastraProfessor();

    public boolean atualizaProfessor(Professor professor);

    public boolean deletaProfessor(Professor professor);

    public Professor getProfessor(String matricula);

    public LinkedList<Professor> getTodosProfessores();

    public boolean existeProfessor(String matricula);
}
