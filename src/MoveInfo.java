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
        setSize(300, 200);
    }
    public void display(Move move) {
        name.setText(move.getName());
        type.setText(move.getType());
        pp.setText("" + move.getPp());
        accuracy.setText("" + move.getAccuracy());
        power.setText("" + move.getPower());
        effect.setText(move.getEffect());
        setVisible(true);
    }
}
