package edu.pingpong.behaviour;

import edu.pingpong.domain.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

public class FastBreakTruckTest {

    @Test
    public void eyeHolesTest(){
        assertEquals(2,FastBreakTruck.prepararEyeHoles().getItems().size());
        assertTrue(FastBreakTruck.prepararEyeHoles().getItems().stream().anyMatch(i -> i instanceof Eyeholes));
        assertTrue(FastBreakTruck.prepararEyeHoles().getItems().stream().anyMatch(i -> i instanceof TurbulentJuice));

    }

    @Test
    public void smigglesTest(){
        assertEquals(2,FastBreakTruck.prepararSmiggles().getItems().size());
        assertTrue(FastBreakTruck.prepararSmiggles().getItems().stream().anyMatch(i -> i instanceof Smiggles));
        assertTrue(FastBreakTruck.prepararSmiggles().getItems().stream().anyMatch(i -> i instanceof FleebJuice));

    }

    @Test
    public void incluirJugueteTest(){
        assertFalse(FastBreakTruck.incluirJuguete(FastBreakTruck.prepararSmiggles()));
        assertTrue(FastBreakTruck.incluirJuguete(FastBreakTruck.prepararEyeHoles()));

        Desayuno eyeDes = FastBreakTruck.prepararEyeHoles();
        FastBreakTruck.incluirJuguete(eyeDes);
        assertTrue(eyeDes.getItems().stream().anyMatch(i -> i instanceof Plumbus));

    }
}
