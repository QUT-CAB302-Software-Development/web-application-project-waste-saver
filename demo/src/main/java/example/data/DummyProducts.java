package example.data;
import com.google.gson.Gson;


public class DummyProducts {
    private DummyProducts[] products;

    public DummyProducts[] getDummyProducts() {
        return products;
    }

    public static DummyProducts fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyProducts.class);
    }
}
