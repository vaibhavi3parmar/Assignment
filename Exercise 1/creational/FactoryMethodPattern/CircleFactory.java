public class CircleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Circle();
    }
}
