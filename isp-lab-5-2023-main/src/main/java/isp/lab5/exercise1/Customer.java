package isp.lab5.exercise1;

public class Customer {
    private String name;
    protected Adress adress;

    public Customer(String name, Adress adress){
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
