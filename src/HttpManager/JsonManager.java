package HttpManager;
import com.google.gson.*;

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

    public double getMoney(String nameMoney){
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        return conversionRates.get(nameMoney).getAsDouble();
    }
}
