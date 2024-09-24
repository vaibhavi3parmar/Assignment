import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<WeatherObserver> observers;
    private float temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
