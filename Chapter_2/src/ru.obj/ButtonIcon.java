import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonIcon {
    JLabel lbl;
    JButton btnFirst;
    JButton btnSecond;

    ButtonIcon(){
        ImageIcon myIcon = new ImageIcon(this.getClass().getResource("img/icon.jpg"));
        ImageIcon myDisIcon = new ImageIcon(this.getClass().getResource("img/disIcon.jpg"));
        ImageIcon roIcon = new ImageIcon(this.getClass().getResource("img/roIcon.jpg"));
        ImageIcon pIcon = new ImageIcon(this.getClass().getResource("img/pIcon.jpg"));

        JFrame frame = new JFrame("Button Icon");
        frame.setSize(300,150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl = new JLabel("Press a button");

        btnFirst = new JButton("<html>Press<br>me", myIcon);
        btnFirst.setActionCommand("First");
        btnFirst.setMnemonic('f');
        btnFirst.setRolloverIcon(roIcon);
        btnFirst.setPressedIcon(pIcon);
        btnFirst.setDisabledIcon(myDisIcon);

        btnSecond = new JButton("Second", myIcon);
        btnSecond.setRolloverIcon(roIcon);
        btnSecond.setPressedIcon(pIcon);
        btnSecond.setDisabledIcon(myDisIcon);

        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("First button was presed");
                if(btnSecond.isEnabled()){
                    btnSecond.setEnabled(false);
                    lbl.setText("Second button disabled");
                } else {
                    btnSecond.setEnabled(true);
                    lbl.setText("Second button enabled");
                }
            }
        });
        btnSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Second button was pressed");
            }
        });

        frame.add(btnFirst);
        frame.add(btnSecond);
        frame.getRootPane().setDefaultButton(btnSecond);
        frame.add(lbl);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonIcon();
            }
        });
    }
}
