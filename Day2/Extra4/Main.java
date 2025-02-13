import java.util.*;

class ShoppingCart {
    private HashMap<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Double> orderedProducts = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedProducts = new TreeMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
        orderedProducts.put(name, price);
        sortedProducts.put(price, name);
    }

    public void displayOrderedProducts() {
        System.out.println("Products in order added:");
        for (Map.Entry<String, Double> entry : orderedProducts.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    public void displaySortedProducts() {
        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, String> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getValue() + " - $" + entry.getKey());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.50);
        cart.addProduct("Phone", 799.99);
        cart.addProduct("Headphones", 199.99);

        cart.displayOrderedProducts();
        System.out.println("----------------------");
        cart.displaySortedProducts();
    }
}
