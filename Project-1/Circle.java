/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donemproje1;

/**
 *
 * @author mertc
 */

// AHMET FARUK AKTAŞ 05140000600
// MERTCAN TAKIL 05140000643 
// SERKAY YÜKSEL 0514000686

public class Circle implements IShape {
   
    private int x,y;

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    private double radius;
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
       return this.y;
    }
    
    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "x=" + x + ", y=" + y + ", radius=" + radius + '}';
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0*Math.PI*radius;
    }

}
