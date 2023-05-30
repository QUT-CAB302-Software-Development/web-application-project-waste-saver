package Week11APIs;

import com.google.gson.Gson;

public class DummyComments {
    private DummyComment[] comments;

    public static DummyComments fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyComments.class);
    }

    public DummyComment[] getDummyComments() {
        return comments;
    }

    public static DummyComments fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyComments.class);
    }
}
