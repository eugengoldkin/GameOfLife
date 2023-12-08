package test;

import main.Simulator;
import main.Spielfeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulatorTest {

    public final static int SPIELFELD_DEFAULT_HEIGHT = 5;
    public final static int SPIELFELD_DEFAULT_WIDTH = 5;
    Spielfeld spielfeld;
    Simulator simulator;
    @BeforeEach
    public void initialize(){
        spielfeld = new Spielfeld(SPIELFELD_DEFAULT_WIDTH, SPIELFELD_DEFAULT_HEIGHT);
        simulator = new Simulator();
    }

    @Test
    public void computeNextIteration_threeInALine(){
        spielfeld.setCellValue(1,1, true);
        spielfeld.setCellValue(2,1, true);
        spielfeld.setCellValue(3,1, true);

        boolean[][] newValues = simulator.computeNextIteration(spielfeld);

        assertTrue(newValues[0][2]);
        assertTrue(newValues[1][2]);
        assertTrue(newValues[2][2]);
        assertFalse(newValues[1][1]);
        assertFalse(newValues[1][3]);
    }

    @Test
    public void computeNextIteration_EightInSmallSquare(){
        spielfeld.setCellValue(1,1, true);
        spielfeld.setCellValue(2,1, true);
        spielfeld.setCellValue(3,1, true);
        spielfeld.setCellValue(1,2, true);
        spielfeld.setCellValue(3,2, true);
        spielfeld.setCellValue(1,3, true);
        spielfeld.setCellValue(2,3, true);
        spielfeld.setCellValue(3,3, true);

        boolean[][] newValues = simulator.computeNextIteration(spielfeld);

        assertTrue(newValues[1][1]);
        assertFalse(newValues[1][2]);
        assertTrue(newValues[1][3]);
        assertFalse(newValues[2][1]);
        assertFalse(newValues[2][2]);
        assertFalse(newValues[2][3]);
        assertTrue(newValues[3][1]);
        assertFalse(newValues[3][2]);
        assertTrue(newValues[3][3]);

        assertTrue(newValues[0][2]);
        assertTrue(newValues[4][2]);
        assertTrue(newValues[2][0]);
        assertTrue(newValues[2][4]);

        assertFalse(newValues[0][1]);
        assertFalse(newValues[0][3]);
        assertFalse(newValues[4][1]);
        assertFalse(newValues[4][3]);
        assertFalse(newValues[1][0]);
        assertFalse(newValues[3][0]);
        assertFalse(newValues[1][4]);
        assertFalse(newValues[3][4]);
    }


    @Test
    public void iterateSpielfeld_threeInALine(){
        spielfeld.setCellValue(1,1, true);
        spielfeld.setCellValue(2,1, true);
        spielfeld.setCellValue(3,1, true);

        simulator.iterateSpielfeld(spielfeld);

        assertTrue(spielfeld.getCellValue(2,0));
        assertTrue(spielfeld.getCellValue(2,1));
        assertTrue(spielfeld.getCellValue(2,2));
        assertFalse(spielfeld.getCellValue(1,1));
        assertFalse(spielfeld.getCellValue(3,1));
    }

    @Test
    public void iterateSpielfeld_EightInSmallSquare(){
        spielfeld.setCellValue(1,1, true);
        spielfeld.setCellValue(2,1, true);
        spielfeld.setCellValue(3,1, true);
        spielfeld.setCellValue(1,2, true);
        spielfeld.setCellValue(3,2, true);
        spielfeld.setCellValue(1,3, true);
        spielfeld.setCellValue(2,3, true);
        spielfeld.setCellValue(3,3, true);

        simulator.iterateSpielfeld(spielfeld);

        assertTrue(spielfeld.getCellValue(1,1));
        assertFalse(spielfeld.getCellValue(2,1));
        assertTrue(spielfeld.getCellValue(3,1));
        assertFalse(spielfeld.getCellValue(2,1));
        assertFalse(spielfeld.getCellValue(2,2));
        assertFalse(spielfeld.getCellValue(3,2));
        assertTrue(spielfeld.getCellValue(3,1));
        assertFalse(spielfeld.getCellValue(3,2));
        assertTrue(spielfeld.getCellValue(3,3));

        assertTrue(spielfeld.getCellValue(2,0));
        assertTrue(spielfeld.getCellValue(2,4));
        assertTrue(spielfeld.getCellValue(0,2));
        assertTrue(spielfeld.getCellValue(4,2));

        assertFalse(spielfeld.getCellValue(1,0));
        assertFalse(spielfeld.getCellValue(3,0));
        assertFalse(spielfeld.getCellValue(1,4));
        assertFalse(spielfeld.getCellValue(3,4));
        assertFalse(spielfeld.getCellValue(0,1));
        assertFalse(spielfeld.getCellValue(0,3));
        assertFalse(spielfeld.getCellValue(4,1));
        assertFalse(spielfeld.getCellValue(4,3));
    }


}
