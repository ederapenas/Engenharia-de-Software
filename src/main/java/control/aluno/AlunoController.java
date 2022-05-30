package control.aluno;

import jdk.swing.interop.SwingInterOpUtils;
import model.Aluno;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class AlunoController implements IAlunoController {

    private LinkedList<Aluno> alunos;

    public AlunoController(){
        alunos = new LinkedList<Aluno>();
    }

    @Override
    public boolean cadastraAluno() {
        Scanner inputString = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do aluno: ");
        String nome = inputString.nextLine();
        System.out.println("Informe a matricula do aluno: ");
        String matricula = inputString.nextLine();
        System.out.println("Informe a data de nascimento do aluno: ");
        Date dataDeNascimento = new Date(inputString.nextLine());
        System.out.println("Informe o numero do aluno: ");
        String numero = inputString.nextLine();
        System.out.println("Informe o email do aluno: ");
        String email = inputString.nextLine();
        System.out.println("Informe o periodo do aluno: ");
        int periodo = input.nextInt();
        System.out.println("O aluno já está estagiando? Digite S para sim e N para não");
        char estagiando = Character.toLowerCase(input.next().charAt(0));
        while(estagiando != 's' && estagiando != 'n'){
            System.out.println("Valor invalido, digite S para sim e N para não.");
            estagiando = Character.toLowerCase(input.next().charAt(0));
        }
        boolean estaEstagiando = estagiando == 's';

        if(existeAluno(matricula)){
            System.out.println("Já existe um aluno cadastrado com esta matricula.");
            return false;
        }

        Aluno aluno = new Aluno(nome, matricula, dataDeNascimento, numero, email, periodo, estaEstagiando);
        return alunos.add(aluno);
    }

    @Override
    public boolean atualizaAluno(Aluno aluno) {
        Scanner inputString = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("O que deseja atualizar no aluno?");
        System.out.println("1 - Alterar nome do aluno");
        System.out.println("2 - Alterar matricula do aluno");
        System.out.println("3 - Alterar data de nascimento do aluno");
        System.out.println("4 - Alterar numero do aluno");
        System.out.println("5 - Alterar email do aluno");
        System.out.println("6 - Alterar periodo do aluno");
        System.out.println("7 - Mudar se o aluno está estagiando ou não");
        System.out.println("0 - Cancelar");
        int op = input.nextInt();
        while(op < 0 || op > 7){
            System.out.println("Valor inválido, digite um numero entre 0 e 7.");
            op = input.nextInt();
        }

        switch(op){
            case 1:
                System.out.println("Informe o novo nome do aluno: ");
                String nome = inputString.nextLine();
                aluno.setNome(nome);
                System.out.println("Atualização de nome feita com sucesso!");
                return true;
            case 2:
                System.out.println("Informe a nova matricla do aluno: ");
                String matricula = inputString.nextLine();
                if(existeAluno(matricula)){
                    System.out.println("Já existe um aluno com esta matricula.");
                    return false;
                }
                aluno.setMatricula(matricula);
                System.out.println("Atualização de matricula feita com sucesso!");
                return true;
            case 3:
                System.out.println("Informe a nova data de nascimento do aluno: ");
                Date dataDeNascimento = new Date(inputString.nextLine());
                aluno.setDataDeNascimento(dataDeNascimento);
                System.out.println("Atualização de data de nascimento feita com sucesso!");
                return true;
            case 4:
                System.out.println("Informe o novo numero do aluno: ");
                String numero = inputString.nextLine();
                aluno.setNumero(numero);
                System.out.println("Atualização de numero feita com sucesso!");
                return true;
            case 5:
                System.out.println("Informe o novo email do aluno: ");
                String email = inputString.nextLine();
                aluno.setEmail(email);
                System.out.println("Atualização de email feita com sucesso!");
                return true;
            case 6:
                System.out.println("Informe o novo periodo do aluno: ");
                int periodo = input.nextInt();
                aluno.setPeriodo(periodo);
                System.out.println("Atualização de periodo feita com sucesso!");
                return true;
            case 7:
                aluno.setEstagiando(!aluno.isEstagiando());
                System.out.println("Atualização de estagio feita com sucesso!");
                return true;
            case 0:
                System.out.println("Atualização de aluno cancelada!");
                return true;
            default:
                System.out.println("Pane no sistema alguem me desconfigurou!");
                return false;
        }
    }

    @Override
    public boolean deletaAluno(Aluno aluno) {
        return alunos.remove(aluno);
    }

    @Override
    public Aluno getAluno(String matricula) {
        Aluno aluno = null;

        for(int i = 0; i < this.alunos.size(); i++){
            if(this.alunos.get(i).getMatricula().equalsIgnoreCase(matricula)){
                aluno = this.alunos.get(i);
            }
        }

        return aluno;
    }

    @Override
    public LinkedList<Aluno> getTodosAlunos() {
        return this.alunos;
    }

    public boolean existeAluno(String matricula){
        for(int i = 0; i < this.alunos.size(); i++){
            if(this.alunos.get(i).getMatricula().equalsIgnoreCase(matricula)){
                return false;
            }
        }

        return true;
    }
}
