package control.professor;

import control.professor.IProfessorController;
import model.Aluno;
import model.Professor;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ProfessorController implements IProfessorController {
    private LinkedList<Professor> professores;

    public ProfessorController(){
        professores = new LinkedList<Professor>();
    }

    @Override
    public boolean cadastraProfessor() {
        Scanner inputString = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do professor: ");
        String nome = inputString.nextLine();
        System.out.println("Informe a matricula do professor: ");
        String matricula = inputString.nextLine();
        System.out.println("Informe a data de nascimento do professor: ");
        Date dataDeNascimento = new Date(inputString.nextLine());
        System.out.println("Informe o numero do professor: ");
        String numero = inputString.nextLine();
        System.out.println("Informe o email do professor: ");
        String email = inputString.nextLine();

        if(existeProfessor(matricula)){
            System.out.println("Já existe um professor cadastrado com esta matricula.");
            return false;
        }

        System.out.println("Por fim, informe sua senha: ");
        String senha = inputString.nextLine();

        Professor professor = new Professor(nome, matricula, dataDeNascimento, numero, email, senha);
        return professores.add(professor);
    }

    @Override
    public boolean atualizaProfessor(Professor professor) {
        Scanner inputString = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("O que deseja atualizar no professor?");
        System.out.println("1 - Alterar nome do professor");
        System.out.println("2 - Alterar matricula do professor");
        System.out.println("3 - Alterar data de nascimento do professor");
        System.out.println("4 - Alterar numero do professor");
        System.out.println("5 - Alterar email do professor");
        int op = input.nextInt();
        while(op < 0 || op > 5){
            System.out.println("Valor inválido, digite um numero entre 0 e 5.");
            op = input.nextInt();
        }

        switch(op){
            case 1:
                System.out.println("Informe o novo nome do professor: ");
                String nome = inputString.nextLine();
                professor.setNome(nome);
                System.out.println("Atualização de nome feita com sucesso!");
                return true;
            case 2:
                System.out.println("Informe a nova matricla do professor: ");
                String matricula = inputString.nextLine();
                if(existeProfessor(matricula)){
                    System.out.println("Já existe um professor com esta matricula.");
                    return false;
                }
                professor.setMatricula(matricula);
                System.out.println("Atualização de matricula feita com sucesso!");
                return true;
            case 3:
                System.out.println("Informe a nova data de nascimento do professor: ");
                Date dataDeNascimento = new Date(inputString.nextLine());
                professor.setDataDeNascimento(dataDeNascimento);
                System.out.println("Atualização de data de nascimento feita com sucesso!");
                return true;
            case 4:
                System.out.println("Informe o novo numero do professor: ");
                String numero = inputString.nextLine();
                professor.setNumero(numero);
                System.out.println("Atualização de numero feita com sucesso!");
                return true;
            case 5:
                System.out.println("Informe o novo email do aluno: ");
                String email = inputString.nextLine();
                professor.setEmail(email);
                System.out.println("Atualização de email feita com sucesso!");
                return true;
            case 0:
                System.out.println("Atualização de professor cancelada!");
                return true;
            default:
                System.out.println("Pane no sistema me desconfigurou!");
                return false;
        }
    }

    @Override
    public boolean deletaProfessor(Professor professor) {
        return professores.remove(professor);
    }

    @Override
    public Professor getProfessor(String matricula) {
        Professor professor = null;

        for(int i = 0; i < this.professores.size(); i++){
            if(this.professores.get(i).getMatricula().equalsIgnoreCase(matricula)){
                professor = this.professores.get(i);
            }
        }

        return professor;
    }

    @Override
    public LinkedList<Professor> getTodosProfessores() {
        return this.professores;
    }

    public boolean existeProfessor(String matricula){
        for(int i = 0; i < professores.size(); i++){
            if(this.professores.get(i).getMatricula().equalsIgnoreCase(matricula)){
                return true;
            }
        }

        return false;
    }
}
