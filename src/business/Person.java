package business;

public class Person {
	private String fname;
	private String lname;
	private String phone;
	private String street;
	private String city;
	private String state;
	private String zip;

	public Person() {
		
	}
	
	public Person(String fname, String lname, String phone) {
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhone() {
		return phone;
	}
	
	public String toString() {
		return "First Name: "+ fname + " , Last Name: " + lname;
	}
	
}
