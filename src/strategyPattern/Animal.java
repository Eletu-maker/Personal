package strategyPattern;

public abstract class Animal {
    feedingBehavior food;
    movingBehavior move;
    public Animal( feedingBehavior food,movingBehavior move){
        this.food = food;
        this.move = move;
    }

    public void setFood(){
        this.food.feed();
    }

    public  void setMove(){
        this.move.move();
    }

}
