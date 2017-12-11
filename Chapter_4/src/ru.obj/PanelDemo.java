package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDemo implements ActionListener {

    JLabel lbl;
    JButton btnAlpha;
    JButton btnBeta;

    PanelDemo(){
        JFrame frame = new JFrame("Panel Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(210,210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAlpha = new JButton("Alpha");
        btnAlpha.addActionListener(this);

        btnBeta = new JButton("Beta");
        btnBeta.addActionListener(this);

        lbl = new JLabel("Press a button");

        JPanel pnl1 = new JPanel();
        pnl1.setPreferredSize(new Dimension(100,100));
        pnl1.setOpaque(true);
        pnl1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        pnl1.add(btnAlpha);
        pnl1.add(btnBeta);
        pnl1.add(lbl);

        JPanel pnl2 = new JPanel();
        pnl2.setPreferredSize(new Dimension(100,60));
        pnl2.setOpaque(true);
        pnl2.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnl2.add(new JLabel("One"));
        pnl2.add(new JLabel("Two"));
        pnl2.add(new JLabel("Three"));

        frame.add(pnl1);
        frame.add(pnl2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Alpha")){
            lbl.setText("Alpha pressed");
        } else if (e.getActionCommand().equals("Beta")){
            lbl.setText("Beta pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelDemo();
            }
        });
    }
}
