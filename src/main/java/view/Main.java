package view;

import model.Aluno;
import model.Professor;
import model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int resLog;
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Login");
            System.out.println("2 - Registrar-se");
            System.out.println("0 - Fechar o programa");

            resLog = input.nextInt();
            while(resLog < 0 || resLog > 2){
                System.out.println("Valor inválido, digite algo entre 0 e 2!");
                resLog = input.nextInt();
            }

            switch(resLog){
                case 1:
                    break;
                case 2:
                    System.out.println("Você deseja cadastrar um Aluno ou professor?");
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    int op = input.nextInt();
                    while(op < 1 || op > 2){
                        System.out.println("Valor inválido, digite 1 ou 2!");
                        op = input.nextInt();
                    }

                    System.out.println("Informe o nome do usuario:");
                    String nome = inputString.nextLine();

                    System.out.println("Informe a matricula do usuario:");
                    String matricula = inputString.nextLine();

                    System.out.println("Informe o dia do seu nascimento:");
                    int dia = input.nextInt();
                    System.out.println("Informe o mes do seu nascimento (numero):");
                    int mes = input.nextInt();
                    System.out.println("Informe seu ano de nascimento:");
                    int ano = input.nextInt();
                    Date dataNascimento = new Date(ano, mes - 1, dia);

                    System.out.println("Informe o número do usuario:");
                    String numero = inputString.nextLine();

                    System.out.println("Informe o email do usuario:");
                    String email = inputString.nextLine();

                    if(op == 1){
                        System.out.println("Informe o periodo do aluno:");
                        int periodo = input.nextInt();
                        System.out.println("O aluno está estagiando? (Digite S para sim e N para não):");
                        char opEstagiando = input.next().charAt(0);
                        boolean estagiando = Character.toUpperCase(opEstagiando) == 'S';

                        Usuario user = new Aluno(nome, matricula, dataNascimento, numero, email, periodo, estagiando);
                        listaUsuarios.add(user);
                    }else{
                        Usuario user = new Professor(nome, matricula, dataNascimento, numero, email);
                        listaUsuarios.add(user);
                    }

                    System.out.println("Registro realizado com sucesso!");
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Pane no sistema alguem me desconfigurou!");
            }
        }while(resLog != 0);
    }
}
