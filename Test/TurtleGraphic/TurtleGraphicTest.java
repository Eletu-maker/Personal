package TurtleGraphic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static TurtleGraphic.Direction.South;
import static org.junit.jupiter.api.Assertions.*;

class TurtleGraphicTest {
    static TurtleGraphic turtleGraphic;
    @BeforeEach
    public void setup() {
        turtleGraphic= new TurtleGraphic();
    }

    @Test
    public void getpen(){

        assertTrue(turtleGraphic.getpen());


    }

    @Test
    public void penisup(){

        turtleGraphic.penisUp();
        assertTrue(turtleGraphic.getpen());
    }


    @Test
    public void penisDown(){

        turtleGraphic.penisDown();
        assertFalse(turtleGraphic.getpen());
    }

    @Test
    public void turnright(){
turtleGraphic.penisDown();
        turtleGraphic.turnRight();
assertEquals(South,turtleGraphic.getDirection());
    }



}