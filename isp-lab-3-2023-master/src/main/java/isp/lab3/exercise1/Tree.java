package isp.lab3.exercise1;

public class Tree {

    //attributes
    public int height;
    String colour;

    //constructors
    public Tree(){
        height = 15;
        colour = "dark brown";
    }

    public Tree(int height){
        this.height = height;
    }

    //methods
    public void grow(int amount){
        height += amount;
    }

    public String toString(){
        return this.height + "";
    }

    public static void printName(){
        System.out.println("tree");
    }

    //main method
    public static void main(String[] args){
        Tree t;
        t = new Tree();
        t.grow(2);
        Tree.printName();
        System.out.println(t.toString());
    }
}
