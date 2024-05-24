package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        //create an object
        AquariumController Cont1 = new AquariumController("BigAqua", "215");
        Cont1.setCurrentTime(13.2F);
        System.out.println(Cont1.toString());

    }
}
