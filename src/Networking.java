import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;


public class Networking {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public static PokeData getPokemon(String name) {
        String url = BASE_URL + name;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();

        } catch (Exception e) {

        }

        if (urlResponse.equals("Not Found")) {
            return null;
        } else {
            JSONObject currentObj = new JSONObject(urlResponse);
            String display = currentObj.getString("name");
            int id = currentObj.getInt("id");
            JSONArray moveList = currentObj.getJSONArray("moves");
            ArrayList<String> moves = new ArrayList<>();
            for(int i = 0; i < moveList.length();i++) {
                JSONObject object = moveList.getJSONObject(i);
                object = object.getJSONObject("move");
                moves.add(object.getString("name"));
            }

            int height = currentObj.getInt("height");
            int weight = currentObj.getInt("weight");
            int base_experience = currentObj.getInt("base_experience");

            PokeData pokemon = new PokeData(display, moves, id, height, weight, base_experience);
            return pokemon;
        }
    }
    public static PokeData getPokemon(int num) {
        String url = BASE_URL + num;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();

        } catch (Exception e) {

        }

        if (urlResponse.equals("Not Found")) {
            return null;
        } else {
            JSONObject currentObj = new JSONObject(urlResponse);
            String display = currentObj.getString("name");
            int id = currentObj.getInt("id");
            JSONArray moveList = currentObj.getJSONArray("moves");
            ArrayList<String> moves = new ArrayList<>();
            for (int i = 0; i < moveList.length(); i++) {
                JSONObject object = moveList.getJSONObject(i);
                object = object.getJSONObject("move");
                moves.add(object.getString("name"));
            }

            int height = currentObj.getInt("height");
            int weight = currentObj.getInt("weight");
            int base_experience = currentObj.getInt("base_experience");

            PokeData pokemon = new PokeData(display, moves, id, height, weight, base_experience);
            return pokemon;
        }
    }
}
