import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToggleDemo {
    ToggleDemo(){
        JFrame frame = new JFrame("Toggle button");
        frame.setSize(300,100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn2 = new JButton("new button");

        JToggleButton tbtb = new JToggleButton("Button ON/OFF");
        JLabel lbl = new JLabel("Button is OFf");

        tbtb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (tbtb.isSelected()){
                    lbl.setText("Button is ON");
                } else{
                    lbl.setText("Button if OFF");
                }
            }
        });

        frame.add(tbtb);
        frame.add(btn2);
        frame.add(lbl);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleDemo();
            }
        });
    }
}
