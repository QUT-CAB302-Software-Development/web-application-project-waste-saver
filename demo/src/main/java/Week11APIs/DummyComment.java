package Week11APIs;

import com.google.gson.Gson;

public class DummyComment {
    private int id;
    private String body;
    private int postID;
    private DummyUser user;

    public DummyComment(int id, String body, int postID, DummyUser user){
        this.id = id;
        this.body = body;
        this.postID = postID;
        this.user = user;
    }

    public static DummyComment fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyComment.class);
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
    public DummyUser getUser() {
        return user;
    }
    public void setUser(DummyUser user) {
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
