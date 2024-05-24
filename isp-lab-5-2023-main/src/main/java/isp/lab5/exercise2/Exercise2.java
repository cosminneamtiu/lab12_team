package isp.lab5.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(50);
        Smartphone smartphone1 = new Smartphone(25);
        Smartwatch smartwatch1 = new Smartwatch(75);

        laptop1.charge(27);
        smartphone1.charge(27);
        smartwatch1.charge(27);

        System.out.println(laptop1.getBatteryLevel());
        System.out.println(smartphone1.getBatteryLevel());
        System.out.println(smartwatch1.getBatteryLevel());
    }

}
