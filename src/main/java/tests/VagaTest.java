package tests;

import model.Vaga;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VagaTest {

    @Test
    public void verIdVaga(){
        Vaga vaga = new Vaga("pedrero", 1,24, 360);

        int verId = vaga.getIdVaga();

        assertEquals(1, verId);
    }

}
