package dataaccess;

public class Author extends Person{
    private String credentials;
    
   Author(String fname,String lname,String contact,String credentials){
	   super(fname,lname,contact);
	   this.credentials = credentials;
   }
}
