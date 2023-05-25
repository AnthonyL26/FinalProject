import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainGUI extends JFrame implements ActionListener{
    private JTextField input;
    private JButton search;
    private JPanel panel;
    private JLabel name;
    private JLabel text1;
    private JButton random;

    private Networking api;
    private PokeData pokeData;
    private InfoWindow infoWindow;

    public MainGUI() {
        api = new Networking();
        infoWindow = new InfoWindow();
        createUIComponents();

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
        random.addActionListener(evt -> {
            int rand = (int) (Math.random()*900)+1;
            System.out.println(rand);
            PokeData randPoke = api.getPokemon(rand);
            try {
                infoWindow.display(randPoke);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
