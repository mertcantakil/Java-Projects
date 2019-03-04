/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donemproje1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

// AHMET FARUK AKTAŞ 05140000600
// MERTCAN TAKIL 05140000643 
// SERKAY YÜKSEL 0514000686

public class Donemproje1 {
    public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
        ArrayList<IShape> Shapes= new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("shapes.txt")));
        String line;
        
        while((line = br.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(line, " ,()");
            String shape = st.nextToken();
            if(shape.equals("Rectangle")) Shapes.add(new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            else if(shape.equals("Circle")) Shapes.add(new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            else Shapes.add(new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));   
        }
        
        Iterator iter = new Iterator(Shapes);
        while(iter.hasNext()) {
            IShape shape = iter.next();
            System.out.println(shape);
            System.out.println("Alan = " + shape.getArea());
            System.out.println("Çevre = " + shape.getPerimeter());
        }
    }
}
        
