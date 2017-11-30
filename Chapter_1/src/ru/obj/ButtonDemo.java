package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {

    JLabel lbl;

    ButtonDemo(){
        JFrame frame = new JFrame("Button demo frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(250,100);
        frame.setLayout(new FlowLayout());

        JButton btnFst = new JButton("First");
        btnFst.setActionCommand("qwe");
        btnFst.addActionListener(this);
        JButton btnScd = new JButton("Second");
        btnScd.addActionListener(this);
        frame.getContentPane().add(btnFst);
        frame.getContentPane().add(btnScd);

        lbl = new JLabel("Press the button...");
        frame.getContentPane().add(lbl);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("qwe")){
            lbl.setText("First button pressed");
        } else {
            lbl.setText("Second button pressed");
        }
    }

    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });*/
        new ButtonDemo();
    }
}
