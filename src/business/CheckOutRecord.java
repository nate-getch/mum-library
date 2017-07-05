package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;

public class CheckOutRecord implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	BookCopy b = new BookCopy();
	private CheckoutRecordEntry checkoutRecordEntry;
	private String UserId;
	private String ISBN;
	private String copyNumber;
	private LocalDate date;
	private LocalDate dueDate;
	
	public CheckOutRecord() {
		
	}
public CheckOutRecord(String s) {
		
	}
	
	public CheckOutRecord(String UserId,String ISBN, String copyNumber, String checkoutmaxvalue ){
		this.UserId = UserId;
		this.ISBN = ISBN;
		this.copyNumber = copyNumber;
		checkoutRecordEntry = new CheckoutRecordEntry(checkoutmaxvalue);
		this.date = checkoutRecordEntry.getChecoutdate();
		this.dueDate = checkoutRecordEntry.getDuedate();
	}
	
	public void addCheckOutRecord(String txtISBN, String txtMemberId, String bookCopyNum, String checkoutmaxvalue){
		CheckOutRecord c1 = new CheckOutRecord(txtMemberId,txtISBN, bookCopyNum, checkoutmaxvalue);
		List<CheckOutRecord> checkOutRecordList = new ArrayList<>();
		checkOutRecordList.add(c1);
		new ioStream().write(checkOutRecordList, "CheckOutRecord.txt", 1);
	}
	
	public List<CheckOutRecord> getCheckoutRecordList(){
		List<CheckOutRecord> bookList =  new ioStream().read("CheckOutRecord.txt");
		for (CheckOutRecord b : bookList) 
		{			
			//System.out.println(b.ISBN+ " " + b.UserId);
		}
		
		return bookList;
	}
	
	/*
	public static void main(String[] args) {
		CheckOutRecord b = new CheckOutRecord();
		b.getCheckoutRecordList();
	}*/
	
}
