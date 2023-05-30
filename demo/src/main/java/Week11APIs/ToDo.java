package Week11APIs;

public class ToDo {
    public static void main(String[] args) {
        DummyToDoFetcher fetcher = new DummyToDoFetcher();
        DummyToDo[] todos = fetcher.fetchDummyToDos();
        if (todos != null) {
            for (DummyToDo todo : todos) {
                System.out.println(todo);
            }
        }
    }
}
