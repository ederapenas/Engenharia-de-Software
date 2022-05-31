package control.vaga;

import model.Vaga;
import java.util.Scanner;
import java.util.LinkedList;

public class VagaController implements IVagaController {
    private LinkedList<Vaga> vagas;

    public VagaController(){
        vagas = new LinkedList<Vaga>();
    }

    @Override
    public boolean criaVaga() {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        System.out.println("Informe as informações da vaga:");
        String info = inputString.nextLine();
        System.out.println("Informe o id que deseja alocar para a vaga: ");
        int idVaga = input.nextInt();
        while(existeVaga(idVaga)){
            System.out.println("Já existe uma vaga com esse id, por favor informe outro!");
            idVaga = input.nextInt();
        }
        System.out.println("Informe o salario da vaga: ");
        double salario = input.nextDouble();
        while(salario < 1){
            System.out.println("Por favor, informe um salario que PELO MENOS seja maior ou igual a 1,00 reais.");
            salario = input.nextDouble();
        }
        System.out.println("Informe a carga horaria da vaga: ");
        int cargaHoraria = input.nextInt();

        Vaga vaga = new Vaga(info, idVaga, salario, cargaHoraria);
        return this.vagas.add(vaga);
    }

    @Override
    public boolean atualizaVaga(Vaga vaga) {
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        int op;

        System.out.println("O que você deseja atualizar na vaga?");
        System.out.println("1 - A informação da vaga.");
        System.out.println("2 - O id da vaga");
        System.out.println("3 - O salario da vaga");
        System.out.println("4 - A Carga horaria da vaga");
        System.out.println("0 - Cancelar atualização");
        op = input.nextInt();
        while(op < 0 || op > 4){
            System.out.println("Valor inválido, digite um numero entre 0 e 4.");
            op = input.nextInt();
        }

        switch(op){
            case 1:
                System.out.println("Informe a nova informação da vaga: ");
                String info = inputString.nextLine();
                vaga.setInfo(info);
                System.out.println("Informação da vaga atualizada com sucesso!");
                return true;
            case 2:
                System.out.println("Informe o novo id da vaga: ");
                int idVaga = input.nextInt();
                while(existeVaga(idVaga)){
                    System.out.println("Já existe uma vaga com esse id, por favor informe um id valido.");
                    idVaga = input.nextInt();
                }
                vaga.setIdVaga(idVaga);
                System.out.println("Id da vaga atualizado com sucesso!");
                return true;
            case 3:
                System.out.println("Informe o novo salario da vaga: ");
                double salario = input.nextDouble();
                while(salario < 1){
                    System.out.println("Por favor informe um salario NO MINIMO maior que 1,00 reais");
                    salario = input.nextDouble();
                }
                vaga.setSalario(salario);
                System.out.println("Salario da vaga atualizado com sucesso!");
                return true;
            case 4:
                System.out.println("Informe a nova carga horaria da vaga: ");
                int cargaHoraria = input.nextInt();
                vaga.setCargaHoraria(cargaHoraria);
                System.out.println("Carga horaria da vaga atualizada com sucesso!");
                return true;
            case 0:
                System.out.println("Atualização de vaga cancelada.");
                return true;
            default:
                System.out.println("Pane no sistema alguem me desconfigurou!");
                return false;
        }

    }

    @Override
    public boolean deletaVaga(Vaga vaga) {
        return this.vagas.remove(vaga);
    }

    @Override
    public Vaga getVaga(int idVaga) {
        Vaga vaga = null;

        for(int i = 0; i < this.vagas.size(); i++){
            if(this.vagas.get(i).getIdVaga() == idVaga){
                vaga = this.vagas.get(i);
                return vaga;
            }
        }

        return vaga;
    }

    @Override
    public LinkedList<Vaga> getTodasVagas() {
        return this.vagas;
    }

    public boolean existeVaga(int id){
        for(int i = 0; i < this.vagas.size(); i++){
            if(this.vagas.get(i).getIdVaga() == id){
                return true;
            }
        }

        return false;
    }
}
