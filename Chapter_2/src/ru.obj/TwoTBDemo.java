import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TwoTBDemo implements ItemListener {
    JLabel lblAlpha;
    JLabel lblBeta;
    JToggleButton btnAlhpa;
    JToggleButton btnBeta;

    TwoTBDemo(){
        JFrame frame = new JFrame("Two Toggle Button Demo");
        frame.setSize(350,150);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblAlpha = new JLabel("Alpah is off");
        lblBeta = new JLabel("Beta is off");

        btnAlhpa = new JToggleButton("Alpha");
        btnBeta = new JToggleButton("Beta");

        btnAlhpa.addItemListener(this);
        btnBeta.addItemListener(this);

        frame.add(btnAlhpa);
        frame.add(lblAlpha);
        frame.add(btnBeta);
        frame.add(lblBeta);

        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JToggleButton tb = (JToggleButton) e.getItem();

        if (tb == btnAlhpa){
            if(tb.isSelected()){
                lblAlpha.setText("Alpha is on");
            } else{
                lblAlpha.setText("Alpha is off");
            }
        } else{
            if (tb.isSelected()){
                lblBeta.setText("Beta is on");
            } else {
                lblBeta.setText("Beta is off");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TwoTBDemo();
            }
        });
    }
}
