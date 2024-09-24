public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee myCoffee = new BasicCoffee();
        System.out.println("Basic coffee cost: " + myCoffee.cost());

        myCoffee = new MilkDecorator(myCoffee);
        System.out.println("Coffee with milk cost: " + myCoffee.cost());

        myCoffee = new SugarDecorator(myCoffee);
        System.out.println("Coffee with milk and sugar cost: " + myCoffee.cost());
    }
}
