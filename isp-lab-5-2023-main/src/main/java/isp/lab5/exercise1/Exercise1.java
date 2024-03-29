package isp.lab5.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        Adress adress = new Adress("str Avram Iancu 14");
        Customer customer = new Customer("Peter", adress);
        Product[] productList = new Product[10];
        productList[0] = new Product("A01", ProductCategory.ELECTRONICS, 100);
        productList[1] = new Product("A02", ProductCategory.FASHION, 75);
        productList[2] = new Product("A03", ProductCategory.HOME_AND_GARDEN, 35);
        productList[3] = new Product("A04", ProductCategory.BEAUTY, 130);
        productList[4] = new Product("A05", ProductCategory.TOYS, 300);
        productList[5] = new Product("A06", ProductCategory.ELECTRONICS, 569);
        Order o = new Order("O01", customer, productList);
        System.out.println(o.toString());
    }
}
