package Week11APIs;

import com.google.gson.Gson;

public class DummyToDoers {
    private DummyToDo[] todos;

    public DummyToDo[] getTodos() {
        return todos;
    }

    /**
     * Converts a JSON string to a DummyToDoers object using Gson.
     *
     * @param json the JSON string to convert
     * @return the DummyToDoers object
     */
    public static DummyToDoers fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyToDoers.class);
    }
}
