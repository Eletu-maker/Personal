package strategyPattern;

public class Goat extends Animal {
    feedingBehavior food;
    movingBehavior move;
    public Goat(feedingonPlant food,MovingonLand move) {
        super(food,move);
        this.food= food;
        this.move =move;

    }


    public void setFood(){
        this.food.feed();
    }


}