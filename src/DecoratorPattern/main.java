package DecoratorPattern;

public class main {
    public static void main(String[] args) {
        MilkDecorator milkDecorator = new MilkDecorator(new Expresso());

        System.out.println("cost of milk with expresso: "+ milkDecorator.cost());
    }
}
