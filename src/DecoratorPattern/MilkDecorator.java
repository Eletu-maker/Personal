package DecoratorPattern;

public class MilkDecorator extends AddDecrator{

    Beverage beverage;
    public MilkDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    public int cost(){
        return this.beverage.cost() +2;
    };
}
