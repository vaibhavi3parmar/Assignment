public class RectangleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Rectangle();
    }
}
