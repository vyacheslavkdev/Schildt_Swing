import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderDemo {
    JLabel lblVert;
    JLabel lblHoriz;

    JSlider slVert;
    JSlider slHoriz;

    SliderDemo(){
        JFrame frame = new JFrame("Slider Demo");
        frame.setSize(300,300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        slVert = new JSlider(JSlider.VERTICAL);
        slHoriz = new JSlider();

        slVert.setMajorTickSpacing(10);
        slVert.setMinorTickSpacing(5);
        slVert.setLabelTable(slVert.createStandardLabels(10));
        slVert.setPaintTicks(true);
        slVert.setPaintLabels(true);
        slVert.setSnapToTicks(true);

        slHoriz.setMajorTickSpacing(20);
        slHoriz.setLabelTable(slHoriz.createStandardLabels(20));
        slHoriz.setPaintTicks(true);
        slHoriz.setPaintLabels(true);
        slHoriz.setInverted(true);

        lblVert = new JLabel("Value of vertical slider: " + slVert.getValue());
        lblHoriz = new JLabel("Value of horizontal slider: " + slHoriz.getValue());

        slVert.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (slVert.getValueIsAdjusting()) return;
                lblVert.setText("Value of vertical slider: " + slVert.getValue());
            }
        });

        slHoriz.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblHoriz.setText("Value of horizontal slider: " + slHoriz.getValue());
            }
        });

        frame.add(slVert);
        frame.add(slHoriz);
        frame.add(lblVert);
        frame.add(lblHoriz);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SliderDemo();
            }
        });
    }
}
