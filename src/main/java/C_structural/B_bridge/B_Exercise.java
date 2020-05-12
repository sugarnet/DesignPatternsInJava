package C_structural.B_bridge;

public class B_Exercise {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(new RasterRenderer());
        Triangle triangle2 = new Triangle(new VectorRenderer());
        Square square1 = new Square(new RasterRenderer());
        Square square2 = new Square(new VectorRenderer());

        System.out.println(triangle1);
        System.out.println(triangle2);
        System.out.println(square1);
        System.out.println(square2);
    }
}


abstract class Shape
{
    protected Renderer renderer;

    public abstract String getName();

    @Override
    public String toString() {
        return "Drawing " + getName() + " as " + renderer.whatToRenderAs();
    }
}

class Triangle extends Shape
{

    public Triangle(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }


}

class Square extends Shape
{

    public Square(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String getName()
    {
        return "Square";
    }
}

interface Renderer {
    public String whatToRenderAs();
}

class VectorRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer {
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

/*
class VectorSquare extends Square
{
    @Override
    public String toString()
    {
        return String.format("Drawing %s as lines", getName());
    }
}

class RasterSquare extends Square
{
    @Override
    public String toString()
    {
        return String.format("Drawing %s as pixels", getName());
    }
}
*/

// imagine VectorTriangle and RasterTriangle are here too



