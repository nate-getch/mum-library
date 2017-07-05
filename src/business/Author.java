package business;

public class Author extends Person{
    private String credentials;
    
   Author(String fname,String lname,String contact,String street,String city,String state,String zip){
	   super(fname,lname,contact,street,city,state,zip);
	   this.credentials = credentials;
   }
}
