package abstract_fatory_pattern.impl;

import abstract_fatory_pattern.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("This is a Rectangle");
    }
}
