package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import business.Book;
import business.LibraryMember;

public class BookController 
{
	@FXML TextField txtISBN;
	@FXML TextField txtTitle;
	@FXML TextField txtcheckoutmaxvalue;
	@FXML Button btnAddBook;
	@FXML Button btnGoBack;
	@FXML Button btnMenuAddBook;
	@FXML Button btnMenuEditBook;
	
	@FXML void addBookClick(ActionEvent e) {		
		Book b = new Book(txtISBN.getText(), txtTitle.getText(), txtcheckoutmaxvalue.getText(),1);
		b.addBook();
		//b.getBookList();
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
	
	@FXML void btnMenuAddBookClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/AddBook.fxml", "Add Book");
	}
	
	@FXML void btnMenuEditBookClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/BookSearch.fxml", "Book Search");
	}
	
	@FXML void btnMenuGoBackClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/Dashboard.fxml", "DashBoard", "");
	}
	
	@FXML void btnGoBackToManageBookMenuClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageBook.fxml", "Manage Book");
	}
	
}
