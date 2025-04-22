package strategyPattern;

public class prototype {
    public static void main(String[] args) {
        /*
        Animal animal = new Animal(new feedingMeat(),new MovingonLand());
        animal.setFood();
        animal.setMove();
        Animal animal1 = new Animal(new feedingonPlant(),new MovingonLand());
        animal1.setFood();
        Animal animal2 = new Animal(new feedonFish(),new MovingInWater());
        animal2.setFood();
        animal2.setMove();

         */
        Dog dog = new Dog(new feedingMeat(),new MovingonLand());
        dog.setMove();
        dog.setFood();

        Fish fish = new Fish(new feedonFish(),new MovingInWater());
        fish.setMove();
        fish.setFood();

        Goat goat = new Goat(new feedingonPlant(),new MovingonLand());
        goat.setFood();
        goat.setMove();
    }
}
