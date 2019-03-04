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

public class Rectangle implements IShape{
    
    private int x,y,height,width;
  
    @Override
    public int getX() {
       return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
    public int getHeight() {
        return this.height;
    }
    public int getWidth() {
        return this.width;
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Rectangle{" + "x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + '}';
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }
}
