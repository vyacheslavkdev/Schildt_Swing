import javax.swing.*;
import java.awt.*;

public class DisabledLabelDemo {
    DisabledLabelDemo(){
        JFrame frame = new JFrame("Disabled Labels");
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(250,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon myIcon = new ImageIcon(this.getClass().getResource("img/icon.jpg"));
        ImageIcon myDisIcon = new ImageIcon(this.getClass().getResource("img/disIcon.jpg"));

        JLabel lblIconText = new JLabel("This label is enabled", myIcon,SwingConstants.CENTER);

        JLabel lblDisIconText = new JLabel("This label is disabled", myIcon,SwingConstants.CENTER);
        lblDisIconText.setEnabled(false);

        JLabel lblMyDisIconText = new JLabel("Use the disabled icon", myIcon, SwingConstants.CENTER);
        lblMyDisIconText.setDisabledIcon(myDisIcon);
        lblMyDisIconText.setEnabled(false);

        frame.add(lblIconText);
        frame.add(lblDisIconText);
        frame.add(lblMyDisIconText);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisabledLabelDemo();
            }
        });
    }
}
