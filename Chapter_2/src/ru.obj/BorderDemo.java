

import javax.swing.*;
import java.awt.*;

public class BorderDemo {
    BorderDemo(){
        JFrame frame = new JFrame("BorderDemo");
        frame.setLayout(new FlowLayout());
        frame.setSize(280,90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblLine = new JLabel("This use line border");
        lblLine.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblEtched = new JLabel("This use etched border");
        lblEtched.setBorder(BorderFactory.createEtchedBorder());

        frame.add(lblLine);
        frame.add(lblEtched);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderDemo();
            }
        });
    }
}
