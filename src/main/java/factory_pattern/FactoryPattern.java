package factory_pattern;

public class FactoryPattern {

    public static Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        Shape circle = FactoryPattern.getShape("circle");
        circle.draw();
        Shape rectangle = FactoryPattern.getShape("rectangle");
        rectangle.draw();
        Shape square = FactoryPattern.getShape("square");
        square.draw();
    }
}
