import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class InfoWindow extends JFrame {
    private JLabel displayName;
    private JPanel infoWindow;
    private JTextArea info;
    private JButton back;
    private JLabel sprite;

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
        setSize(1000, 1000);
    }

    public void display(PokeData mon) throws IOException {
        File file = new File("src\\official-artwork\\" + mon.getID()+".png");
        Image image = ImageIO.read(file);
        image = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        sprite.setIcon(new ImageIcon(image));
        displayName.setText(mon.getName());
        String words =
                "ID: " + mon.getID() +
                "\nHeight: " + mon.getHeight() + "dm" +
                "\nBase Experience: " + mon.getBaseExperience() + "\nMove List:\n";
        for (int i = 0; i < mon.getMoveList().size();i++) {
            words += mon.getMoveList().get(i) + " | ";
            if (i % 5 == 0 && i != 0) {
                words += "\n";
            }
        }
        info.setText(words);
        setVisible(true);
    }

}
