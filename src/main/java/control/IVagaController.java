package control;

import model.Vaga;
import java.util.LinkedList;

public interface IVagaController {

    public boolean criaVaga();

    public boolean atualizaVaga();

    public boolean deletaVaga(int idVaga);

    public Vaga getVaga(int idVaga);

    public LinkedList<Vaga> getTodasVagas();
}
