/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdesignpattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ObserverDesignPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        StockOwner stockOwner= new StockOwner();
       StockObserver observer1= new StockObserver(stockOwner);
       stockOwner.setAPrice(204.00);
       stockOwner.setBPrice(394.00);
       stockOwner.setCPrice(618.60);
       stockOwner.setDPrice(703.92);
       stockOwner.setEPrice(432.04);
       
       new Thread(new GetTheStock(stockOwner, 2,"A Price", 204.00)).start();
       new Thread(new GetTheStock(stockOwner, 2,"B Price", 394.00)).start();
       new Thread(new GetTheStock(stockOwner, 2,"C Price", 618.60)).start();
       new Thread(new GetTheStock(stockOwner, 2,"D Price", 703.92)).start();
       new Thread(new GetTheStock(stockOwner, 2,"E Price", 432.04)).start();

        
    }
    
}
