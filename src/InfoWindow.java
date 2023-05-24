import javax.swing.*;
import java.awt.event.*;

public class InfoWindow extends JFrame {
    private JLabel displayName;
    private JPanel infoWindow;
    private JTextArea info;
    private JButton back;

    public InfoWindow() {
        createUIComponents();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }


    private void createUIComponents() {
        setContentPane(infoWindow);
        setTitle("PokeSearch");
        setSize(1000, 1500);
        setLocation(0, 0);
    }

    public void display(PokeData mon) {
        displayName.setText(mon.getName());
        String words =
                "ID: " + mon.getID() +
                "\nHeight: " + mon.getHeight() + "dm" +
                "\nBase Experience: " + mon.getBaseExperience() + "\nMove List:\n";
        for (int i = 0; i < mon.getMoveList().size();i++) {
            words += mon.getMoveList().get(i) + " | ";
            if (i % 5 == 0) {
                words += "\n";
            }
        }
        info.setText(words);
        setVisible(true);
    }
}
