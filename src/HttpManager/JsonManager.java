package HttpManager;
import com.google.gson.*;
import org.jetbrains.annotations.NotNull;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JsonManager {
    JsonObject jsonObject;

    public void jsonParser(HttpURLConnection Request){
        try{
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) Request.getContent()));
            jsonObject = root.getAsJsonObject();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public JsonObject getJson(){
        return jsonObject;
    }

    public String getJsonFormatted(@NotNull JsonObject json){
        String req_result = json.toString();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(req_result);
        String formattedJson = gson.toJson(jsonElement);

        return formattedJson;
    }

    public double getMoney(String nameMoney){
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        double money = conversionRates.get(nameMoney).getAsDouble();
        return money;
    }
}
