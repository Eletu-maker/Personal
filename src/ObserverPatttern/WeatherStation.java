package ObserverPatttern;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements IObservable {
    private int temp =60;
    private List<IObserver> observers;


    public  WeatherStation(){
        observers = new ArrayList<>();
    }

    public int getTemp(){return this.temp;}

    public void setTemp(int num){
        this.temp = num;
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifying() {
        for (IObserver observer:observers){
            observer.update();
        }
    }
}
