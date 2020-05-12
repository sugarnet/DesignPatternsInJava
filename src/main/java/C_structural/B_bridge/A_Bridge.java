package C_structural.B_bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class A_Bridge {
    public static void main(String[] args) {
//        VectorRenderer vector = new VectorRenderer();
//        RasterRenderer raster = new RasterRenderer();
//        Circle circle = new Circle(vector, 5);
//        circle.draw();
//        circle.resize(2);
//        circle.draw();
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle circle = injector.getInstance(Circle.class);
        circle.radius = 3;
        circle.draw();
        circle.resize(2);
        circle.draw();

    }
}

// interface name changed to RendererShape (before Renderer), for avoid conflicts with the exercise
interface RendererShape {
    void renderCircle(float radius);
}

class VectorRendererShape implements RendererShape {

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRendererShape implements RendererShape {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of " + radius + "radius");
    }
}

// class name changed to Figure (before Shape), for avoid conflicts with the exercise
abstract class Figure {
    protected RendererShape renderer;

    public Figure(RendererShape rendererShape) {
        this.renderer = rendererShape;
    }

    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Figure {
    public float radius;

    @Inject
    public Circle(RendererShape rendererShape) {
        super(rendererShape);
    }

    public Circle(RendererShape rendererShape, float radius) {
        super(rendererShape);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RendererShape.class).to(VectorRendererShape.class);
    }
}
