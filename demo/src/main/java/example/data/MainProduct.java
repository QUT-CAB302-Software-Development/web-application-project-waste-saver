package example.data;

public class MainProduct {

    public static void main(String[] args) {
        DummyProductFetcher fetcher = new DummyProductFetcher();
        DummyProduct firstCart = fetcher.fetchDummyProduct(1);
        System.out.println(firstCart);

        System.out.println("Fetching multiple products");
        DummyProducts[] products = fetcher.fetchAllProducts();
        for (DummyProducts product : products) {
            System.out.println(products);
        }
    }
}
