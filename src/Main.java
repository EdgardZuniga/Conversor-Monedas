import HttpManager.ApiManager;

public class Main {
    public static void main(String[] args) {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/19e332f43cfc7bf09ecc09f9/latest/USD";

        ApiManager apiMoney = new ApiManager(url_str);
        apiMoney.openConnection();

        MoneyConversor conversor = new MoneyConversor(apiMoney);
        conversor.Run();
        apiMoney.closeConnection();
    }
}






