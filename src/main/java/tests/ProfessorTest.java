package tests;

import model.Professor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Date;

public class ProfessorTest {

    @Test
    public void verMatricula(){
        Date data = new Date(20, 1, 10);
        Professor prof = new Professor("leuson", "20", data, "1","leuson@unicap","23");

        String matri = prof.getMatricula();

        assertEquals("20", matri);
    }
}
