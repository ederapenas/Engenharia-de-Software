package control.vaga;

import model.Vaga;
import java.util.LinkedList;

public interface IVagaController {

    public boolean criaVaga();

    public boolean atualizaVaga(Vaga vaga);

    public boolean deletaVaga(Vaga vaga);

    public Vaga getVaga(int idVaga);

    public LinkedList<Vaga> getTodasVagas();
}
