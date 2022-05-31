package control.contrato;

import model.Aluno;
import model.Contrato;
import model.Professor;
import model.Vaga;
import java.util.LinkedList;

public interface IContratoController {

    public boolean criaContrato(Aluno aluno, Professor professor, Vaga vaga);

    public boolean atualizaContrato(Contrato contrato);

    public boolean deletaContrato(Contrato contrato);

    public Contrato getContrato(int idContrato);

    public LinkedList<Contrato> getTodosContratos();
}
