package strategyPattern;

public class Dog extends Animal {
    feedingBehavior food;
    movingBehavior move;
    public Dog(feedingMeat food,movingBehavior move){
        super(food, move);
        this.food = food;
        this.move = move;
    }

    public void setFood(){
        this.food.feed();
    }

    public void setMove(){
        this.move.move();
    }

}
