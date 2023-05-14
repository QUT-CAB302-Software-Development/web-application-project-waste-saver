package Week11APIs;

import com.google.gson.Gson;

public class DummyToDo {
    private int id;
    private String todo;
    private Boolean completed;
    private String userId;

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "DummyToDo{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                ", completed=" + completed +
                ", userId='" + userId + '\'' +
                '}';
    }

    /**
     * Converts a JSON string to a DummyToDo object using Gson.
     *
     * @param json the JSON string to convert
     * @return the DummyToDo object
     */
    public static DummyToDo fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyToDo.class);
    }
}
