/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdesignpattern;

import java.util.ArrayList;

/**
 *
 * @author mertc
 */
public class StockOwner implements ISubject{

    private ArrayList<IObserver> observers;
    private double aPrice, bPrice, cPrice, dPrice, ePrice;
    
    public StockOwner(){
        observers = new ArrayList<IObserver>();
    }
    
    @Override
    public void register(IObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(IObserver deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex+1)+ "deleted.");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(IObserver observer : observers){
            observer.update(aPrice, bPrice, cPrice, dPrice, ePrice);
        }
    }
    public void setAPrice(double newAPrice){
        this.aPrice=newAPrice;
        notifyObserver();
    }
    public void setBPrice(double newBPrice){
        this.bPrice=newBPrice;
        notifyObserver();
    }
    public void setCPrice(double newCPrice){
        this.cPrice=newCPrice;
        notifyObserver();
    }
    public void setDPrice(double newDPrice){
        this.dPrice=newDPrice;
        notifyObserver();
    }
    public void setEPrice(double newEPrice){
        this.ePrice=newEPrice;
        notifyObserver();
    }
    
}
