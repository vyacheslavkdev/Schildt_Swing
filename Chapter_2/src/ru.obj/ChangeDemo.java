import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChangeDemo {
    JButton btn;
    JLabel lbl;
    ChangeDemo(){

        JFrame frame = new JFrame("Change Demo");
        frame.setSize(300,150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl = new JLabel();
        btn = new JButton("Press");

        btn.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel bm = btn.getModel();
                String what = "";

                if (bm.isEnabled()) what += "Enabled<br>";
                if (bm.isRollover()) what += "Rollover<br>";
                if (bm.isArmed()) what += "Armed<br>";
                if (bm.isPressed()) what += "Pressed<br>";

                lbl.setText("<html> Current state:<br>" + what);
            }
        });

        frame.add(btn);
        frame.add(lbl);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeDemo();
            }
        });
    }
}
