package ru.obj;

import javax.swing.*;

public class SwingDemo {
    public SwingDemo(){
        JFrame frame = new JFrame("Test Frame");
        frame.setSize(350,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("It is JLabel");
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
