package control;

import model.Contrato;
import java.util.LinkedList;

public interface IContratoController {

    public boolean criaContrato();

    public boolean atualizaContrato();

    public boolean deletaContrato(int idContrato);

    public Contrato getContrato(int idContrato);

    public LinkedList<Contrato> getTodosContratos();
}
