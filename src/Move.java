public class Move {
    private int power;
    private String effect;
    private int accuracy;
    private int pp;
    private String type;
    private String name;

    public Move(String name, int power, String effect, int accuracy, int pp, String type) {
        this.power =power;
        this.effect =effect;
        this.accuracy =accuracy;
        this.pp = pp;
        this.type = type;
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getEffect() {
        return effect;
    }

    public int getPp() {
        return pp;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
