package tests;

import model.Aluno;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AlunoTest {

    @Test
    public void verPeriodo() {
        Date data = new Date(20, 1, 10);

        Aluno aluno = new Aluno("joao", "202", data, "2", "a@email", "23", 4, true);

        int periodo = aluno.getPeriodo();

        assertEquals(4, periodo);
    }
}
