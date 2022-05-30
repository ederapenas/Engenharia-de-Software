package control.contrato;

import model.Contrato;
import java.util.LinkedList;

public interface IContratoController {

    public boolean criaContrato();

    public boolean atualizaContrato(Contrato contrato);

    public boolean deletaContrato(Contrato contrato);

    public Contrato getContrato(int idContrato);

    public LinkedList<Contrato> getTodosContratos();
}
