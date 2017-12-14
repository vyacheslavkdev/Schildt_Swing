package ru.obj;

import ru.obj.custom.component.MyContentPanel;

import javax.swing.*;

public class CustomCPDemo {
    CustomCPDemo(){
        JFrame frame = new JFrame("Custom ContentPane Demo");
        frame.setSize(240,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyContentPanel());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomCPDemo();
            }
        });
    }
}
