package view;

import control.aluno.AlunoController;
import control.professor.ProfessorController;
import model.Aluno;
import model.Professor;
import model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import control.aluno.IAlunoController;
import control.professor.IProfessorController;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int resLog, opPA;
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        IAlunoController alunoController = new AlunoController();
        IProfessorController professorController = new ProfessorController();
        Usuario usuarioAtual;

        do{
            menuInicio();
            resLog = input.nextInt();
            while(resLog < 0 || resLog > 2){
                System.out.println("Valor inválido, digite algo entre 0 e 2!");
                resLog = input.nextInt();
            }

            switch(resLog){
                case 1:
                    System.out.println("Você é um professor ou um aluno?");
                    System.out.println("1 - Professor");
                    System.out.println("2 - Aluno");
                    opPA = input.nextInt();
                    while(opPA < 1 || opPA > 2){
                        System.out.println("Opção inválida, digite 1 ou 2.");
                        opPA = input.nextInt();
                    }
                    System.out.println("Informe sua matricula: ");
                    String matricula = inputString.nextLine();
                    System.out.println("Informe sua senha: ");
                    String senha = inputString.nextLine();
                    if(opPA == 1){
                        if(!(professorController.existeProfessor(matricula))){
                            System.out.println("Matricula inválida!");
                            break;
                        }
                        else{
                            if(professorController.getProfessor(matricula).getSenha().equals(senha)){
                                usuarioAtual = professorController.getProfessor(matricula);
                                segundoMenu(usuarioAtual);
                            }else{
                                System.out.println("Senha inválida!");
                                break;
                            }
                        }
                    }else{
                        if(!(alunoController.existeAluno(matricula))){
                            System.out.println("Matricula inválida!");
                            break;
                        }
                        else{
                            if(alunoController.getAluno(matricula).getSenha().equals(senha)){
                                usuarioAtual = alunoController.getAluno(matricula);
                                segundoMenu(usuarioAtual);
                            }
                            else{
                                System.out.println("Senha inválida!");
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Você é um professor ou um aluno?");
                    System.out.println("1 - Professor");
                    System.out.println("2 - Aluno");
                    opPA = input.nextInt();
                    while(opPA < 1 || opPA > 2){
                        System.out.println("Opção inválida, digite 1 ou 2.");
                        opPA = input.nextInt();
                    }
                    if(opPA == 1){
                        professorController.cadastraProfessor();
                    }else{
                        alunoController.cadastraAluno();
                    }
                case 0:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Pane no sistema alguem me desconfigurou!");
            }
        }while(resLog != 0);
    }

    public static void menuInicio(){
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Login");
        System.out.println("2 - Registrar-se");
        System.out.println("0 - Fechar o programa");
    }

    public static void segundoMenu(Usuario usuarioAtual){
        Scanner input = new Scanner(System.in);
        int op;

        do{
            usuarioAtual.menu();
            op = input.nextInt();
            if(usuarioAtual.getClass().equals(Aluno.class)){

            }else{
                
            }
        }while(op != 0);
    }
}
