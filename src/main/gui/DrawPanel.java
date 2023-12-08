package main.gui;

import main.Spielfeld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel {


    private static final Color ALIVE = new Color(0,160,0);
    private static final Color DEAD = Color.black;
    private static final int MIN_HEIGHT = 0;
    private static final int SQUARE_SIZE = 8;
    private static final int SQUARE_DISTANCE = 9;
    Spielfeld spielfeld;

    public DrawPanel(){
        super();
        spielfeld = new Spielfeld(20,10);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/SQUARE_DISTANCE;
                int y = e.getY()/SQUARE_DISTANCE;
                spielfeld.setCellValue(x,y, true);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

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
                    g.fillRect(j*SQUARE_DISTANCE, MIN_HEIGHT+i*SQUARE_DISTANCE, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
    }



}
