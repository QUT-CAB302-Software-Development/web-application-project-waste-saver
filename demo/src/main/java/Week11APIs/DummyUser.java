package Week11APIs;

import com.google.gson.Gson;

public class DummyUser {
    private int id;
    private String username;

    public DummyUser(int id, String username){
        this.id = id;
        this.username = username;
    }

    public static DummyUser fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyUser.class);
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
