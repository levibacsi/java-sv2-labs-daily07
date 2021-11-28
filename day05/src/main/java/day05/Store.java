package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> productList = new ArrayList<>();
    private List<Product> productsToSellList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public List<Product> getProductsToSellList() {
        return productsToSellList;
    }

    public void addProduct(Product p){
        if (p.getDateSold().isAfter(LocalDate.now())){
            throw new IllegalArgumentException ("Future date cannot be used.");
        }
        productList.add(p);
    }

    public void addProductsToSell(int month){
        for (Product p: productList){
            if (month == p.getDateSold().getMonthValue()){
                productsToSellList.add(p);
            }
        }
    }

    public List<String> dataCompiler (List<Product> products){
        List<String> compiledProductList = new ArrayList<>();
        for (Product p: products){
            String s = p.getName() + ";" + p.getDateSold() + ";" + p.getPrice();
            compiledProductList.add(s);
        }
        return compiledProductList;
    }

    public void fileWriter (List<String> data) {
        try {
            Files.write(Paths.get("month_"+productsToSellList.get(0).getDateSold().getMonthValue() + "_data.csv"), data);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Product product = new Product("apple", LocalDate.of(2021,02,04), 300);
        Product product1 = new Product("plum", LocalDate.of(2021, 02, 03), 400);
        Product product2 = new Product("plum", LocalDate.of(2021, 03, 03), 400);

        Store store = new Store();

        store.addProduct(product);
        store.addProduct(product1);
        store.addProduct(product2);

        System.out.println(store.getProductList());

        store.addProductsToSell(2);
        System.out.println(store.getProductsToSellList());

        store.fileWriter(store.dataCompiler(store.getProductsToSellList()));
    }
}
