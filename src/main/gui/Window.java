package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {


    static DrawPanel drawPanel;

    public static void main(String[] args){
        JFrame jFrame = new JFrame("Game of Life");

        jFrame.setSize(1200,900);

        jFrame.setJMenuBar(getJMenuBar());

        drawPanel = getDrawPanel();
        jFrame.add(drawPanel);

        jFrame.setVisible(true);
    }

    private static JMenuBar getJMenuBar(){
        JMenuBar menu = new JMenuBar();

        JButton button_next = new JButton("Next");
        button_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        menu.add(button_next);

        return menu;
    }

    private static DrawPanel getDrawPanel(){
        return new DrawPanel();
    }

}
