package algo_2_proje;
/**
 * 05140000643 MERTCAN TAKIL   
 * 05140000686 SERKAY YÜKSEL
 * 05140000627 SAFA ORHAN
 *
 * 
 */
public class Customer {
    private int CustomerID;
    private String Name;
    private String Surname;
    public Customer()
    {CustomerID=0; Name = "" ; Surname = "";}
    public Customer(int ID,String name,String surname)
    {CustomerID=ID; Name = name ; Surname = surname;   }
    public Customer(Customer cpyCustomer)
    {this(cpyCustomer.getcustomerID(),cpyCustomer.getName(),cpyCustomer.getSurname());}
    public int getcustomerID()
    {return CustomerID;}
    public String getName()
    {return Name;}
    public String getSurname()
    {return Surname;}
    public void setcustomerID(int ID)
    {  if(ID<0)
         this.CustomerID=0;
       else
         this.CustomerID=ID;}
    public void setName(String name)
    {this.Name=name;}
    public void setSurname(String surname)
    {this.Surname=surname;}
    public String tostrings()
    {return "CustomerID = "+this.getcustomerID()+"\n  NAME = "+this.getName()+"\n Surname = "+this.getSurname();}
}
