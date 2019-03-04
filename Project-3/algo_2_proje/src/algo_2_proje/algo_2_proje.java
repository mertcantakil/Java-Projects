package algo_2_proje;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * 05140000643 MERTCAN TAKIL
 * 05140000627 SAFA ORHAN
 * 05140000686 SERKAY YÜKSEL
 */
public class algo_2_proje {                     
    public static void main(String[] args) throws IOException{ 
        
        Customer[] all_customer = new Customer[1]; /*dinamik customer dizisi*/ /*200'LE SINIRLANDIRILMAMIŞTIR.SINIRSIZ MÜŞTERİ OLABİLİR*/
        String[][] products=new String[1][];        /*dinamik ürün ve puanların oldugu dizi*/
        all_customer=create_array();                /*txt'den okunup müşterileri bulan ve diziye atan method*/
        products=create_products_array(products,all_customer.length); /*txt'den okuyup müşteri puanları ve ürünleri oluşturan method*/
        menu(all_customer,products,all_customer.length-1);
 }
public static Customer[] create_array() throws FileNotFoundException, IOException
    {   
        Customer[] all_customer = new Customer[1];   
        File file = new File("Firma.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        int counter=0;
            while (satir!=null) {
                String[] parts = satir.split(",");
                if(parts[0].equals("n"))
                {
                   NationalCustomer new_nation =new NationalCustomer();
                   new_nation.setcustomerID(Integer.parseInt(parts[1]));
                   new_nation.setName(parts[2]);
                   new_nation.setSurname(parts[3]);
                   new_nation.setLicencePlateNumber(Integer.parseInt(parts[4]));
                   new_nation.setOccupation(parts[5]);
                   all_customer[counter]=new_nation;
                   ++counter;
                   Customer[] new_all_customer = new Customer[all_customer.length+1];
                   System.arraycopy(all_customer, 0, new_all_customer, 0, all_customer.length);
                   all_customer = new_all_customer;
                }
                if(parts[0].equals("i"))
                {
                   InternationalCustomer new_international = new InternationalCustomer();
                   new_international.setcustomerID(Integer.parseInt(parts[1]));
                   new_international.setName(parts[2]);
                   new_international.setSurname(parts[3]);
                   new_international.setCountry(parts[4]);
                   new_international.setCity(parts[5]);
                   all_customer[counter]=new_international;
                   ++counter;
                   Customer[] new_all_customer = new Customer[all_customer.length+1]; /*Array'e dinamiklik kazandıran yer*/
                   System.arraycopy(all_customer, 0, new_all_customer, 0, all_customer.length);
                   all_customer = new_all_customer;
                }
                satir = reader.readLine();
            }
    return all_customer;
}
public static String[][] create_products_array(String[][] products,int count_people) throws FileNotFoundException, IOException
{      
        File file = new File("Firma.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        String[] parts_one = satir.split(",");
        String[][] new_products=new String[count_people][parts_one.length-1];
        products=new_products;
        for(int a =1 ;a <parts_one.length;a++)
        products[0][a-1]=parts_one[a];
        int counter =1;
        satir = reader.readLine();
         while (satir!=null) {
             String[] parts = satir.split(",");
             if(! parts[0].equals("n") && ! parts[0].equals("i"))
             {
                for(int a =0 ;a <parts.length;a++)
                    products[counter][a]=parts[a];
               
               ++counter; 
             }
            satir = reader.readLine();
        }
    return products;
}
public static void menu(Customer[] all_customer,String[][] products,int count_people) throws IOException
{ 
  System.out.println("\t\t\t------------ MENU ---------------");
  System.out.println("\n1.Her bir ürün için o ürüne ait ortalama derecelendirme puanını hesaplama ...");
  System.out.println("2.Her bir ürün için sadece ulusal müşterileri dikkate alarak elde edilen ortalama derecelendirme\n" +
"puanını hesaplama ...");
  System.out.println("3.Her bir ürün için sadece uluslararası müşterileri dikkate alarak elde edilen ortalama\n" +
"derecelendirme puanını hesaplayama ...");
  System.out.println("4.Her bir ürün için sadece ulusal müşterilerden mesleği doktor olanlar dikkate alınarak elde edilen\n"
+"ortalama derecelendirme puanını hesaplama ...");
  System.out.println("5.Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan ulusal\n" +
"müşterilerin bilgilerini yazdırma ...");
  System.out.println("6.Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan uluslararası\n" +
"müşterilerin bilgilerini yazdırma ...");
   System.out.println("7.Müşteri Ekleyip puanlandırma ...");
   System.out.println("8.Klavyeden giriş yapılan müşterilerin bilgilerini yazdırma ve sadece bu müşterilerin\n" +
"puanlamalarını kullanarak her bir ürün için ortalama derecelendirme puanını hesaplama");
System.out.print("\n Seciminizi giriniz(1-8): ");
Scanner input = new Scanner(System.in);
String sayi;
int deger=0;
sayi = input.next();
while(true)
{    
    deger =parseWithDefault(sayi,deger);
    if(deger<9 && deger>0)
            break;
    else
       {
            System.out.print("\n --- Hatalı Giriş --- \n\n Seciminizi giriniz(1-8): ");
            sayi = input.next();   
        }
}
if(deger==1)
her_ürün_ortalaması(all_customer,products, count_people);
if(deger==2)
sadece_ulusal_müşterilerin_ortalaması(all_customer, products,count_people);     
if(deger==3)
sadece_uluslar_arası_müşterilerin_ortalaması(all_customer,products, count_people);
if(deger==4)
sadece_ulusal_müşterilerin_doktor_olanları(all_customer,products, count_people);
if(deger==5)
ürüne_ait_ortalama_derecelendirmenin_altında_puan_vermiş_olan_ulusal(all_customer,products, count_people);
if(deger==6)
ürüne_ait_ortalama_derecelendirmenin_altında_puan_vermiş_olan_uluslar_arası(all_customer,products, count_people);
if(deger==7)
kişi_ekleyip_puanlatma(all_customer,products, count_people);
if(deger==8)
klavyeden_gelenler(all_customer,products, count_people);
}
public static int parseWithDefault(String s, int def) {    /*Alınan String'in İnteger olup olmadığını kontrol eder*/
    try {
        return Integer.parseInt(s);
    }
    catch (NumberFormatException e) {
        return def;
    }
}
public static void her_ürün_ortalaması(Customer[] all_customer,String[][] products,int count_people) throws IOException
{   
    float[] avarege=new float[products[0].length];
    System.out.println("\n\n1.Her bir ürün için o ürüne ait ortalama derecelendirme puanını hesaplama ...\n");
    for(int i=0 ; i < products[0].length;i++ )
     {
        for (int a =1;a <products.length;a++)
        avarege[i]+= Float.parseFloat(products[a][i]);
     }
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(products.length-1);
    System.out.println("\n\t\tOrtalamalar");
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.print("\t"+products[0][i]);
    System.out.println();
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
    ana_menuye_donme(all_customer,products, count_people);
}
public static void sadece_ulusal_müşterilerin_ortalaması(Customer[] all_customer,String[][] products,int count_people) throws IOException
{   
    System.out.println("\n\n2.Her bir ürün için sadece ulusal müşterileri dikkate alarak elde edilen ortalama hesaplama ...\n\n");
     float[] avarege=new float[products[0].length];
     String[][] clone_products=new String[products.length][products[0].length];
     for (int a =0;a <products.length;a++)
         for(int i=0 ; i < products[0].length;i++ )
            clone_products[a][i]=products[a][i];
     for(int i =0 ;i<all_customer.length-1;i++)
     {
         String a =all_customer[i].getClass().getSimpleName();
         if(!a.equals("NationalCustomer"))
            {
                for(int j =0 ;j < clone_products[0].length ; j++)
                    clone_products[i+1][j]="0";
            }
     }
     int kiyas=0;
     int national_kisi_sayısı=0;
     for (int a =0;a <products.length;a++)
        {
            for(int i=0 ; i < products[0].length;i++ )
                {
                    kiyas=parseWithDefault(clone_products[a][i],kiyas);
                    if(0!=kiyas && a>0)
                        ++national_kisi_sayısı;
                }
        }
     for(int i=0 ; i < products[0].length;i++ )
        {
            for (int a =1;a <products.length;a++)
                avarege[i]+= Float.parseFloat(clone_products[a][i]);
        }
     for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(national_kisi_sayısı/(products[0].length));
     System.out.println("\n\t\tOrtalamalar");
     System.out.println();
     for(int i=0 ; i < products[0].length;i++ )
        System.out.print("\t"+products[0][i]);
     System.out.println();
     System.out.println();
     for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
     ana_menuye_donme(all_customer,products, count_people);
}
public static void sadece_uluslar_arası_müşterilerin_ortalaması(Customer[] all_customer,String[][] products,int count_people) throws IOException
 {    
    System.out.println("\n\n3.Her bir ürün için sadece uluslararası müşterileri dikkate alarak elde edilen ortalama hesaplama ...\n\n");
    float[] avarege=new float[products[0].length];
    String[][] clone_products=new String[products.length][products[0].length];
    for (int a =0;a <products.length;a++)
         for(int i=0 ; i < products[0].length;i++ )
            clone_products[a][i]=products[a][i];
    for(int i =0 ;i<all_customer.length-1;i++)
    {
       String a =all_customer[i].getClass().getSimpleName();
       if(!a.equals("InternationalCustomer"))
       {
           for(int j =0 ;j < clone_products[0].length ; j++)
                clone_products[i+1][j]="0";
       }
    }
    int kiyas=0;
    int national_kisi_sayısı=0;
    for (int a =0;a <products.length;a++)
    {
       for(int i=0 ; i < products[0].length;i++ )
       {
            kiyas=parseWithDefault(clone_products[a][i],kiyas);
            if(0!=kiyas && a>0)
               ++national_kisi_sayısı;
       }
    }
    for(int i=0 ; i < products[0].length;i++ )
    {
        for (int a =1;a <products.length;a++)
            avarege[i]+= Float.parseFloat(clone_products[a][i]);
    }
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(national_kisi_sayısı/(products[0].length));
    System.out.println("\n\t\tOrtalamalar");
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.print("\t"+products[0][i]);
    System.out.println();
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
    ana_menuye_donme(all_customer,products, count_people);
}
public static void sadece_ulusal_müşterilerin_doktor_olanları(Customer[] all_customer,String[][] products,int count_people) throws IOException
{ 
    System.out.println("\n\n4.Her bir ürün için sadece ulusal müşterilerden mesleği doktor olanların ortalama hesaplaması ...\n\n");
    NationalCustomer new_nation =new NationalCustomer();
    float[] avarege=new float[products[0].length];
    String[][] clone_products=new String[products.length][products[0].length];
    for (int a =0;a <products.length;a++)
        for(int i=0 ; i < products[0].length;i++ )
          clone_products[a][i]=products[a][i];
    for(int i =0 ;i<all_customer.length-1;i++)
    {
       String a =all_customer[i].getClass().getSimpleName();
       if(!a.equals("NationalCustomer"))
       {   
            for(int j =0 ;j < clone_products[0].length ; j++)
                clone_products[i+1][j]="0";
        }else 
            {
                new_nation=(NationalCustomer) all_customer[i];
                if(!new_nation.getOccupation().equals("Doktor"))
                    for(int j =0 ;j < clone_products[0].length ; j++)
                        clone_products[i+1][j]="0";
            }
    }
    int kiyas=0;
    int national_kisi_sayısı=0;
    for (int a =0;a <products.length;a++)
    {
        for(int i=0 ; i < products[0].length;i++ )
        {
            kiyas=parseWithDefault(clone_products[a][i],kiyas);
            if(0!=kiyas && a>0)
            ++national_kisi_sayısı;
        }
    }
    for(int i=0 ; i < products[0].length;i++ )
    {
      for (int a =1;a <products.length;a++)
        avarege[i]+= Float.parseFloat(clone_products[a][i]);
    }
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(national_kisi_sayısı/(products[0].length));
    System.out.println("\n\t\tOrtalamalar");
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
       System.out.print("\t"+products[0][i]);
    System.out.println();
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
       System.out.printf("\t%.2f",avarege[i]); 
    ana_menuye_donme(all_customer,products, count_people);
}
public static void ürüne_ait_ortalama_derecelendirmenin_altında_puan_vermiş_olan_ulusal(Customer[] all_customer,String[][] products,int count_people) throws IOException
{  
   System.out.println("\n\n5.Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan ulusal\n" +
   "müşterilerin bilgilerini yazdırma ...\n");
   System.out.println("\n\t\tOrtalamalar");
   System.out.println();
   NationalCustomer new_nation =new NationalCustomer();
   float[] avarege=new float[products[0].length];
   for (int a =0;a <products[0].length;a++)
       System.out.print("\t"+products[0][a]);
   for(int i=0 ; i < products[0].length;i++ )
    {
      for (int a =1;a <products.length;a++)
        avarege[i]+= Float.parseFloat(products[a][i]);
    }
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(products.length-1);
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
    for(int c=0 ; c < products[0].length;c++ )
    {
        for(int i =0 ;i<all_customer.length-1;i++)
        {
            String a =all_customer[i].getClass().getSimpleName();
            if(a.equals("NationalCustomer"))
            {
                if( avarege[c]>Float.parseFloat(products[i+1][c]))
                { 
                    new_nation=(NationalCustomer) all_customer[i];
                    System.out.printf("\n\n\t- %s - ürününe - %s %s -  ↓ %d  puan vermiştir bilgileri aşağıdadır ↓ \n",products[0][c],new_nation.getName(),new_nation.getSurname(),Integer.parseInt(products[i+1][c]));
                    System.out.println(all_customer[i].tostrings());
                }
            }
        }
    }
    ana_menuye_donme(all_customer,products, count_people);
}
public static void ürüne_ait_ortalama_derecelendirmenin_altında_puan_vermiş_olan_uluslar_arası(Customer[] all_customer,String[][] products,int count_people) throws IOException
{
   System.out.println("\n\n6.Her bir ürün için, o ürüne ait ortalama derecelendirmenin altında puan vermiş olan uluslararası\n" +
   "müşterilerin bilgilerini yazdırma ...\n");
   System.out.println("\n\t\tOrtalamalar");
   System.out.println();
   InternationalCustomer new_nation =new InternationalCustomer();
   float[] avarege=new float[products[0].length];
   for (int a =0;a <products[0].length;a++)
        System.out.print("\t"+products[0][a]);
   for(int i=0 ; i < products[0].length;i++ )
    {
        for (int a =1;a <products.length;a++)
            avarege[i]+= Float.parseFloat(products[a][i]);
    }
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(products.length-1);
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
   for(int c=0 ; c < products[0].length;c++ )
    {
       for(int i =0 ;i<all_customer.length-1;i++)
        {
            String a =all_customer[i].getClass().getSimpleName();
            if(a.equals("InternationalCustomer"))
            {
                if( avarege[c]>Float.parseFloat(products[i+1][c]))
                { 
                    new_nation=(InternationalCustomer ) all_customer[i];
                    System.out.printf("\n\n\t- %s - ürününe - %s %s -  ↓ %d  puan vermiştir bilgileri aşağıdadır ↓ \n",products[0][c],new_nation.getName(),new_nation.getSurname(),Integer.parseInt(products[i+1][c]));
                    System.out.println(all_customer[i].tostrings());
                }
            }
        }
    }
   ana_menuye_donme(all_customer,products, count_people);
}
public static void kişi_ekleyip_puanlatma(Customer[] all_customer,String[][] products,int count_people) throws IOException
{  
     System.out.print("\n  -- Kişi Ekleyip Puanlama -- ");
    Scanner input = new Scanner(System.in);
    String seçim;
    while(true)
    {
        System.out.print("\n\n Eklemek istediğiniz kisinin locasyonu (N/n) (i)  Çıkmak Isterseniz (E/e) : ");
        seçim = input.next(); /*KİŞİ SINIRI OLMADIĞI İÇİN 200 KULLANICIDA PROGRAM KENDİNİ DURDURMAZ!*/
        if(seçim.toLowerCase().equals("e"))
        break; 
        if(seçim.toLowerCase().equals("n"))
        all_customer=customer_national_add_array(all_customer);
        if(seçim.toLowerCase().equals("i"))
        all_customer=customer_international_add_array(all_customer);
        if(seçim.toLowerCase().equals("i") || seçim.toLowerCase().equals("n"))
        products=products_array_add_new_rank(products,all_customer.length);
        else
        System.out.print("\n\n --- Hatalı Giriş --- \n");  
    }
    ana_menuye_donme(all_customer,products, count_people);
}
public static void ana_menuye_donme(Customer[] all_customer,String[][] products,int count_people) throws IOException
{
System.out.print("\n\n\n Ana Menüye Dönmek İster Misiniz ? (E/e) (H/h): ");
Scanner input = new Scanner(System.in);
String seçim = input.next();
while(true)
{    
    if(seçim.equals("H") || seçim.equals("h"))
            System.exit(0);
    else if(seçim.equals("E") || seçim.equals("e"))     
        {
            menu(all_customer,products, count_people);
            break;
        }
    System.out.print("\n --- Hatalı Giriş --- \n\n Ana Menüye Dönmek İster Misiniz ? (E/e) (H/h): ");
    seçim = input.next();
}
}
public static Customer[] customer_national_add_array(Customer[] all_customer)
{           System.out.print("\n\t\t -- National Kişi Ekleme -- \n");
            Scanner input = new Scanner(System.in);
            String seçim; int deger=0;
            NationalCustomer new_nation =new NationalCustomer();
            while(true)
            {
             System.out.print("\n CustomerID giriniz: ");
             seçim=input.next();
             deger =parseWithDefault(seçim,deger);
             if(deger==0)
             System.out.print("\n --- Hatalı Giriş --- \n");
             else
                 break;
            }
            new_nation.setcustomerID(deger);
            System.out.print("\n Name giriniz: ");
            seçim = input.next();
            new_nation.setName(seçim);
            System.out.print("\n Surname giriniz: ");
            seçim = input.next();
            new_nation.setSurname(seçim);
            deger=0;
            while(true)
            {
             System.out.print("\n LicencePlateNumber giriniz: ");
             seçim=input.next();
             deger =parseWithDefault(seçim,deger);
             if(deger==0)
             System.out.print("\n --- Hatalı Giriş --- \n");
             else
                 break;
            }
            new_nation.setLicencePlateNumber(deger);
            System.out.print("\n Occupation giriniz: ");
            seçim = input.next();
            new_nation.setOccupation(seçim);
            all_customer[all_customer.length-1]=new_nation;
            Customer[] new_all_customer = new Customer[all_customer.length+1];
            System.arraycopy(all_customer, 0, new_all_customer, 0, all_customer.length);
            all_customer = new_all_customer;
            return all_customer; 
}
public static Customer[] customer_international_add_array(Customer[] all_customer)
{           System.out.print("\n\t\t -- International Kişi Ekleme -- \n");
            Scanner input = new Scanner(System.in);
            InternationalCustomer new_international = new InternationalCustomer();
            String seçim; int deger=0;
            while(true)
            {
             System.out.print("\n CustomerID giriniz: ");
             seçim=input.next();
             deger =parseWithDefault(seçim,deger);
             if(deger==0)
             System.out.print("\n --- Hatalı Giriş --- \n");
             else
                 break;
            }
            new_international.setcustomerID(deger);
            System.out.print("\n Name giriniz: ");
            seçim = input.next();
            new_international.setName(seçim);
            System.out.print("\n Surname giriniz: ");
            seçim = input.next();
            new_international.setSurname(seçim);
            System.out.print("\n Country giriniz: ");
            seçim = input.next();
            new_international.setCountry(seçim);
            System.out.print("\n City giriniz: ");
            seçim = input.next();
            new_international.setCity(seçim);
            all_customer[all_customer.length-1]=new_international;
            Customer[] new_all_customer = new Customer[all_customer.length+1];
            System.arraycopy(all_customer, 0, new_all_customer, 0, all_customer.length);
            all_customer = new_all_customer;
            return all_customer; 
}
public static String[][] products_array_add_new_rank(String[][] products,int count_people)
{   
    System.out.print("\n\n\t\t -- Urun Puanlama -- \n\n");
    String[][] new_products=new String[count_people][products[0].length];
    System.arraycopy(products,0,new_products,0,products.length);
    Scanner input = new Scanner(System.in); String seçim;
    int[] hesaplama_dizisi = new int[count_people-2];
    for(int i=0;i<count_people-2;i++)
    hesaplama_dizisi[i]=0;
    for(int i=0;i<products[0].length-1;i++)
    {
      System.out.printf("\n%s ürününe kac verdiniz : ",products[0][i]);
      seçim = input.next();
      new_products[count_people-1][i]=seçim;
    }
    for(int i=1 ; i <new_products.length-1;i++ )
    for (int a =0;a < products[0].length-1;a++)
    hesaplama_dizisi[i-1]+=Math.abs(Integer.parseInt (new_products[count_people-1][a])- Integer.parseInt(new_products[i][a]));
    int yeri=0;
    int[] en_benzerler_dizisi_yeri=new int[count_people-2];
    for(int i=0;i<count_people-2;i++)
    en_benzerler_dizisi_yeri[i]=-1;
    int kiyas=hesaplama_dizisi[0];
    for(int i=1;i<count_people-2;i++)
    {  
      if(hesaplama_dizisi[i]<kiyas)
      {
         yeri=i;
         kiyas=hesaplama_dizisi[i];
      }
    }
    for(int i=0;i<count_people-2;i++)
    {
      if(hesaplama_dizisi[i]==hesaplama_dizisi[yeri])
          en_benzerler_dizisi_yeri[i]=i;
    }
    float sayac=0,ortalama=0;
    for(int i=0;i<count_people-2;i++)
    {
      if(en_benzerler_dizisi_yeri[i]!=-1)
       {  
          ++sayac;
          ortalama+=Float.parseFloat(new_products[en_benzerler_dizisi_yeri[i]+1][products[0].length-1]);
        }
    }
    new_products[count_people-1][products[0].length-1]=Integer.toString(Math.round(ortalama/sayac));
    return new_products;
      
}
public static void klavyeden_gelenler(Customer[] all_customer,String[][] products,int count_people) throws IOException
{   System.out.println("\n\n\t-- Klavyeden giriş yapılan müşterilerin bilgileri --\n");
   if(count_people+1<all_customer.length)
   {
    String[][] clone_products = new String[products.length][products[0].length];
    for (int a =0;a <products.length;a++)
        for(int i=0 ; i < products[0].length;i++ )
        {
           clone_products[a][i]=products[a][i];
           if(a<count_people+1 && a>0)
            clone_products[a][i]="0";
        }
    for(int i = count_people;i<all_customer.length-1;i++)
          System.out.println(all_customer[i].tostrings());
    
   klavyeden_eklenenlerin_ortalamalari(clone_products);
   }else
   System.out.println("\n\n -- Klavyeden  Müsteri Girilmemistir --");
   ana_menuye_donme(all_customer,products, count_people);

}
public static void klavyeden_eklenenlerin_ortalamalari(String[][] products)
{
    float[] avarege=new float[products[0].length];
    System.out.println("\n\n  Her bir ürün için o ürüne ait klavyeden girilen ortalama derecelendirme puanını hesaplama ...\n");
    float sayac=0;
    for(int i=0 ; i < products[0].length;i++ )
    {
        for (int a =1;a <products.length;a++)
            if(!products[a][i].equals("0"))
            { 
             ++sayac;
             avarege[i]+= Float.parseFloat(products[a][i]);        
            }
    }
    sayac/=products[0].length;
    for(int i=0 ; i < products[0].length;i++ )
        avarege[i]=avarege[i]/(sayac);
    System.out.println("\n\t\tOrtalamalar");
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.print("\t"+products[0][i]);
    System.out.println();
    System.out.println();
    for(int i=0 ; i < products[0].length;i++ )
        System.out.printf("\t%.2f",avarege[i]); 
}
}
