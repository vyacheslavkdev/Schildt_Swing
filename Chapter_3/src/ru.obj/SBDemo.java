import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class SBDemo {
    JLabel lblVert;
    JLabel lblHoriz;
    JLabel lblSBInfo;

    JScrollBar sbVert;
    JScrollBar sbHoriz;

    SBDemo(){
        JFrame frame = new JFrame("Scroll Bar Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(260,260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblVert = new JLabel("Value of vertical scroll bar: 0");
        lblHoriz = new JLabel("Value of horizontal scroll bar: 0");

        sbVert = new JScrollBar();
        sbHoriz = new JScrollBar(JScrollBar.HORIZONTAL);

        sbVert.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if(sbVert.getValueIsAdjusting()) return;
                lblVert.setText("Value of vertical scroll bar: " + e.getValue());
            }
        });

        sbHoriz.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                lblHoriz.setText("Value of horizontal scroll bar: " + e.getValue());
            }
        });

        lblSBInfo = new JLabel("<html>Scroll Bar Defaults<br>"+
                                "Minimum value: " + sbVert.getMinimum() + "<br>"+
                                "Maximum value: " +sbVert.getMaximum()+ "<br>" +
                                "Visible amount(extent): " + sbVert.getVisibleAmount() + "<br>" +
                                "Block increment: " + sbVert.getBlockIncrement() +"<br>" +
                                "Unit increment: " + sbVert.getUnitIncrement());

        frame.add(sbVert);
        frame.add(sbHoriz);
        frame.add(lblVert);
        frame.add(lblHoriz);
        frame.add(lblSBInfo);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SBDemo();
            }
        });
    }
}
