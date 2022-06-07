package tests;

import model.*;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class ContratoTest {


    @Test
    public void verIdCOntrato(){
        Date data = new Date(20, 1, 10);
        Professor prof = new Professor("leuson", "20", data, "1","leuson@unicap","23");
        Aluno aluno = new Aluno("joao", "202", data, "2", "a@email", "23", 4, true);
        Vaga vaga = new Vaga("pedrero", 1,24, 360);

        Contrato contrato = new Contrato(aluno, vaga, prof,1);

        String nomeProfessor = contrato.getProfessor().getNome();

        assertEquals("leuson", nomeProfessor);
    }
}
