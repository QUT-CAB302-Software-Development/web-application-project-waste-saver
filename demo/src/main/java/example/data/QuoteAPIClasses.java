package example.data;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuoteAPIClasses {
    public static void main(String[] args) {
        dummyUser u1 = new dummyUser(1, "du");
        dummyComment c1 = new dummyComment(1, "woo", 1, u1);

        dummyFetcher fetcher = new dummyFetcher();

        dummyComment c2 = fetcher.fetchDummyComment(1);

        dummyComment[] cs = fetcher.fetchDummyComments();

        for (dummyComment c : cs){
            System.out.println(c);
        }
    }
}

class dummyUser{
    private int id;
    private String username;

    dummyUser(int id, String username){
        this.id = id;
        this.username = username;
    }

    public static dummyUser fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, dummyUser.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                "}";
    }
}
class dummyComment {
    private int id;
    private String body;
    private int postID;
    private dummyUser user;

    public dummyComment(int id, String body, int postID, dummyUser user){
        this.id = id;
        this.body = body;
        this.postID = postID;
        this.user = user;
    }

    public static dummyComment fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, dummyComment.class);
    }

    public int getId(){ return id; }
    public void setId(int id){ this.id = id; }
    public String getBody(){ return body; }
    public void setBody(String body) { this.body = body; }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public dummyUser getUser() {
        return user;
    }

    public void setUser(dummyUser user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body=" + body +
                ", postID=" + postID +
                ", user=" + user +
                "}";
    }

}
class dummyComments {
    private dummyComment[] comments;

    public static dummyComments fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, dummyComments.class);
    }

    public dummyComment[] getDummyComments() {
        return comments;
    }

    public static dummyComments fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, dummyComments.class);
    }
}

class dummyFetcher{
    private HttpClient client = HttpClient.newHttpClient();

    public dummyComment fetchDummyComment(int id){
        String url = "https://dummyjson.com/comments/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return dummyComment.fromJSON(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public dummyComment[] fetchDummyComments() {
        String url = "https://dummyjson.com/comments";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return dummyComments.fromJSON(response.body()).getDummyComments();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}