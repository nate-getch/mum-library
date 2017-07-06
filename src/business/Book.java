package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Book implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String ISBN;
	private String title;
	private String checkoutmaxvalue;
	private List<BookCopy> bookCopyList;
	private List<Author> authors;
	private BookCopy bookCopy;
	private int noOfCopies;
	
	public Book()
	{
		
	}
	
	public Book(String txtISBN, String txtTitle, String txtcheckoutmaxvalue, int noOfCopies)
	{
		this.ISBN = txtISBN;
		this.title = txtTitle;
		this.noOfCopies = noOfCopies;
		this.checkoutmaxvalue = txtcheckoutmaxvalue;
		bookCopyList = new ArrayList<BookCopy>();
	}
	
	public void addBook () {
		List<Book> x = new ArrayList <Book> ();
		x.add(this);
		if(getBook(this.ISBN) == null) {
			new ioStream().write(x, "Book.txt",1);
			// every book added has at least one copy
			for (int i=1; i<=noOfCopies; i++) {
				bookCopy = new BookCopy(Integer.toString(i), this.getISBN(), false);
				bookCopyList.add(bookCopy);
			}
			new BookCopy().addBookCopyList(bookCopyList);
		}
	}
	
	public List<Book> getBookList(){
		List<Book> bookList =  new ioStream().read("Book.txt");
		for (Book b : bookList) 
		{			
			System.out.println(b);
		}
		
		return bookList;
	}
	
	public Book getBook(String bookISBN)
	{
		List<Book> bookList =  new ioStream().read("Book.txt");
		for (Book b : bookList) {
		System.out.println(b);
				if(b.ISBN.equals(bookISBN))
					return b;
			}
		return null;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getCheckoutmaxvalue() {
		return checkoutmaxvalue;
	}
	
	public int getNoOfCopies(String ISBN)
	{
		bookCopy = new BookCopy();
		return bookCopy.getNoOfCopies(ISBN);
	}
	
	public String toString() {
		return "Book ID:" + ISBN + " , Book Title: "+title + " , Book Check Out Value : "+
				checkoutmaxvalue + " , No Of Copies : "+getNoOfCopies(ISBN);
	}
	
	public static void main(String[] args) {
		Book b = new Book();
		b.getBookList();
	}

	public List<Author> getAuthor() {
		return authors;
	}	
	
}
