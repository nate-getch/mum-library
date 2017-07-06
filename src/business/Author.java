package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dataaccess.ioStream;

public class Author extends Person implements Serializable {
	private static final long serialVersionUID = 8309080721495266420L;
	private String authorCredential;
	private String txtISBN;
	private String authorFirstName;
	private String authorLastName;
	private String authorPhone;
	private List<Book> books;
	
	public Author() {}

	public Author(String authorFirstName, String authorLastName, String authorPhone, String authorCredential,String txtISBN){
		super(authorFirstName, authorLastName, authorPhone);
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.authorPhone = authorPhone;
		this.authorCredential = authorCredential;
		this.txtISBN = txtISBN;
		}

	public void addAuthor() {
		List<Author> x = new ArrayList<Author>();
		x.add(this);
		new ioStream().write(x, "Author.txt", 1);
	}
	
	public String getBookAuthors(String ISBN){
		List<Author> ll =  new ioStream().read("Author.txt");

		String x = "Authors List\n";
		for (Author l : ll) {	
				if(l.txtISBN.equals(ISBN))
					x += "- "+l.authorFirstName+" "+l.authorLastName+"\n";
			}
		
		return x;
	}
	
	public List<Book> getAuthorBooks(String ISBN){
		books =  new ioStream().read("Book.txt");
		List<Book> booklist = new ArrayList<Book>();
		for (Book b : books) {	
				if(b.getISBN().equals(ISBN))
					booklist.add(b);
					//System.out.println(b.getTitle());
			}
		
		return booklist;
	}
	
	/*
	public static void main(String[] args) {
		Author o = new Author();
		//System.out.println(o.getBookAuthors("001"));
		//o.getAuthorBooks("001");
	} */

}
