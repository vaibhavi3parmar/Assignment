public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // private constructor
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void displaySettings() {
        System.out.println("Displaying configuration settings.");
    }
}
