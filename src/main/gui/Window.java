package main.gui;

import main.Simulator;
import main.Spielfeld;

import javax.swing.*;

public class Window {

    static JFrame jFrame;
    static DrawPanel drawPanel;
    static Simulator simulator;
    static Spielfeld spielfeld;
    public static void main(String[] args){
        simulator = new Simulator();
        spielfeld = new Spielfeld(30,20);
        spielfeld.setCellValue(2,2,true);
        spielfeld.setCellValue(2,3,true);
        spielfeld.setCellValue(2,4,true);
        drawPanel = getDrawPanel();

        jFrame = new JFrame("Game of Life");
        jFrame.setSize(1200,900);
        jFrame.setJMenuBar(getJMenuBar());

        drawPanel.setSpielfeld(spielfeld);

        jFrame.add(drawPanel);

        jFrame.setVisible(true);
    }

    private static JMenuBar getJMenuBar(){
        JMenuBar menu = new JMenuBar();

        JButton button_next = new JButton("Next");
        button_next.addActionListener(e -> {
            simulator.iterateSpielfeld(spielfeld);
            drawPanel.repaint();
        });

        menu.add(button_next);

        return menu;
    }

    private static DrawPanel getDrawPanel(){
        return new DrawPanel();
    }

}
