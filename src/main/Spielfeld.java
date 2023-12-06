package main;

public class Spielfeld {

    final static int MAX_WIDTH = 3800;
    final static int MAX_HEIGTH = 1900;
    final static int MIN_WIDTH = 1;
    final static int MIN_HEIGTH = 1;

    boolean [][] field;

    public Spielfeld(int width, int height){
        if(width < MIN_WIDTH || height < MIN_HEIGTH){
            throw new IllegalArgumentException("Stuff too small");
        }
        if(width > MAX_WIDTH || height > MAX_HEIGTH){
            throw new IllegalArgumentException("Stuff too small");
        }
        field = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = false;
            }
        }
    }

    public int getWidth(){
        return field[0].length;
    }

    public int getHeight(){
        return field.length;
    }

    public boolean getCellValue(int width, int height){
        if(isOutOfBounds(width,height)){
            return false;
        }
        return field[height][width];
    }

    public void setCellValue(int width, int height, boolean newValue){
        if(isOutOfBounds(width,height)){
            return;
        }
        field[height][width] = newValue;
    }

    public int countActiveNeighbours(int width, int height){
        int result = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i!=0 || j!=0){
                    if(getCellValue(height+i, width+j)){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private boolean isOutOfBounds(int width, int height){
        return width < 0 || width >= field[0].length || height < 0 || height >= field.length;
    }

}
