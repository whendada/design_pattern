package abstract_fatory_pattern.factory;

import abstract_fatory_pattern.Color;
import abstract_fatory_pattern.Shape;
import abstract_fatory_pattern.impl.Circle;
import abstract_fatory_pattern.impl.Rectangle;
import abstract_fatory_pattern.impl.Square;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        else if (shape.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else if (shape.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        else {
            return null;
        }
    }
}
