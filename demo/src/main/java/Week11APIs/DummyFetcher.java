package Week11APIs;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DummyFetcher {
    private HttpClient client = HttpClient.newHttpClient();

    public DummyComment fetchDummyComment(int id){
        String url = "https://dummyjson.com/comments/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyComment.fromJSON(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DummyComment[] fetchDummyComments() {
        String url = "https://dummyjson.com/comments";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyComments.fromJSON(response.body()).getDummyComments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        DummyUser u1 = new DummyUser(1, "du");
        DummyComment c1 = new DummyComment(1, "woo", 1, u1);

        DummyFetcher fetcher = new DummyFetcher();

        DummyComment c2 = fetcher.fetchDummyComment(1);

        DummyComment[] cs = fetcher.fetchDummyComments();

        for (DummyComment c : cs){
            System.out.println(c);
        }
    }

}
