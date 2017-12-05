import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressDemo {

    JLabel lblVertic;
    JLabel lblHoriz;

    JProgressBar pbHoriz;
    JProgressBar pbVertic;

    JButton btn;

    ProgressDemo(){
        JFrame frame = new JFrame("Progress Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(280,270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pbHoriz = new JProgressBar();
        pbVertic = new JProgressBar(JProgressBar.VERTICAL);

        pbHoriz.setStringPainted(true);
        pbVertic.setStringPainted(true);

        btn = new JButton("Push me");

        lblVertic = new JLabel("Value of vertical progress bar: " + pbVertic.getValue());
        lblHoriz = new JLabel("Value of horizontal progress bar: " + pbHoriz.getValue());

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hVal = pbHoriz.getValue();
                int vVal = pbVertic.getValue();

                if (hVal >= pbHoriz.getMaximum()){
                    return;
                } else{
                    pbHoriz.setValue(hVal + 10);
                }

                if (vVal >= pbVertic.getMaximum()){
                    return;
                } else {
                    pbVertic.setValue(vVal + 10);
                }

                lblHoriz.setText("Value of horizontal progress bar: " + pbHoriz.getValue());
                lblVertic.setText("Value of vertical progress bar: " + pbVertic.getValue());
            }
        });

        frame.add(pbHoriz);
        frame.add(pbVertic);
        frame.add(lblHoriz);
        frame.add(lblVertic);
        frame.add(btn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgressDemo();
            }
        });
    }
}
