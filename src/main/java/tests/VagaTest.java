package tests;

import model.Vaga;
import model.Aluno;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class VagaTest {

    @Test
    public void verIdVaga(){
        Vaga vaga = new Vaga("pedreiro", 1,24, 360);

        int verId = vaga.getIdVaga();

        assertEquals(1, verId);
    }
    
    @Test
    public void adicionarCandidato(){
        Vaga vaga = new Vaga("pedreiro", 1, 24, 360);
        Date data = new Date(20, 1, 10);
        Aluno aluno = new Aluno("joao", "202", data, "2", "a@email", "123", 4, false);
        Aluno aluno2 = new Aluno("pedro", "31", data, "22", "pedroca@email", "321", 4, false);

        int numeroCandidatos = vaga.getCandidatos().size();

        vaga.adicionaCandidato(aluno);
        vaga.adicionaCandidato(aluno2);

        assertEquals((numeroCandidatos + 2), vaga.getCandidatos().size());

    }

}
