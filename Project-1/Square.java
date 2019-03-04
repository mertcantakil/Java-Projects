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

public class Square implements IShape{
     
    private int x,y,width;
    
    @Override
    public int getX() {
       return this.x;
    }

    public Square(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public int getY() {
        return this.y;
    }
    public int getWidth() {
        return this.width;
    }

    @Override
    public String toString() {
        return "Square{" + "x=" + x + ", y=" + y + ", width=" + width + '}';
    }

    @Override
    public double getArea() {
        return width*width;
    }

    @Override
    public double getPerimeter() {
        return 4*width;
    }
}
