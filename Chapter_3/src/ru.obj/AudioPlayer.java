
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Hashtable;

class Presets{
    int bass;
    int midrange;
    int trible;
    int balance;
    int volume;

    Presets(int b, int m, int t, int bl, int v){
        this.bass = b;
        this.midrange = m;
        this.trible = t;
        this.balance = bl;
        this.volume = v;
    }

}

public class AudioPlayer implements ChangeListener {

    JLabel lblBass;
    JLabel lblMidrate;
    JLabel lblTrible;
    JLabel lblBalance;
    JLabel lblVolume;
    JLabel lblInfo;

    JSlider slBass;
    JSlider slMidrate;
    JSlider slTrible;
    JSlider slBalance;
    JSlider slVolume;

    JRadioButton rbtnPreset1;
    JRadioButton rbtnPreset2;
    JRadioButton rbtnDefault;

    JButton btnStore;
    DecimalFormat df;
    Presets[] presets;

    AudioPlayer(){
        JFrame frame = new JFrame("A Simple AudioPlayer interface");
        frame.setLayout(new FlowLayout());
        frame.setSize(340,520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        df = new DecimalFormat("+#;-#");

        setupPresets();
        setupSliders();
        setupLables();
        setupRButtons();

        btnStore = new JButton("Store Settings");
        btnStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbtnPreset1.isSelected()){
                    storePreset(presets[1]);
                } else if (rbtnPreset2.isSelected()){
                    storePreset(presets[2]);
                }
            }
        });

        rbtnDefault.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPresets(presets[0]);
            }
        });

        rbtnPreset1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPresets(presets[1]);
            }
        });

        rbtnPreset2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPresets(presets[2]);
            }
        });

        slBass.addChangeListener(this);
        slMidrate.addChangeListener(this);
        slTrible.addChangeListener(this);
        slBalance.addChangeListener(this);
        slVolume.addChangeListener(this);

        frame.add(lblBass);
        frame.add(slBass);
        frame.add(lblMidrate);
        frame.add(slMidrate);
        frame.add(lblTrible);
        frame.add(slTrible);
        frame.add(lblBalance);
        frame.add(slBalance);
        frame.add(lblVolume);
        frame.add(slVolume);
        frame.add(rbtnDefault);
        frame.add(rbtnPreset1);
        frame.add(rbtnPreset2);
        frame.add(btnStore);
        frame.add(new Label(""));
        frame.add(lblInfo);

        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        showSettings();
    }

    void loadPresets(Presets preset) {
        slBass.setValue(preset.bass);
        slMidrate.setValue(preset.midrange);
        slTrible.setValue(preset.trible);
        slBalance.setValue(preset.balance);
        slVolume.setValue(preset.volume);
    }

    void storePreset(Presets preset) {
        preset.bass = slBass.getValue();
        preset.midrange = slMidrate.getValue();
        preset.trible = slTrible.getValue();
        preset.balance = slBalance.getValue();
        preset.volume = slVolume.getValue();
    }

    void setupPresets(){
        presets = new Presets[3];
        presets[0] = new Presets(0,0,0,0,0);
        presets[1] = new Presets(2,-4,7,0,4);
        presets[2] = new Presets(3,3,-2,1,7);
    }

    void setupSliders(){
        slBass = new JSlider(-10,10);
        slMidrate = new JSlider(-10,10);
        slTrible = new JSlider(-10,10);
        slVolume = new JSlider(0,10,0);
        slBalance = new JSlider(-5,5);

        slBass.setMajorTickSpacing(2);
        slMidrate.setMajorTickSpacing(2);
        slTrible.setMajorTickSpacing(2);
        slBalance.setMajorTickSpacing(1);
        slVolume.setMajorTickSpacing(1);

        slBass.setMinorTickSpacing(1);
        slMidrate.setMinorTickSpacing(1);
        slTrible.setMinorTickSpacing(1);

        Hashtable table = new Hashtable();
        for (int i = -10; i<= 0; i += 2){
            table.put(i, new JLabel(""+i));
        }
        for (int i = 2; i <= 10; i += 2){
            table.put(i, new JLabel(""+i));
        }
        slBass.setLabelTable(table);
        slMidrate.setLabelTable(table);
        slTrible.setLabelTable(table);

        table = new Hashtable();
        table.put(0,new JLabel("Center"));
        table.put(-5,new JLabel("L"));
        table.put(5,new JLabel("R"));
        slBalance.setLabelTable(table);

        slVolume.setLabelTable(slVolume.createStandardLabels(1));

        slBass.setPaintTicks(true);
        slMidrate.setPaintTicks(true);
        slTrible.setPaintTicks(true);
        slBalance.setPaintTicks(true);
        slVolume.setPaintTicks(true);

        slBass.setPaintLabels(true);
        slMidrate.setPaintLabels(true);
        slTrible.setPaintLabels(true);
        slBalance.setPaintLabels(true);
        slVolume.setPaintLabels(true);

        slBass.setSnapToTicks(true);
        slMidrate.setSnapToTicks(true);
        slTrible.setSnapToTicks(true);
        slBalance.setSnapToTicks(true);
        slVolume.setSnapToTicks(true);

        Dimension sldrSize = new Dimension(240,60);
        slBass.setPreferredSize(sldrSize);
        slMidrate.setPreferredSize(sldrSize);
        slTrible.setPreferredSize(sldrSize);
        slBalance.setPreferredSize(sldrSize);
        slVolume.setPreferredSize(sldrSize);
    }

    void setupLables(){
        lblBass = new JLabel("Bass");
        lblMidrate = new JLabel("Midrate");
        lblTrible = new JLabel("Trible");
        lblBalance = new JLabel("Balance");
        lblVolume = new JLabel("Volume");

        Dimension lblSize = new Dimension(60,25);
        lblBass.setPreferredSize(lblSize);
        lblBass.setPreferredSize(lblSize);
        lblMidrate.setPreferredSize(lblSize);
        lblTrible.setPreferredSize(lblSize);
        lblBalance.setPreferredSize(lblSize);
        lblVolume.setPreferredSize(lblSize);

        lblInfo = new JLabel("");
        lblInfo.setPreferredSize(new Dimension(110,100));
        showSettings();
    }

    void setupRButtons(){
        rbtnDefault = new JRadioButton("Defaults");
        rbtnPreset1 = new JRadioButton("Preset 1");
        rbtnPreset2 = new JRadioButton("Preset 2");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbtnDefault);
        bg.add(rbtnPreset1);
        bg.add(rbtnPreset2);

        rbtnDefault.setSelected(true);
    }

    private void showSettings() {
        String bal;

        int b = slBalance.getValue();
        if (b > 0){
            bal = "Right " + df.format(slBalance.getValue());
        } else if(b==0){
            bal = "Center";
        } else{
            bal = "Left " + df.format(slBalance.getValue());
        }

        lblInfo.setText("<html> Treble: " + df.format(slTrible.getValue()) +
                        "<br>Midrate: " + df.format(slMidrate.getValue()) +
                        "<br>Bass: " + df.format(slBass.getValue()) +
                        "<br>Balance: " + bal + "<br>Volume: " + slVolume.getValue());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AudioPlayer();
            }
        });
    }
}
