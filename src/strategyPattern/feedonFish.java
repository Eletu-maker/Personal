package strategyPattern;

public class feedonFish implements feedingBehavior{

    @Override
    public void feed() {
        System.out.println("feed on other fishes");
    }
}
