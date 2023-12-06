package test;

import main.Rules;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RulesTest {

    @Test
    public void shouldTrueWhenThreeActiveNeighbours(){
        assertTrue(Rules.schroedingerCell(true, 3));
        assertTrue(Rules.schroedingerCell(false, 3));
    }

    @Test
    public void shouldFieldValueWhenTwoActiveNeighboursAndLivingField(){
        assertTrue(Rules.schroedingerCell(true, 2));
        assertFalse(Rules.schroedingerCell(false, 2));
    }

    @Test
    public void shouldBeFalseWhenUpToOneActiveNeighbours(){
        assertFalse(Rules.schroedingerCell(true, 0));
        assertFalse(Rules.schroedingerCell(false, 0));
        assertFalse(Rules.schroedingerCell(true, 1));
        assertFalse(Rules.schroedingerCell(false, 1));
    }

    @Test
    public void shouldBeFalseWhenAtLeastFourActiveNeighbours(){
        assertFalse(Rules.schroedingerCell(true, 4));
        assertFalse(Rules.schroedingerCell(true, 5));
        assertFalse(Rules.schroedingerCell(true, 6));
        assertFalse(Rules.schroedingerCell(true, 7));
        assertFalse(Rules.schroedingerCell(true, 8));
        assertFalse(Rules.schroedingerCell(false, 4));
        assertFalse(Rules.schroedingerCell(false, 5));
        assertFalse(Rules.schroedingerCell(false, 6));
        assertFalse(Rules.schroedingerCell(false, 7));
        assertFalse(Rules.schroedingerCell(false, 8));
    }


}
