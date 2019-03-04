package algo_2_proje;
/**
 *
 * 05140000643 MERTCAN TAKIL   
 * 05140000686 SERKAY YÜKSEL
 * 05140000627 SAFA ORHAN
 */
public class InternationalCustomer extends Customer {
    private String Country;
    private String City;
    
    public InternationalCustomer()
    {Country=""; City ="";}
    public InternationalCustomer(int CustomerId,String Name , String Surname,String country, String city)
    {  
      super(CustomerId,Name,Surname);
      this.Country=country; this.City=city;
    }
    public InternationalCustomer(InternationalCustomer cpyInternationalCustomer)
    {this( 
            cpyInternationalCustomer.getcustomerID(),
            cpyInternationalCustomer.getName(),
            cpyInternationalCustomer.getSurname(),
            cpyInternationalCustomer.getCountry(),
            cpyInternationalCustomer.getCity()        
    );}

   public String getCountry()
   {return Country;}
   public String getCity()
   {return City;}
   public void setCountry(String country)
   {this.Country=country;}
   public void setCity(String city)
   {this.City=city;}
   public String tostrings()
   {return" \n CustomerID = "+this.getcustomerID()+"\n NAME = "+this.getName()+"\n Surname = "+this.getSurname()+"\n Country = "+this.getCountry()+"\n City = "+this.getCity();}



}





