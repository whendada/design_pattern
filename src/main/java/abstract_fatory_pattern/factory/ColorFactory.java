package abstract_fatory_pattern.factory;

import abstract_fatory_pattern.Color;
import abstract_fatory_pattern.Shape;
import abstract_fatory_pattern.impl.*;

public class ColorFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        }
        else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }
        else {
            return null;
        }
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
