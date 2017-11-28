import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IconLabelDemo {
    IconLabelDemo(){
        JFrame frame = new JFrame("Image in label");
        frame.setLayout(new GridLayout(4,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,350);

        ImageIcon myIcon = new ImageIcon(this.getClass().getResource("img/icon.jpg"));

        JLabel lblIcon = new JLabel(myIcon);

        lblIcon.setText("text bottom of icon");
        lblIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        lblIcon.setVerticalTextPosition(SwingConstants.BOTTOM);

        JLabel lblIconTxt = new JLabel("default icon and text positon",myIcon,SwingConstants.CENTER);

        JLabel lblLeftTextIcon = new JLabel("text left of icon", myIcon, SwingConstants.CENTER);
        lblLeftTextIcon.setHorizontalTextPosition(SwingConstants.LEFT);

        JLabel lblTopTextIcon = new JLabel("text over icon", myIcon, SwingConstants.CENTER);
        lblTopTextIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        lblTopTextIcon.setVerticalTextPosition(SwingConstants.TOP);


        frame.add(lblIcon);
        frame.add(lblIconTxt);
        frame.add(lblLeftTextIcon);
        frame.add(lblTopTextIcon);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IconLabelDemo();
            }
        });
    }
}
