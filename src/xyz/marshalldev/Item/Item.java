package xyz.marshalldev.Item;

public class Item {

    private String name;
    private String description;
    private double price;
    private double salePrice;
    boolean onSale;
    private int stock;

    public Item(String name, String description, double price, double salePrice, boolean onSale) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.salePrice = salePrice;
        this.onSale = onSale;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public String toString() {
        return "Item Name: " + this.name +
                "\n   Description: " + this.description +
                "\n   Regular Price: " + this.price +
                "\n   Sale price: " + this.salePrice +
                "\n   On sale: " + this.onSale +
                "\n   Quantity in Stock: " + this.stock;
    }
}
