package Patterns.Flyweight;

public class Tree {
    private int x_cordinate;
    private int y_cordinate;
    private TreeType type;

    public Tree(int x_cordinate, int y_cordinate, TreeType type) {
        this.x_cordinate = x_cordinate;
        this.y_cordinate = y_cordinate;
        this.type = type;
    }
    public void draw(){
        System.out.println("x_cordinate: "+ x_cordinate + "y_cordinate: " + y_cordinate);
        type.draw(x_cordinate,y_cordinate);
    }
}
