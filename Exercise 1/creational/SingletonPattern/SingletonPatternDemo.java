public class SingletonPatternDemo {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        configManager.displaySettings();
    }
}
