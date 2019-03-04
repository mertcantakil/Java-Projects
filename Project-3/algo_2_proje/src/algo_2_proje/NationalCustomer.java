
package algo_2_proje;

/**
 *
 * 05140000643 MERTCAN TAKIL   
 * 05140000686 SERKAY YÜKSEL
 * 05140000627 SAFA ORHAN
 */
public class NationalCustomer extends Customer {
    private int LicencePlateNumber;
    private String Occupation;
    
    public NationalCustomer()
    {LicencePlateNumber=0 ; Occupation="" ;}
    
    public NationalCustomer(int CustomerId,String Name , String Surname,int licenceplatenumber ,String occupation)
    {  
       super(CustomerId,Name,Surname);
       this.Occupation=occupation;
       this.LicencePlateNumber=licenceplatenumber;
    }
    public NationalCustomer(NationalCustomer cpyNationalCustomer)
    {this(  cpyNationalCustomer.getcustomerID(),
            cpyNationalCustomer.getName(),
            cpyNationalCustomer.getSurname(),
            cpyNationalCustomer.getLicencePlateNumber(),
            cpyNationalCustomer.getOccupation());}
    
    public int getLicencePlateNumber()
    {return LicencePlateNumber;}
    public String getOccupation()
    {return Occupation;}
    public void setOccupation(String occupation)
    {this.Occupation=occupation;}
    public void setLicencePlateNumber(int ID)
    {this.LicencePlateNumber=ID;}
    public String tostrings()
    {return "\n CustomerID = "+this.getcustomerID()+"\n LicencePlateNumber = "+this.getLicencePlateNumber()+"\n NAME = "+this.getName()+"\n Surname = "+this.getSurname()+"\n Occupation = "+this.getOccupation();}
}
