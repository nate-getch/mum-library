package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;

public class BookCopy implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String UniqueCopynum;
	private Book book;
	private String ISBN;
	private boolean isCheckedOut;

	public BookCopy() {
	}

	public BookCopy(String UniqueCopynum, String ISBN, boolean isCheckedOut) 
	{
		this.UniqueCopynum = UniqueCopynum;
		this.ISBN = ISBN;
		this.isCheckedOut = isCheckedOut;
	}
	
	/*
	public void generateBookCopy() {
		List<Book> bb = book.getBookList();
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		for (Book b : bb) {
			BookCopy b1 = new BookCopy("1", b.getISBN(), false);
			bookCopyList.add(b1);
		}

		new ioStream().write(bookCopyList, "BookCopy.txt", 1);
	}*/
	
	public void addBookCopy() {
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		bookCopyList.add(this);
		new ioStream().write(bookCopyList, "BookCopy.txt", 1);
	}
	
	public void addBookCopyList(List<BookCopy> b) {
		//List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		//bookCopyList.add(b);
		new ioStream().write(b, "BookCopy.txt", 1);
	}


	public BookCopy getBookCopy(String bookISBN) {
		List<BookCopy> bookCopyList = new ioStream().read("BookCopy.txt");
		for (BookCopy b : bookCopyList) {
			//System.out.println(b);
			if (b.ISBN.equals(bookISBN) && b.isCheckedOut == false )
				return b;
		}
		return null;
	}
	
	public void removeBookCopy(String bid, String UniqueCopynum){
		List<BookCopy> ll =  new ioStream().read("BookCopy.txt");
		List<BookCopy> list = new ArrayList<BookCopy>();
		for (BookCopy l : ll) {
				if(l.ISBN.equals(bid) && l.UniqueCopynum.equals(UniqueCopynum))
				{
					System.out.println(bid + " -> " + UniqueCopynum);
				}	
				else {
					list.add(l);
				}
			}
		new ioStream().write(list, "BookCopy.txt", 0);
	}
	
	public void editBookCopy(String UniqueCopynum, String ISBN) {
		removeBookCopy(ISBN,UniqueCopynum);
		new BookCopy(UniqueCopynum,ISBN, true).addBookCopy();
	}

	public String getUniqueCopynum() {
		return UniqueCopynum;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	
	public List<BookCopy> getBookCopyRecordList(){
		List<BookCopy> bookList =  new ioStream().read("BookCopy.txt");
		for (BookCopy b : bookList) 
		{			
			System.out.println(b.ISBN+ " " + b.isCheckedOut + " ID "+ b.UniqueCopynum);
		}
		
		return bookList;
	}
	
	public int getNoOfCopies(String bookId)
	{
		int c = 0;
		List<BookCopy> bookList =  new ioStream().read("BookCopy.txt");
		for (BookCopy b : bookList) 
		{	
			if(bookId.equals(b.ISBN))
				c++;
		}
		//System.out.println(c);
		return c;
	}
	
	/*
	public static void main(String[] args) {
		BookCopy b = new BookCopy();
		//b.generateBookCopy();
		b.getBookCopyRecordList();
		//b.getNoOfCopies("001");
		//b.removeBookCopy("002");
		//b.getBookCopyRecordList();
	} */

}
