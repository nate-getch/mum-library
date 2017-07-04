package ui;

import dataaccess.LibraryMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import dataaccess.Book;

public class BookController 
{
	@FXML TextField txtISBN;
	@FXML TextField txtTitle;
	@FXML TextField txtcheckoutmaxvalue;
	@FXML Button btnAddBook;
	
	@FXML void addBookClick(ActionEvent e) {		
		Book b = new Book(txtISBN.getText(), txtTitle.getText(), txtcheckoutmaxvalue.getText());
		b.addBook();
		b.getBookList();
	}
	
	@FXML void btnBookSearchClick(ActionEvent e) {
		Book b = new Book().getBook(txtISBN.getText());
		if(b == null) {
			System.out.println("Not Found");
			//b.getBookList();
		}
		else {
			System.out.println("Found");
			//txtISBN.getScene().getWindow().hide();
			//new WindowController().openWindow("/ui/MemberEdit.fxml", "Edit Member");
		}
	}
}
