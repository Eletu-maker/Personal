package strategyPattern;

public class feedingonPlant implements feedingBehavior{

    @Override
    public void feed() {
        System.out.println("feed on plant");
    }
}
