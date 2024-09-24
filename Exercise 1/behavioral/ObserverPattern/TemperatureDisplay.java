public class TemperatureDisplay implements WeatherObserver {
    private String displayName;

    public TemperatureDisplay(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void update(float temperature) {
        System.out.println(displayName + ": New temperature is " + temperature);
    }
}
