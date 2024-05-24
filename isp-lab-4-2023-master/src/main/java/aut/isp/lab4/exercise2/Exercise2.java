package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishy = new FishFeeder("LilFish", "Pivo");
        fishy.feed();
        System.out.println(fishy.toString());
        fishy.fillUp();
        System.out.println(fishy.toString());
    }
}
