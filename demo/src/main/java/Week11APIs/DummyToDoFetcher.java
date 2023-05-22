package Week11APIs;

import java.net.URI;
import java.net.http.*;
import java.util.Arrays;

public class DummyToDoFetcher {
    private HttpClient client = HttpClient.newHttpClient();

    /**
     * Fetches a ToDo from the dummyJSON API.
     * GET: https://dummyjson.com/todos/{id}
     *
     * @param id the ID of the ToDo to fetch
     * @return the DummyToDo object
     */
    public DummyToDo fetchDummyToDo(int id) {
        String url = "https://dummyjson.com/todos/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyToDo.fromJson(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fetches multiple ToDos from the dummyJSON API.
     * GET: https://dummyjson.com/todos
     *
     * @return the DummyToDo[] object
     */
    public DummyToDo[] fetchDummyToDos() {
        String url = "https://dummyjson.com/todos";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return DummyToDoers.fromJson(response.body()).getTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
