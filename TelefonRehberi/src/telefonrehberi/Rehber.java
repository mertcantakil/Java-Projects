/*
    MERTCAN TAKIL 05140000643
    SERKAY YÜKSEL 05140000686
    SAFA ORHAN 05140000627
 */
package telefonrehberi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Metox
 */
public class Rehber {
    private String file;
    private DoublyLinkedList rehber = new DoublyLinkedList();
    public Rehber(String File) throws FileNotFoundException, IOException {
        Oku(File);
        file=File;
    }
    private void Oku(String File) throws FileNotFoundException, IOException
    {
        InputStreamReader ISReader = new InputStreamReader(new FileInputStream(File));
        BufferedReader br = new BufferedReader(ISReader);
        String line;
 
        while ((line = br.readLine()) != null)
            KisiEkle(line);
        br.close();
   }
    public void KisiEkle(String line){
        String[] kayit=line.split(",");
        Bilgi kisi = new Bilgi();
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        kisi.setAdSoyad(kayit[0]);
        for(int i=1;i<kayit.length;i++)
            kisi.addTelNo(kayit[i]);

        if(rehber.size() > 0) {
            Collator collator = Collator.getInstance(new Locale("tr","TR"));

            if(collator.compare(kisi.getAdSoyad(), iterator.peek().getAdSoyad()) > 0)
                do
                    iterator.next();
                while(iterator.hasNext() && collator.compare(kisi.getAdSoyad(), iterator.peek().getAdSoyad()) > 0);
        }
        iterator.insertHere(kisi);   
    }
    public void KisiSil(java.awt.List list)
    {
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        Collator collator = Collator.getInstance(new Locale("tr","TR"));
 
        while(iterator.hasNext())
        {
            if(collator.compare(list.getSelectedItem(), iterator.peek().getAdSoyad()) == 0){
                iterator.delete();
                    break;
            }
            iterator.next();
        }   
    }
    public void AdSoyadlariYazdir(boolean ters, java.awt.List list){
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        
        list.removeAll();
        if(ters){
            iterator=iterator.reverse();
            while(iterator.hasNext()){//hasPrevious
                list.add(iterator.peek().getAdSoyad());
                iterator.previous();
            }
        }
        else
            while(iterator.hasNext()){
                list.add(iterator.peek().getAdSoyad());
                iterator.next();
            }
    }
    public void NumaralarYazdir(java.awt.List list, String Kisi){
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        Collator collator = Collator.getInstance(new Locale("tr","TR"));
        list.removeAll();
        
        while(iterator.hasNext() && collator.compare(Kisi, iterator.peek().getAdSoyad()) != 0)
            iterator.next();
        
        for(String no: iterator.peek().getTelNo())
            list.add(no);
    }
    public void Kaydet() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file,false));
        String outsakla="";
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        while(iterator.hasNext()){
            
            outsakla+=iterator.peek().getAdSoyad()+",";
            for(int i=0;i<iterator.peek().getTelNo().size()-1;i++)
                outsakla+=iterator.peek().getTelNo().get(i)+",";
            outsakla+=iterator.peek().getTelNo().get(iterator.peek().getTelNo().size()-1)+"\r\n";
            iterator.next();
            
        }
        out.write(outsakla);
        out.close();
    }
     public void AraVeYazdir(java.awt.List list, String Kisi){
        DoublyLinkedList.DoublyLinkedIterator iterator = rehber.iterator();
        Collator collator = Collator.getInstance(new Locale("tr","TR"));
        
        list.removeAll();
        while(iterator.hasNext() && collator.compare(Kisi, iterator.peek().getAdSoyad()) > 0)
            iterator.next();
        
        if(iterator.hasNext())
            list.add(Kisi);
    }
}
    

