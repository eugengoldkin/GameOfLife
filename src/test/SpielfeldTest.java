package test;

import main.Spielfeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpielfeldTest {

    public final static int SPIELFELD_DEFAULT_HEIGHT = 500;
    public final static int SPIELFELD_DEFAULT_WIDTH = 1000;

    Spielfeld spielfeld;

    @BeforeEach
    public void initialize(){
        spielfeld = new Spielfeld(SPIELFELD_DEFAULT_WIDTH, SPIELFELD_DEFAULT_HEIGHT);
    }

    @Test
    public void testEmptySpielfeld(){
        assertEquals(SPIELFELD_DEFAULT_HEIGHT, spielfeld.getHeight());
        assertEquals(SPIELFELD_DEFAULT_WIDTH, spielfeld.getWidth());
    }

    @Test
    public void TooSmallSpielfeld(){
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(0, SPIELFELD_DEFAULT_HEIGHT));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(SPIELFELD_DEFAULT_WIDTH, 0));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(-1, SPIELFELD_DEFAULT_HEIGHT));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(SPIELFELD_DEFAULT_WIDTH, -1));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(-1, -1));
    }

    @Test
    public void TooLargeSpielfeld(){
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(Integer.MAX_VALUE, SPIELFELD_DEFAULT_HEIGHT));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(SPIELFELD_DEFAULT_WIDTH, Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(100000, SPIELFELD_DEFAULT_HEIGHT));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(SPIELFELD_DEFAULT_WIDTH, 100000));
        assertThrows(IllegalArgumentException.class, () -> new Spielfeld(100000, 100000));
    }

    @Test
    public void returnGetValueWhenEmptySpielfeld(){
        for (int i = 0; i < SPIELFELD_DEFAULT_HEIGHT; i++) {
            for (int j = 0; j < SPIELFELD_DEFAULT_WIDTH; j++) {
                assertFalse(spielfeld.getCellValue(j,i));
            }
        }
    }

    @Test
    public void returnGetValueWhenOutsideOfValidRange(){
        assertFalse(spielfeld.getCellValue(1, Integer.MAX_VALUE));
        assertFalse(spielfeld.getCellValue(1, SPIELFELD_DEFAULT_HEIGHT));
        assertFalse(spielfeld.getCellValue(1,-1));
        assertFalse(spielfeld.getCellValue(1,Integer.MIN_VALUE));
        assertFalse(spielfeld.getCellValue(Integer.MAX_VALUE,1));
        assertFalse(spielfeld.getCellValue(SPIELFELD_DEFAULT_WIDTH,1));
        assertFalse(spielfeld.getCellValue(-1,1));
        assertFalse(spielfeld.getCellValue(Integer.MIN_VALUE,1));
    }

    @Test
    public void returnCheckFieldChange(){
        spielfeld.setCellValue(1,1, true);
        assertTrue(spielfeld.getCellValue(1, 1));
        spielfeld.setCellValue(1,1, false);
        assertFalse(spielfeld.getCellValue(1, 1));
    }

    @Test
    public void shouldReturnZeroWhenNoActiveNeighbours(){
        assertEquals(0,spielfeld.countActiveNeighbours(10, 10));
        spielfeld.setCellValue(10,10, true);
        assertEquals(0,spielfeld.countActiveNeighbours(10, 10));
    }

    @Test
    public void shouldReturnZeroWhenOneActiveNeighbours(){
        spielfeld.setCellValue(9,10, true);
        assertEquals(1,spielfeld.countActiveNeighbours(10, 10));
        spielfeld.setCellValue(10,10, true);
        assertEquals(1,spielfeld.countActiveNeighbours(10, 10));
    }



}
