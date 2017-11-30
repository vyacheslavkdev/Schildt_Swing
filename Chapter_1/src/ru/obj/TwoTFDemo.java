package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoTFDemo implements ActionListener {

    JTextField tf1, tf2;
    JLabel lbl;

    TwoTFDemo(){
        JFrame frame = new JFrame("2Field");
        frame.setSize(500,300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        tf1 = new JTextField(10);
        tf2 = new JTextField(10);

        tf1.addActionListener(this);
        tf2.addActionListener(this);

        tf1.setActionCommand("One");
        tf2.setActionCommand("Two");

        frame.getContentPane().add(tf1);
        frame.getContentPane().add(tf2);

        lbl = new JLabel("text...");
        frame.getContentPane().add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("One")){
            lbl.setText(tf1.getText());
        } else{
            lbl.setText(tf2.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TwoTFDemo();
            }
        });
    }
}
