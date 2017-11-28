import javax.swing.*;
import java.awt.*;

public class MnemDemo {
    MnemDemo(){
        JFrame frame = new JFrame("MnemoDemo");
        frame.setLayout(new FlowLayout());
        frame.setSize(250,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField txtEmail = new JTextField(20);
        JTextField txtName = new JTextField(20);

        JLabel lblEmail = new JLabel("E-Mail");
        lblEmail.setVerticalTextPosition(SwingConstants.TOP);
        lblEmail.setDisplayedMnemonic('e');
        lblEmail.setLabelFor(txtEmail);

        JLabel lblName = new JLabel("Name");
        lblName.setVerticalTextPosition(SwingConstants.TOP);
        lblName.setDisplayedMnemonic('n');
        lblName.setLabelFor(txtName);

        frame.add(lblEmail);
        frame.add(txtEmail);
        frame.add(lblName);
        frame.add(txtName);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MnemDemo();
            }
        });
    }
}
