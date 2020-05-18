package C_structural.D_decorator;

public class B_DynamicDecoratorComposition {
    public static void main(String[] args) {
        Circle circle = new Circle(20);
        System.out.println(circle.info());

        ColoredShape coloredShape = new ColoredShape(new Square(29), "yellow");
        System.out.println(coloredShape.info());

        TransparentShape myCircle = new TransparentShape(new ColoredShape(new Circle(4), "red"), 20);
        System.out.println(myCircle.info());
    }
}

interface Shape {
    String info();
}

class Circle implements Shape {

    private float radius;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A Circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A Square of side " + side;
    }
}
/*
The key is that we use Composition to propagate functionality
For example in this class we need add a feature. So, we add a association to Shape and we add a
specific feature, in this case the color feature.

The main aim of decorator is add functionalities
 */
class ColoredShape implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape implements Shape {

    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}
