import java.util.*;
import org.json.*;
public class PokeData {
    private String name;
    private JSONArray moveList;
    private int id;
    private int height;
    private int weight;
    private int base_experience;

    public PokeData(String name, JSONArray moveList, int id, int height, int weight, int base_experience) {
        this.name = name;
        this.moveList = moveList;
        this.id = id;
        this.height = height;
        this.base_experience = base_experience;
    }

    public String getName() {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        return name;
    }

    public JSONArray getMoveList() {
        return moveList;
    }

    public int getID() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getBaseExperience() {
        return base_experience;
    }
}