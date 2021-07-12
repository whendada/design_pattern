package abstract_fatory_pattern.factory;

import abstract_fatory_pattern.Color;
import abstract_fatory_pattern.Shape;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape) ;
}
