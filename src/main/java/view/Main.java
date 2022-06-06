package view;

import control.aluno.AlunoController;
import control.contrato.ContratoController;
import control.contrato.IContratoController;
import control.professor.ProfessorController;
import control.vaga.IVagaController;
import control.vaga.VagaController;
import model.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
        IContratoController contratoController = new ContratoController();
        IVagaController vagaController = new VagaController();

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
                                segundoMenu(usuarioAtual, vagaController, contratoController, alunoController);
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
                                segundoMenu(usuarioAtual, vagaController, contratoController, alunoController);
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
                    break;
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

    public static void segundoMenu(Usuario usuarioAtual, IVagaController vagaController, IContratoController contratoController, IAlunoController alunoController){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int op;

        do{
            usuarioAtual.menu();
            op = input.nextInt();
            if(usuarioAtual.getClass().equals(Aluno.class)){
                while(op < 0 || op > 2){
                    System.out.println("Valor inválido. Informe um valor entre 0 e 2: ");
                    op = input.nextInt();
                }

                switch(op){
                    case 1:
                        LinkedList<Vaga> vagasDisponiveis = vagaController.getTodasVagas();

                        for(int i = 0; i < vagasDisponiveis.size(); i++){
                            System.out.println(vagasDisponiveis.get(i));
                        }
                        break;
                    case 2:
                        System.out.println("Informe o id da vaga que você quer se candidatar: ");
                        int idVaga = input.nextInt();
                        while(!vagaController.existeVaga(idVaga)){
                            System.out.println("Não existe uma vaga com esse id, informe um id valido!");
                            idVaga = input.nextInt();
                        }

                        Vaga vaga = vagaController.getVaga(idVaga);
                        LinkedList<Usuario> candidatados = vaga.getCandidatos();
                        boolean jaEstaCandidatado = false;

                        for(int i = 0; i < candidatados.size(); i++){
                            if(usuarioAtual.getMatricula().equalsIgnoreCase(candidatados.get(i).getMatricula())){
                                jaEstaCandidatado = true;
                            }
                        }

                        if(jaEstaCandidatado){
                            System.out.println("Você já está candidatado a esta vaga!");
                        }
                        else{
                            vaga.adicionaCandidato(usuarioAtual);
                            System.out.println("Você se candidatou para essa vaga com sucesso!");
                        }
                        break;
                    case 0:
                        System.out.println("Logout feito com sucesso!");
                        break;
                    default:
                        System.out.println("Pane no sistema alguem me desconfigurou");
                }

            }else if(usuarioAtual.getClass().equals(Professor.class)){
                while(op < 0 || op > 12){
                    System.out.println("Valor inválido. Informe um valor entre 0 e 12");
                    op = input.nextInt();
                }

                switch(op){
                    case 1:
                        vagaController.criaVaga();
                        break;
                    case 2:
                        System.out.println("Digite o id da vaga: ");
                        int idVaga = input.nextInt();
                        while(!vagaController.existeVaga(idVaga)){
                            System.out.println("Não existe uma vaga com esse id, por favor insira um id valido.");
                            idVaga = input.nextInt();
                        }

                        Vaga vaga = vagaController.getVaga(idVaga);
                        LinkedList<Usuario> candidatos = vaga.getCandidatos();

                        System.out.println("Informe a matricula do aluno que deseja aceitar na vaga: ");
                        String matricula = inputString.nextLine();
                        boolean estaCandidatado = false;

                        for(int i = 0; i < candidatos.size(); i++){
                            if(candidatos.get(i).getMatricula().equalsIgnoreCase(matricula)){
                                estaCandidatado = true;
                                Usuario aluno = candidatos.get(i);
                                contratoController.criaContrato(aluno, usuarioAtual, vaga);
                                vagaController.deletaVaga(vaga);
                            }
                        }

                        if(!estaCandidatado){
                            System.out.println("Esse aluno não está candidatado a esta vaga!");
                        }
                        break;
                    case 3:
                        System.out.println("Informe o id da vaga: ");
                        idVaga = input.nextInt();
                        while(!vagaController.existeVaga(idVaga)){
                            System.out.println("Não existe uma vaga com esse id, por favor informe um id valido");
                            idVaga = input.nextInt();
                        }

                        vagaController.atualizaVaga(vagaController.getVaga(idVaga));
                        break;
                    case 4:
                        System.out.println("Informe a matricula do aluno: ");
                        matricula = inputString.nextLine();
                        while(!alunoController.existeAluno(matricula)){
                            System.out.println("Não existe um aluno com esta matricula, informe uma matricula valida");
                        }

                        alunoController.atualizaAluno(alunoController.getAluno(matricula));
                        break;
                    case 5:
                        LinkedList<Aluno> alunos = alunoController.getTodosAlunos();
                        for(int i = 0; i < alunos.size(); i++){
                            System.out.println(alunos.get(i));
                        }
                        break;
                    case 6:
                        LinkedList<Aluno> alunosEstagiando = alunoController.getTodosAlunosEstagiando();
                        for(int i = 0; i < alunosEstagiando.size(); i++){
                            System.out.println(alunosEstagiando.get(i));
                        }
                        break;
                    case 7:
                        LinkedList<Aluno> alunosNaoEstagiando = alunoController.getTodosAlunosNaoEstagiando();
                        for(int i = 0; i < alunosNaoEstagiando.size(); i++){
                            System.out.println(alunosNaoEstagiando.get(i));
                        }
                        break;
                    case 8:
                        System.out.println("Informe o periodo que deseja ver os alunos cadastrados: ");
                        int periodo = input.nextInt();
                        LinkedList<Aluno> alunosPeriodo = alunoController.getAlunosPeriodo(periodo);
                        for(int i = 0; i < alunosPeriodo.size(); i++){
                            System.out.println(alunosPeriodo.get(i));
                        }
                        break;
                    case 9:
                        LinkedList<Vaga> vagas = vagaController.getTodasVagas();
                        for(int i = 0; i < vagas.size(); i++){
                            System.out.println(vagas.get(i));
                        }
                        break;
                    case 10:
                        LinkedList<Contrato> contratos = contratoController.getTodosContratos();
                        for(int i = 0; i < contratos.size(); i++){
                            System.out.println(contratos.get(i));
                        }
                        break;
                    case 11:
                        System.out.println("Informe o id do contrato que você deseja atualizar: ");
                        int idContrato = input.nextInt();
                        while(!contratoController.existeContrato(idContrato)){
                            System.out.println("Não existe um contrato com esse id, informe um id valido!");
                            idContrato = input.nextInt();
                        }

                        contratoController.atualizaContrato(contratoController.getContrato(idContrato));
                        break;
                    case 12:
                        System.out.println("Informe o id da vaga: ");
                        idVaga = input.nextInt();
                        while(!vagaController.existeVaga(idVaga)){
                            System.out.println("Não existe uma vaga com esse id, informe um id valido!");
                            idVaga = input.nextInt();
                        }

                        LinkedList<Usuario> candidatosVaga = vagaController.getVaga(idVaga).getCandidatos();

                        for(int i = 0; i < candidatosVaga.size(); i++){
                            System.out.println(candidatosVaga.get(i));
                        }
                    case 0:
                        System.out.println("Logout feito com sucesso.");
                        break;
                    default:
                        System.out.println("Pane no sistema alguem me desconfigurou.");
                }
            }
        }while(op != 0);
    }
}
