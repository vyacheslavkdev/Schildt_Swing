import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RBDemo implements ActionListener {

    JLabel lblOptions;
    JLabel lblWhat;
    JCheckBox chbOptions;
    JRadioButton rbSpeed;
    JRadioButton rbSize;
    JRadioButton rbDebug;

    RBDemo(){
        JFrame frame = new JFrame("RadioButton demo");
        frame.setLayout(new GridLayout(6,1));
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chbOptions = new JCheckBox("Enable Options");

        lblOptions = new JLabel("Choose options:");
        lblWhat = new JLabel("Option selected: Speed");

        rbSpeed = new JRadioButton("Maximize Speed", true);
        rbSize = new JRadioButton("Minimize Size");
        rbDebug = new JRadioButton("Debug");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSpeed);
        bg.add(rbSize);
        bg.add(rbDebug);

        rbSpeed.setEnabled(false);
        rbSize.setEnabled(false);
        rbDebug.setEnabled(false);

        chbOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (chbOptions.isSelected()){
                    rbSpeed.setEnabled(true);
                    rbSize.setEnabled(true);
                    rbDebug.setEnabled(true);
                } else{
                    rbSpeed.setEnabled(false);
                    rbSize.setEnabled(false);
                    rbDebug.setEnabled(false);
                }
            }
        });

        rbSpeed.addActionListener(this);
        rbSize.addActionListener(this);
        rbDebug.addActionListener(this);

        frame.add(chbOptions);
        frame.add(lblOptions);

        frame.add(rbSpeed);
        frame.add(rbSize);
        frame.add(rbDebug);
        frame.add(lblWhat);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opt = "";

        if(rbSpeed.isSelected()) opt = "Speed";
        else if (rbSize.isSelected()) opt = "Size";
        else if (rbDebug.isSelected()) opt = "Debug";

        lblWhat.setText("Option selected: " + opt);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RBDemo();
            }
        });
    }
}
