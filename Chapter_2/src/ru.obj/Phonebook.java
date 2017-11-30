import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phonebook {

    JTextField tfName;
    JTextField tfNumber;

    JRadioButton rbExact;
    JRadioButton rbStartsWith;
    JRadioButton rbEndsWith;

    JCheckBox chbIgnoreCase;

    String[][] phonelist = {{"Артур", "603"},
            {"Саня", "602"},{"Илюха","450018"},
            {"Пухлый","450187"},{"Макс","450001"}};

    Phonebook(){
        JFrame frame = new JFrame("Phonebook");
        frame.setSize(240,220);
        frame.setLayout(new GridLayout(0,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblName = new JLabel("Name");
        JLabel lblNumber = new JLabel("Number");
        JLabel lblOptions = new JLabel("Search Options");

        tfName = new JTextField(10);
        tfNumber = new JTextField(10);

        chbIgnoreCase = new JCheckBox("Ignore Case");

        rbExact = new JRadioButton("Exact. Match", true);
        rbStartsWith = new JRadioButton("Starts With");
        rbEndsWith = new JRadioButton("Ends With");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbExact);
        bg.add(rbStartsWith);
        bg.add(rbEndsWith);

        tfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNumber.setText(lookupName(tfName.getText()));
            }
        });

        tfNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText(lookupNumber(tfNumber.getText()));
            }
        });

        frame.add(lblName);
        frame.add(tfName);
        frame.add(lblNumber);
        frame.add(tfNumber);
        frame.add(new Label());
        frame.add(lblOptions);
        frame.add(chbIgnoreCase);
        frame.add(new Label());
        frame.add(rbExact);
        frame.add(rbStartsWith);
        frame.add(rbEndsWith);

        frame.setVisible(true);

    }

    private String lookupName(String text) {
        for (int i = 0; i < phonelist.length; i++){
            if (rbStartsWith.isSelected()){
                if (chbIgnoreCase.isSelected()){
                    if (phonelist[i][0].toLowerCase().startsWith(text.toLowerCase())){
                        return phonelist[i][1];
                    }
                } else {
                    if (phonelist[i][0].startsWith(text)){
                        return phonelist[i][1];
                    }
                }
            } else if (rbEndsWith.isSelected()){
                if (chbIgnoreCase.isSelected()){
                    if (phonelist[i][0].toLowerCase().endsWith(text.toLowerCase())){
                        return phonelist[i][1];
                    }
                } else {
                    if(phonelist[i][0].endsWith(text)){
                        return phonelist[i][1];
                    }
                }
            } else {
                if (chbIgnoreCase.isSelected()){
                    if (phonelist[i][0].toLowerCase().equals(text.toLowerCase())){
                        return phonelist[i][1];
                    }
                } else {
                    if (phonelist[i][0].equals(text)){
                        return phonelist[i][1];
                    }
                }
            }
        }
        return "not found";
    }

    private String lookupNumber(String text) {
        for (int i = 0; i < phonelist.length;i++){
            if(phonelist[i][1].equals(text)){
                return phonelist[i][0];
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Phonebook();
            }
        });
    }
}
