package control.contrato;

import model.Usuario;
import model.Contrato;
import model.Vaga;
import java.util.LinkedList;

public interface IContratoController {

    public boolean criaContrato(Usuario aluno, Usuario professor, Vaga vaga);

    public boolean atualizaContrato(Contrato contrato);

    public boolean deletaContrato(Contrato contrato);

    public Contrato getContrato(int idContrato);

    public LinkedList<Contrato> getTodosContratos();

    public boolean existeContrato(int idContrato);
}
