package isp.lab5.exercise1;

public class Order {
    private String orderId;
    private Customer customer;
    private Product[] products;

    public Order(String orderId, Customer customer, Product[] products){
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    @Override
    public String toString(){
        String s = "Order ID: " + this.orderId +"\n" + customer.toString() + " bought: \n";
        for(int i = 0; i<products.length; i++){
            if(products[i]!=null){
            s = s + products[i].toString() + '\n';
            }
        }
        return s;
    }
}
