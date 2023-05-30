package example.data;

import com.google.gson.Gson;

public class DummyProduct {
    private int id;
    private String title;
    private int price;
    private int stock;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "DummyProduct{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public static DummyProduct fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, DummyProduct.class);
    }


}
