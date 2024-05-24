package isp.lab5.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class Exercise1Test {
    @Test
    public void testToString(){
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

        Assert.assertEquals("Order ID: O01\n" +
                "Peter bought: \n" +
                "Id: A01, Category: Electronics & Gadgets, Price: 100.0\n" +
                "Id: A02, Category: Fashion, Price: 75.0\n" +
                "Id: A03, Category: Home and Garden, Price: 35.0\n" +
                "Id: A04, Category: Beauty, Price: 130.0\n" +
                "Id: A05, Category: Toys, Price: 300.0\n" +
                "Id: A06, Category: Electronics & Gadgets, Price: 569.0\n", o.toString());
    }

}
