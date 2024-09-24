public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setDiscountStrategy(new NoDiscount());
        System.out.println("Total: " + cart.checkout(100.0));

        cart.setDiscountStrategy(new PercentageDiscount(20));
        System.out.println("Total after discount: " + cart.checkout(100.0));
    }
}
