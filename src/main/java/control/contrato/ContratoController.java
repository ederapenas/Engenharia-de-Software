package control.contrato;

import model.*;
import java.util.Scanner;
import java.util.LinkedList;

public class ContratoController implements IContratoController {
    private LinkedList<Contrato> contratos;

    public ContratoController(){
        contratos = new LinkedList<Contrato>();
    }
    @Override
    public boolean criaContrato(Usuario aluno, Usuario professor, Vaga vaga) {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o id que quer designar para o contrato: ");
        int idContrato = input.nextInt();
        while(existeContrato(idContrato)){
            System.out.println("Já existe um contrato com esse id, por favor digite um id valido: ");
            idContrato = input.nextInt();
        }

        Contrato contrato = new Contrato(aluno, vaga, professor, idContrato);
        return this.contratos.add(contrato);
    }

    @Override
    public boolean atualizaContrato(Contrato contrato) {
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o novo id para o contrato: ");
        int idContrato = input.nextInt();
        while(existeContrato(idContrato)){
            System.out.println("Já existe um contrato com esse id, por favor digite um id valido: ");
            idContrato = input.nextInt();
        }
        contrato.setIdContrato(idContrato);
        System.out.println("Id do contrato atualizado com sucesso!");
        return true;
    }

    @Override
    public boolean deletaContrato(Contrato contrato) {
        return contratos.remove(contrato);
    }

    @Override
    public Contrato getContrato(int idContrato) {
        Contrato contrato = null;

        for(int i = 0; i < this.contratos.size(); i++){
            if(this.contratos.get(i).getIdContrato() == idContrato){
                contrato = this.contratos.get(i);
                return contrato;
            }
        }

        return contrato;
    }

    @Override
    public LinkedList<Contrato> getTodosContratos() {
        return this.contratos;
    }

    public boolean existeContrato(int idContrato){
        for(int i = 0; i < this.contratos.size(); i++){
            if(this.contratos.get(i).getIdContrato() == idContrato){
                return true;
            }
        }

        return false;
    }
}
