import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxDemo implements ItemListener {

    JLabel lblOptions;
    JLabel lblWhat;
    JLabel lblChange;
    JCheckBox chbOptins;
    JCheckBox chbSpeed;
    JCheckBox chbSize;
    JCheckBox chbDebug;

    CheckBoxDemo(){
        JFrame frame = new JFrame("CheckBox Demo");
        frame.setSize(350,200);
        frame.setLayout(new GridLayout(7,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblOptions = new JLabel("Options");
        lblWhat = new JLabel("Options selected:");
        lblChange = new JLabel("");

        chbOptins = new JCheckBox("Enable Options");
        chbSpeed = new JCheckBox("Maximize speed");
        chbSize = new JCheckBox("Minimize size");
        chbDebug = new JCheckBox("Debug");

        chbSpeed.setEnabled(false);
        chbSize.setEnabled(false);
        chbDebug.setEnabled(false);

        chbOptins.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(chbOptins.isSelected()){
                    chbSpeed.setEnabled(true);
                    chbSize.setEnabled(true);
                    chbDebug.setEnabled(true);
                } else{
                    chbSpeed.setEnabled(false);
                    chbSize.setEnabled(false);
                    chbDebug.setEnabled(false);
                }
            }
        });

        chbSpeed.addItemListener(this);
        chbSize.addItemListener(this);
        chbDebug.addItemListener(this);

        frame.add(chbOptins);
        frame.add(lblOptions);
        frame.add(chbSpeed);
        frame.add(chbSize);
        frame.add(chbDebug);
        frame.add(lblWhat);
        frame.add(lblChange);

        frame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String opt = "";

        JCheckBox chb = (JCheckBox) e.getItem();
        if (e.getStateChange() == ItemEvent.SELECTED){
            lblChange.setText("Selection change: " + chb.getText() + " selected");
        } else{
            lblChange.setText("Selection change: " + chb.getText() + " cleared");
        }

        if (chbSpeed.isSelected()) opt += "Speed ";
        if (chbSize.isSelected()) opt += "Size ";
        if (chbDebug.isSelected()) opt += "Debug";

        lblWhat.setText("Options selected: " + opt);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckBoxDemo();
            }
        });
    }
}
