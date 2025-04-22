package TurtleGraphic;

public class TurtleGraphic {

    private boolean pen = true;
    private Direction direction = Direction.East;

    public boolean getpen(){
        return this.pen;
    }

    public Direction getDirection(){return this.direction;}

    public void penisUp(){
        this.pen = true;
    }

    public void penisDown(){
        this.pen = false;
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }


}
