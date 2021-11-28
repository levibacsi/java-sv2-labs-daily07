package day05;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate dateSold;
    private int price;

    public Product(String name, LocalDate dateSold, int price) {
        this.name = name;
        this.dateSold = dateSold;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", dateSold=" + dateSold +
                ", price=" + price +
                '}';
    }
}
