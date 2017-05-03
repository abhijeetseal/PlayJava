package models;

import java.util.*;

/**
 * Created by aseal on 5/2/2017.
 */
public class Product {

    public String getProductId() {
        return productId;
    }

    public Product(String productId, String name, String description) {
        this.productId = productId;
        this.name = name;
        this.description = description;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String productId;
    public String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description;

    public String toString() {
        return String.format("%s - %s", productId, name);
    }


    //Mock Data

    private static List<Product> products;
    static {
        products = new ArrayList<Product>();
        products.add(new Product("1111111111111", "Paperclips 1",
                "Paperclips description 1"));
        products.add(new Product("2222222222222", "Paperclips 2",
                "Paperclips description "));
        products.add(new Product("3333333333333", "Paperclips 3",
                "Paperclips description 3"));
        products.add(new Product("4444444444444", "Paperclips 4",
                "Paperclips description 4"));
        products.add(new Product("5555555555555", "Paperclips 5",
                "Paperclips description 5"));
    }


    //Implementing Operations

    public static List<Product> findAll() {
        return new ArrayList<Product>(products);
    }
    public static Product findByEan(String productId) {
        for (Product candidate : products) {
            if (candidate.productId.equals(productId)) {
                return candidate;
            }
        }
        return null;
    }
    public static List<Product> findByName(String term) {
        final List<Product> results = new ArrayList<Product>();
        for (Product candidate : products) {
            if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(candidate);
            }
        }
        return results;
    }
    public static boolean remove(Product product) {
        return products.remove(product);
    }
    public void save() {
        products.remove(findByEan(this.productId));
        products.add(this);
    }
}
