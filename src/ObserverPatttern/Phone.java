package ObserverPatttern;

public class Phone implements IObserver{

    WeatherStation station;
    int currentTemp=0;
    public  Phone(WeatherStation station){
        this.station = station;
    }

    @Override
    public void update() {
        currentTemp =this.station.getTemp();
    }

    public void display(){
        System.out.println("current temp: " + currentTemp);
    }
}
