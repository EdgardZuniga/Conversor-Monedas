package HttpManager;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiManager {
    private String URL;
    private HttpURLConnection request;

    public ApiManager(String URL) {
        this.URL = URL;
    }

    public void openConnection(){
        try {
            java.net.URL url = new URL(this.URL);
            request = (HttpURLConnection) url.openConnection();
            request.connect();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public HttpURLConnection getRequest() {
        return request;
    }

    public void closeConnection() {
        if (request != null) {
            request.disconnect();
        }
    }
}
