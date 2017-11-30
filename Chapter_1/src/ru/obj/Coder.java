package ru.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coder implements ActionListener {
    JTextField plainText;
    JTextField chiperText;

    Coder(){
        JFrame frame = new JFrame("Coder");
        frame.setLayout(new FlowLayout());
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPlainText = new JLabel("plain text");
        JLabel lblChiperText = new JLabel("chiper text");

        plainText = new JTextField(20);
        chiperText = new JTextField(20);
        plainText.setActionCommand("Encode");
        chiperText.setActionCommand("Decode");
        plainText.addActionListener(this);
        chiperText.addActionListener(this);

        frame.getContentPane().add(lblPlainText);
        frame.getContentPane().add(plainText);
        frame.getContentPane().add(lblChiperText);
        frame.getContentPane().add(chiperText);

        JButton btnEncode = new JButton("Encode");
        JButton btnDecode = new JButton("Decode");
        JButton btnReset = new JButton("Reset");

        btnEncode.addActionListener(this);
        btnDecode.addActionListener(this);
        btnReset.addActionListener(this);

        frame.getContentPane().add(btnEncode);
        frame.getContentPane().add(btnDecode);
        frame.getContentPane().add(btnReset);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Encode")){
            StringBuilder str = new StringBuilder(plainText.getText());

            for (int i = 0; i < str.length(); i++){
                str.setCharAt(i, (char)(str.charAt(i)+1));
            }
            chiperText.setText(str.toString());
        }
        else if (actionEvent.getActionCommand().equals("Decode")){
            StringBuilder str = new StringBuilder(chiperText.getText());

            for (int i = 0; i < str.length();i++){
                str.setCharAt(i, (char)(str.charAt(i)-1));
            }
            plainText.setText(str.toString());
        }
        else{
            plainText.setText("");
            chiperText.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coder();
            }
        });
    }
}
