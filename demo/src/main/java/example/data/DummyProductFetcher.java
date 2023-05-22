package example.data;

import java.net.URI;
import java.net.http.*;

public class DummyProductFetcher {

    private HttpClient client = HttpClient.newHttpClient();



    public DummyProduct fetchDummyProduct(int id) {
        String url = "https://dummyjson.com/products/" + id;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyProduct.fromJson(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public DummyProducts[] fetchAllProducts() {
        String url = "https://dummyjson.com/products";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyProducts.fromJson(response.body()).getDummyProducts();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
