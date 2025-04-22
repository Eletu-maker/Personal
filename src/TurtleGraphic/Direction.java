package TurtleGraphic;

import java.util.PrimitiveIterator;

public enum Direction {
    North("East","West"),
    East("South","North"),
    South("West","East"),
    West("North","South");

    private String right;
    private  String left;

     Direction(String right,String left){
        this.right= right;
        this.left = left;
    }

    public Direction turnRight(){
        return Direction.valueOf(right);
    }




}
