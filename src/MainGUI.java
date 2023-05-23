import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements ActionListener{
    private JTextField input;
    private JButton search;
    private JPanel panel;
    private JLabel name;
    private JLabel text1;

    private Networking api;
    private PokeData pokeData;

    public MainGUI() {
        createUIComponents();
        api = new Networking();
    }

    private void createUIComponents() {
        setContentPane(panel);
        setTitle("PokeSearch");
        setSize(650, 250);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        search.addActionListener(evt -> {
            if (api.getPokemon(input.getText().toLowerCase()) != null) {
                PokeData pokemon = api.getPokemon(input.getText().toLowerCase());
                System.out.println(pokemon.getName());
            }
                 });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
