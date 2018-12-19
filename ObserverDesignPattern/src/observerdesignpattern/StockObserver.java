/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdesignpattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author mertc
 */
public class StockObserver implements IObserver{
    
    private double aPrice, bPrice, cPrice, dPrice, ePrice;
    private static int observerIDTracker=0;
    private int observerID;
    private ISubject stockOwner;
    public StockObserver(ISubject stockOwner){
        this.stockOwner=stockOwner;
        this.observerID=++observerIDTracker;
        System.out.println("New Observer"+ this.observerID);
        stockOwner.register(this);  
    }
    
    @Override
    public void update(double aPrice, double bPrice, double cPrice, double dPrice, double ePrice) {
        this.aPrice=aPrice;
        this.bPrice=bPrice;
        this.cPrice=cPrice;
        this.dPrice=dPrice;
        this.ePrice=ePrice;
        printThePrices();
    }
    public void printThePrices(){
        System.out.println("\n" + observerID+ "\nA Price:"+aPrice+"\nB Price:"+bPrice+"\nC Price:"+cPrice+"\nD Price:"+dPrice+"\nE Price:"+ePrice+"\n");
    }

    
}
