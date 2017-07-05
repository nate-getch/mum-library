package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;

public class LibraryMember implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	
	public LibraryMember() {
		
	}
	
	public LibraryMember(String txtMemberId,String txtFirstName,String txtLastName, String txtPhone){
		this.memberId = txtMemberId;
		this.firstName = txtFirstName;
		this.lastName = txtLastName;
		this.phone = txtPhone;
	}
	
	public void addLibraryMember(  ) {
		List<LibraryMember> x = new ArrayList <LibraryMember> ();
		x.add(this);
		new ioStream().write(x, "LibraryMember.txt",1);
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
	
	public void editMember(String txtMemberId,String txtFirstName,String txtLastName, String txtPhone) {
		removeMember(txtMemberId);
		new LibraryMember(txtMemberId,txtFirstName,txtLastName, txtPhone).addLibraryMember();
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
	
}
