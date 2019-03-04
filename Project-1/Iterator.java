/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donemproje1;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author mertc
 */

// AHMET FARUK AKTAŞ 05140000600
// MERTCAN TAKIL 05140000643 
// SERKAY YÜKSEL 0514000686

public class Iterator implements java.util.Iterator<IShape> {

    private ArrayList<IShape> array;  //ArrayList<Vector> will be set here
    private int          index;

    public Iterator(ArrayList<IShape> examples) {
        this.array = examples;
        index = 0;
    }

    @Override
    public IShape next() {
        return hasNext() ? array.get(index++) : null;
    }

    @Override
    public boolean hasNext() {
        return !(array.size() == index);
    }

    @Override
    public void remove() {
        if(index <= 0) {
            throw new IllegalStateException("You can't delete element before first next() method call");
        }
        array.remove(--index);
    }
    
    @Override
    public void forEachRemaining(Consumer<? super IShape> action) {
    }
    
}
