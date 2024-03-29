package isp.lab5.exercise1;

public class Product {
    private String productId;
    private ProductCategory productCategory;
    private double price;

    public Product(String productId, ProductCategory productCategory, double price){
        this.productCategory = productCategory;
        this.productId = productId;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Id: " + this.productId + ", Category: " + productCategory.toString() + ", Price: " + this.price;
    }
}
