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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
public class GetTheStock implements Runnable {
    private int startTime;
    private String stock;
    private double price;
    private ISubject stockOwner;
    public GetTheStock(ISubject stockOwner, int newStartTime, String newStock, double newPrice){
        this.stockOwner=stockOwner;
        stock=newStock;
        price=newPrice;
        startTime=newStartTime;
    }
    @Override
    public void run() {
        for (int i = 1; i < 20; i++) {
            try{
                Thread.sleep(1000);
                 
            }
            catch(InterruptedException e){}
            double randNum = (Math.random()*(.06))- .03;
            DecimalFormat df= new DecimalFormat("#.##");
            price = Double.valueOf(df.format((price+randNum)));
            if(stock == "aPrice") ((StockOwner) stockOwner).setAPrice(price);
            if(stock == "bPrice") ((StockOwner) stockOwner).setBPrice(price);
            if(stock == "cPrice") ((StockOwner) stockOwner).setCPrice(price);
            if(stock == "dPrice") ((StockOwner) stockOwner).setDPrice(price);
            if(stock == "ePrice") ((StockOwner) stockOwner).setEPrice(price);
            try{
                  File dosya = new File("yeni.txt");
                  FileWriter yazici = new FileWriter(dosya,true);
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  yaz.write("\r\n"+ stock+ ": "+ df.format((price+randNum))+" "+ df.format(randNum)+ "\r\n");
                  yaz.close();
                  System.out.println("Ekleme İşlemi Başarılı");
            }
            catch (Exception hata){
                  hata.printStackTrace();
            }

        }
    }
     public void writeThePricesTxt(){
           
    }
    
}
