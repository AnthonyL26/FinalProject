import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
            int height = currentObj.getInt("height");
            int weight = currentObj.getInt("weight");
            int base_experience = currentObj.getInt("base_experience");

            PokeData pokemon = new PokeData(display, moveList, id, height, weight, base_experience);
            return pokemon;
        }


    }
}
