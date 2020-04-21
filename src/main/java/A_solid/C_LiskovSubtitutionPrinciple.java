/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_solid;

/**
 *
 * @author Almis
 */
public class C_LiskovSubtitutionPrinciple {
    
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        // area = width * 10;
        System.out.println("Expected area of " + (width * 10) +
                ", got " + r.getArea());
    }
    
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        useIt(r);
        
        Rectangle s = new Square(2);
        useIt(s);
    }
    
}

class Rectangle {
    protected int width;
    protected int height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
    
    public boolean isSquare() {
        return width == height;
    }
    
    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + '}';
    }
    
}

class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }
    
    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}

class Square extends Rectangle {

    public Square() {
    }
    
    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height); //To change body of generated methods, choose Tools | Templates.
        super.setWidth(height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width); //To change body of generated methods, choose Tools | Templates.
        super.setHeight(width); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
