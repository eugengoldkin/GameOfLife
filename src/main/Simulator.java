package main;

public class Simulator {

    public boolean[][] computeNextIteration(Spielfeld spielfeld){
        boolean[][] result = new boolean[spielfeld.getHeight()][spielfeld.getWidth()];
        for(int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){
                result[i][j] = Rules.schroedingerCell(
                        spielfeld.getCellValue(j,i), spielfeld.countActiveNeighbours(j,i));
            }
        }
        return result;
    }

    public void iterateSpielfeld(Spielfeld spielfeld){
        boolean[][] newField = computeNextIteration(spielfeld);
        spielfeld.setField(newField);
    }

}
