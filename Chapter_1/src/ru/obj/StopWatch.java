package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class StopWatch implements ActionListener{

    JLabel lbl;
    long start;

    StopWatch(){
        JFrame frame = new JFrame("StopWatch");
        frame.setLayout(new FlowLayout());
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton start = new JButton("Start");
        start.addActionListener(this);
        JButton stop = new JButton("Stop");
        stop.addActionListener(this);

        frame.getContentPane().add(start);
        frame.getContentPane().add(stop);

        lbl = new JLabel("Press Start to begin...");
        frame.getContentPane().add(lbl);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Calendar cal = Calendar.getInstance();

        if (actionEvent.getActionCommand().equals("Start")){
            start = cal.getTimeInMillis();
            System.out.println(start);
            lbl.setText("StopWatch running...");
        } else {
            lbl.setText(Double.toString((double) (cal.getTimeInMillis() - start)/1000));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StopWatch();
            }
        });
    }
}
