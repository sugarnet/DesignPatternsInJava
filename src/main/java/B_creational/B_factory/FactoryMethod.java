/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_creational.B_factory;

/**
 *
 * @author Almis
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Point p1 = Point.newCartesianPoint(3, 4);
        Point p2 = Point.newPolarPoint(3, 4);
        System.out.println(p1);
        System.out.println(p2);
    }
}

/**
 * 
 * @author Almis
 */
class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public static Point newCartesianPoint(double x, double b) {
        return new Point(x, b);
    }
    
    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
