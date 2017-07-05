package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.Book;
import business.LibraryMember;

public class CheckoutController {
	LibraryMember l;
	Book b;
	@FXML TextField txtMemberId;
	@FXML TextField txtISBN;
	@FXML Button btncheckout;
	@FXML Label lblcheckoutStatus;
	
	@FXML void checkoutBtnClick(ActionEvent e) {
		lblcheckoutStatus.setText("");
		l = new LibraryMember().getMember(txtMemberId.getText());
		if(l==null) lblcheckoutStatus.setText("Person with ID: " + txtMemberId.getText() + " is not a valid member.");
		if(lblcheckoutStatus.getText()=="") {
		b = new Book().getBook(txtISBN.getText());
		if(b==null) lblcheckoutStatus.setText("Book with ISBN: " + txtISBN.getText() + " is not present in library.");
		}
		if(l!=null && b!=null && lblcheckoutStatus.getText()=="") {
		   	
		}
		
	}
}
