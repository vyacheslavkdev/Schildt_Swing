import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class CustomSBDemo {
    JLabel lblVert;
    JLabel lblHoriz;
    JLabel lblVSBInfo;
    JLabel lblHSBInfo;

    JScrollBar sbVert;
    JScrollBar sbHoriz;

    CustomSBDemo(){
        JFrame frame = new JFrame("Scroll Bar Properties");
        frame.setSize(260,500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblVert = new JLabel("Value of vertical scroll bar: 0");
        lblHoriz = new JLabel("Value of horizontal scroll bat: 250");

        sbVert = new JScrollBar(JScrollBar.VERTICAL,0,5,0,500);
        sbHoriz = new JScrollBar(JScrollBar.HORIZONTAL, 250,0,0,500);

        sbVert.setPreferredSize(new Dimension(30,200));
        sbHoriz.setPreferredSize(new Dimension(200,10));

        sbHoriz.setBlockIncrement(25);

        sbVert.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if(sbVert.getValueIsAdjusting()) return;
                lblVert.setText("Value of vertical scroll bar: "+e.getValue());
            }
        });

        sbHoriz.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                lblHoriz.setText("Value of horizontal scroll bar: " + e.getValue());
            }
        });

        lblVSBInfo = new JLabel("<html>Scroll Bar Defaults<br>"+
                "Minimum value: " + sbVert.getMinimum() + "<br>"+
                "Maximum value: " +sbVert.getMaximum()+ "<br>" +
                "Visible amount(extent): " + sbVert.getVisibleAmount() + "<br>" +
                "Block increment: " + sbVert.getBlockIncrement() +"<br>" +
                "Unit increment: " + sbVert.getUnitIncrement());

        lblHSBInfo = new JLabel("<html>Scroll Bar Defaults<br>"+
                "Minimum value: " + sbHoriz.getMinimum() + "<br>"+
                "Maximum value: " +sbHoriz.getMaximum()+ "<br>" +
                "Visible amount(extent): " + sbHoriz.getVisibleAmount() + "<br>" +
                "Block increment: " + sbHoriz.getBlockIncrement() +"<br>" +
                "Unit increment: " + sbHoriz.getUnitIncrement());

        frame.add(sbVert);
        frame.add(sbHoriz);
        frame.add(lblVert);
        frame.add(lblHoriz);
        frame.add(lblVSBInfo);
        frame.add(lblHSBInfo);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomSBDemo();
            }
        });
    }
}
