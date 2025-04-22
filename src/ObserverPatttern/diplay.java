package ObserverPatttern;

public class diplay {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Phone iphone = new Phone(weatherStation);
        Phone samsung = new Phone(weatherStation);

        
        weatherStation.add(iphone);
        weatherStation.add(samsung);

        weatherStation.notifying();

        iphone.update();
        iphone.display();


    }
}
