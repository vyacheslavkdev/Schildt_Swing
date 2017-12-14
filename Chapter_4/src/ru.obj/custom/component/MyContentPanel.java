package ru.obj.custom.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyContentPanel extends JPanel {

    JLabel lbl;
    JButton btnRed;
    JButton btnBlue;

    public MyContentPanel(){
        this.setOpaque(true);
        this.setBorder(BorderFactory.createEtchedBorder(Color.GREEN,Color.LIGHT_GRAY));
        lbl = new JLabel("Select Border Color");
        btnRed = new JButton("Red");
        btnBlue = new JButton("Blue");

        btnRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBorder(BorderFactory.createEtchedBorder(Color.RED,Color.LIGHT_GRAY));
                lbl.setText("Red border selected");
            }
        });

        btnBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.LIGHT_GRAY));
                lbl.setText("Blue border selected");
            }
        });


        this.add(btnRed);
        this.add(btnBlue);
        this.add(lbl);
    }
}
