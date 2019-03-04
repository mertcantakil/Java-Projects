/*
    MERTCAN TAKIL 05140000643
    SERKAY YÜKSEL 05140000686
    SAFA ORHAN 05140000627
*/
package telefonrehberi;

import java.util.ArrayList;

/**
 *
 * @author Metox
 */

public class Bilgi {
    private ArrayList<String> telNo=new ArrayList<>();
    private String adSoyad;
    
    
    public Bilgi() {
        adSoyad="";
    }
    public Bilgi(String adSoyad,String telNo){
        this.adSoyad=adSoyad;
        this.telNo.add(telNo);
    }

    /**
     * @return the telNo
     */
    public ArrayList<String> getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void addTelNo(String telNo) {
        this.telNo.add(telNo);
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }
    public String toString(){
        String temp= "Ad Soyad: "+this.adSoyad+"\nTelefon Numaraları: ";
        if(telNo.size()>0)
            temp+=telNo.get(0);
        for(int i=1;i<telNo.size();i++){
            temp+=","+telNo.get(i);
        }
        return temp;

    }
    
    
 }
    
  
   
    

    
    
    
    

