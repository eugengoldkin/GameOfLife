package main.gui;

import javax.swing.*;

public class Window {

    public static void main(String[] args){
        JFrame jFrame = new JFrame("Game of Life");

        jFrame.setSize(1200,900);

        jFrame.setJMenuBar(getJMenuBar());

        jFrame.add(getDrawPanel());

        jFrame.setVisible(true);
    }

    private static JMenuBar getJMenuBar(){
        JMenuBar menu = new JMenuBar();

        JButton button_next = new JButton("Next");

        menu.add(button_next);

        return menu;
    }

    private static JPanel getDrawPanel(){
        return new DrawPanel();
    }

}
