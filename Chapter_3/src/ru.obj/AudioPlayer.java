
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
        showChanges();
    }

    private void showChanges() {

    }

    private void loadPresets(Presets preset) {

    }

    private void storePreset(Presets preset) {

    }

    void setupPresets(){

    }

    void setupSliders(){
        slBass = new JSlider(-10,10);
        slMidrate = new JSlider(-10,10);
        slTrible = new JSlider(-10,10);
        slVolume = new JSlider(0,10,0);
        slBalance = new JSlider(-5,5);
    }

    void setupLables(){

    }

    void setupRButtons(){

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
