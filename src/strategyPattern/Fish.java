package strategyPattern;

public class Fish extends Animal{
    feedingBehavior food;
    movingBehavior move;
    public Fish(feedonFish food,MovingInWater move){
        super(food,move);
        this.food= food;
        this.move = move;
    }

    public void setFood(){
        this.food.feed();
    }

    public void setMove(){
        this.move.move();
    }




}
