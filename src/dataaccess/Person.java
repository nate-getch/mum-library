package dataaccess;

public class Person {
  private String fname;
  private String lname;
  private String contact;
  private String street;
  private String city;
  private String state;
  private String zip;	
	
  
  Person(String fname,String lname,String contact,String street,String city,
		 String state,String zip){
	  this.fname = fname;
	  this.lname = lname;
	  this.contact = contact;
	  this.street  = street;
	  this.city = city;
	  this.state = state;
	  this.zip = zip;
  }
}


