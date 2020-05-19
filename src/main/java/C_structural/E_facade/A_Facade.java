package C_structural.E_facade;

import java.util.ArrayList;
import java.util.List;

public class A_Facade {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(20, 30);
        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewport(viewport);
        console.render();

        Console console2 = Console.newConsole(30, 20);
        console2.render();
    }
}

class Buffer {
    private char[] characters;
    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth) {
        this.lineWidth = lineWidth;
        this.characters = new char[lineHeight * lineWidth];
    }

    public char charAt(int x, int y) {
        return characters[y * lineWidth + x];
    }
}

class Viewport {
    private final Buffer buffer;
    private final int width;
    private final int height;
    private final int offsetX;
    private final int offsetY;

    public Viewport(Buffer buffer, int width, int height, int offsetX, int offsetY) {

        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char charAt(int x, int y) {
        return buffer.charAt(x + offsetX, y + offsetY);
    }
}

class Console {
    private List<Viewport> viewports = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /*
        In this method we are applying Facade. In some cases the client don't want to know the low
        level details, so we provide a Facade.
     */
    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(height, width);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);

        return console;
    }

    public void addViewport(Viewport viewport) {
        this.viewports.add(viewport);
    }

    public void render() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                for (Viewport viewport : viewports) {
                    System.out.print(viewport.charAt(x, y));
                }
                System.out.println();
            }
        }
    }
}