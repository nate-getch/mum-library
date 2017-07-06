package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;

public class LibraryMember extends Person implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private String street;
	private String city;
	private String state;
	private String zip;
	private CheckOutRecord checkutRecord;
		
	public LibraryMember() {
		
	}
	
	public LibraryMember(String txtMemberId,String txtFirstName,String txtLastName, String txtPhone,
			             String street,String city,String state,String zip){
		super(txtFirstName, txtLastName, txtPhone);
		this.memberId = txtMemberId;
		this.firstName = txtFirstName;
		this.lastName = txtLastName;
		this.phone = txtPhone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public void addLibraryMember(  ) {
		List<LibraryMember> x = new ArrayList <LibraryMember> ();
		x.add(this);
		if(getMember(this.memberId) == null)
			new ioStream().write(x, "LibraryMember.txt",1);
		else
			System.out.println("Member ID already exists");
	}
	
	public List<LibraryMember> getMemberList(){
		List<LibraryMember> ll =  new ioStream().read("LibraryMember.txt");
		for (LibraryMember l : ll) {			
				System.out.println(l);
			}
		
		return ll;
	}
	
	public LibraryMember getMember(String mid){
		//getMemberList();
		List<LibraryMember> ll =  new ioStream().read("LibraryMember.txt");
		for (LibraryMember l : ll) {			
				if(l.memberId.equals(mid)) {
					return l;
				}	
			}
		return null;
	}
	
	public void removeMember(String mid){
		List<LibraryMember> ll =  new ioStream().read("LibraryMember.txt");
		List<LibraryMember> list = new ArrayList<LibraryMember>(); ;
		for (LibraryMember l : ll) {
				if(!l.memberId.equals(mid))
					list.add(l);
			}
		new ioStream().write(list, "LibraryMember.txt", 0); 
	}
	
	public void editMember(String txtMemberId,String txtFirstName,String txtLastName, String txtPhone,
			               String street,String city,String state,String zip ) {
		removeMember(txtMemberId);
		new LibraryMember(txtMemberId,txtFirstName,txtLastName, txtPhone,street,city,state,zip).addLibraryMember();
	}
	
	public String toString() {
		return "Member ID:" + memberId;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	
	/*
	public static void main(String[] args) {
		LibraryMember b = new LibraryMember();
		b.getMemberList();
	}*/
	
}
