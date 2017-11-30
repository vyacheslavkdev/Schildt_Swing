package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDemo implements ActionListener {

    JTextField txtFld;
    JLabel lbl;

    TextDemo(){
        JFrame frame = new JFrame("Text Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        txtFld = new JTextField(10);
        frame.getContentPane().add(txtFld);
        txtFld.addActionListener(this);

        lbl = new JLabel("");
        frame.getContentPane().add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        lbl.setText(txtFld.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextDemo();
            }
        });
    }
}
