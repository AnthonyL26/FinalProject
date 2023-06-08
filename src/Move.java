public class Move {
    private Integer power;
    private String effect;
    private Integer accuracy;
    private Integer pp;
    private String type;
    private String name;

    public Move(String name, Integer power, String effect, Integer accuracy, Integer pp, String type) {
        this.power =power;
        this.effect =effect;
        this.accuracy =accuracy;
        this.pp = pp;
        this.type = type;
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public String getEffect() {
        return effect;
    }

    public Integer getPp() {
        return pp;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
