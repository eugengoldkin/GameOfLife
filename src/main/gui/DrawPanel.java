package main.gui;

import main.Spielfeld;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {


    private static final Color ALIVE = Color.green;
    private static final Color DEAD = Color.black;
    private static final int MIN_HEIGHT = 20;
    private static final int SQUARE_SIZE = 4;
    private static final int SQUARE_DISTANCE = 5;
    Spielfeld spielfeld = null;

    public DrawPanel(){
        super();
        spielfeld = new Spielfeld(20,10);
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(spielfeld != null){
            for(int i = 0; i < spielfeld.getHeight(); i++){
                for(int j = 0; j < spielfeld.getWidth(); j++){
                    if(spielfeld.getCellValue(j,i)){
                        g.setColor(ALIVE);
                    }else{
                        g.setColor(DEAD);
                    }
                    g.drawRect(j*SQUARE_DISTANCE, MIN_HEIGHT+i*SQUARE_DISTANCE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
    }



}
