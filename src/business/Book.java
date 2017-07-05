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
	
	public Book()
	{
		
	}
	
	public Book(String txtISBN, String txtTitle, String txtcheckoutmaxvalue)
	{
		this.ISBN = txtISBN;
		this.title = txtTitle;
		this.checkoutmaxvalue = txtcheckoutmaxvalue;
	}
	
	public void addBook () {
		List<Book> x = new ArrayList <Book> ();
		x.add(this);
		new ioStream().write(x, "Book.txt",1);
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
	
	public String toString() {
		return "Book ID:" + ISBN;
	}
}
