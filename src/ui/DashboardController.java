package ui;

import business.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DashboardController {
	@FXML Label labelGreetingText;
	@FXML Button btnCheckoutBook;
	@FXML Button btnManageMember;
	@FXML Button btnAddBook;
	
	@FXML void manageMemberBtnClick(ActionEvent e) {
		//User u = new User();
		//System.out.println(User.getRole());
		btnManageMember.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	}
	
	@FXML void addBookBtnClick(ActionEvent e) {
		btnManageMember.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/BookSearch.fxml", "Book Search");

		
		//new WindowController().openWindow("/ui/AddBook.fxml", "Add Book");
	}
}
