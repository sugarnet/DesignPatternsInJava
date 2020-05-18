package C_structural.D_decorator;

import java.util.function.Supplier;

public class C_StaticDecoratorComposition {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape2<Square> coloredShape = new ColoredShape2(() -> new Square(34), "yellow");
        System.out.println(coloredShape.info());

        TransparentShape2<ColoredShape2<Circle>> myCircle = new TransparentShape2(
                () -> new ColoredShape2<>(() -> new Circle(20), "green"), 98
        );
        System.out.println(myCircle.info());
    }
}
/*
We use the definition in B_DynamicDecoratorComposition

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
*/

/*
In this case we use generics when don't know the shape
 */
class ColoredShape2<T extends Shape> implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape2(Supplier<? extends T> constructor, String color) {
        this.shape = constructor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class TransparentShape2<T extends Shape> implements Shape {

    private Shape shape;
    private int transparency;

    public TransparentShape2(Supplier<? extends T> constructor, int transparency) {
        this.shape = constructor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}
