import javax.swing.*;

public class MoveInfo extends JFrame{
    private JLabel name;
    private JLabel type;
    private JLabel pp;
    private JLabel accuracy;
    private JLabel power;
    private JLabel effect;
    private JPanel moveInfo;

    public MoveInfo () {
        createUIComponents();
    }
    private void createUIComponents() {
        setContentPane(moveInfo);
        setTitle("PokeSearch");
        setSize(300, 300);
    }
    public void display(Move move) {
        name.setText(move.getName());
        type.setText("Type: " + move.getType());
        pp.setText("PP: " + move.getPp());
        accuracy.setText("Accuracy: " + move.getAccuracy());
        power.setText("Power: " + move.getPower());
        effect.setText("<html><p>"+ move.getEffect() +"</p></html>");
        setVisible(true);
    }
}
