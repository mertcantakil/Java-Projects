/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdesignpattern;

/**
 *
 * @author mertc
 */
public interface IObserver {
    
    public void update(double aPrice, double bPrice, double cPrice, double dPrice, double ePrice);
    
    
}
