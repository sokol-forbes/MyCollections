package Patterns.Flyweight;

public class TreeType {
    private String name;
    private String color;
    private String otherInfo;

    public TreeType(String name, String color, String otherInfo) {
        this.name = name;
        this.color = color;
        this.otherInfo = otherInfo;
    }

    public void draw(int x, int y){
        System.out.println("color: "+ color+" x_cordinate: "+ x + " y_cordinate: " + y);

    }
}
