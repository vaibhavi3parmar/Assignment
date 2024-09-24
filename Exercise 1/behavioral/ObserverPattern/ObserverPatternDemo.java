public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        TemperatureDisplay display1 = new TemperatureDisplay("Display 1");
        TemperatureDisplay display2 = new TemperatureDisplay("Display 2");

        station.registerObserver(display1);
        station.registerObserver(display2);

        station.setTemperature(25.0f);
        station.setTemperature(30.0f);
    }
}
