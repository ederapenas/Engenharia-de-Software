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
                    System.out.println("Lembre-se: para se cadastrar, sua matricula já deve ter sido registrada por um professor ou admin!");
                    System.out.println("Você é um professor ou um aluno?");
                    System.out.println("1 - Professor");
                    System.out.println("2 - Aluno");
                    int opPA = input.nextInt();
                    while(opPa < 1 || opPa > 2){
                        System.out.println("Opção inválida, digite 1 ou 2.");
                        opPA = input.nextInt();
                    }
                    if(opPA == 1){

                    }else{

                    }
                case 0:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Pane no sistema alguem me desconfigurou!");
            }
        }while(resLog != 0);
    }
}
