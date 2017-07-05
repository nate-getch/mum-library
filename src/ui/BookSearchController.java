package ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import business.Book;
import business.BookCopy;
import business.LibraryMember;

public class BookSearchController
{
	@FXML TextField txtISBN;
	@FXML TextField txtTitle;
	@FXML TextField txtcheckoutmaxvalue;
	@FXML TextField txtNoofCopies;
	@FXML Button btnAddBook;
	@FXML Button btnGoBack;
	@FXML Button btnMenuAddBook;
	@FXML Button btnMenuEditBook;
	@FXML Label lblSearchStatus;
	@FXML Alert alert;
	@FXML TextField txtISBN1;
	@FXML TextField txtcopyNumber;
	private boolean isCopy = false;
	@FXML Label lblAddFormStatus;
	@FXML RadioButton twentyOneDays;
	@FXML RadioButton sevenDays;
	@FXML ToggleGroup maxdaysbtn;

	
	@FXML void addBookClick(ActionEvent e) throws InvocationTargetException 
	{	
		try
		{
		Book b;
		if(isCopy){
			new BookCopy(txtcopyNumber.getText(), txtISBN.getText(), false ).addBookCopy();
		}
		else {	
			sevenDays.setUserData("7");
			twentyOneDays.setUserData("21");
			b = new Book(txtISBN.getText(), txtTitle.getText(), maxdaysbtn.getSelectedToggle().getUserData().toString(), Integer.parseInt(txtNoofCopies.getText()));		
			b.addBook();
			lblAddFormStatus.setText("Book Added Successfully");
		}
		}catch(Exception e1){ e1.printStackTrace(); }
	}
	
	@FXML void btnBookSearchClick(ActionEvent e) throws InvocationTargetException 
	{
		try
		{
			if(txtISBN.getText().isEmpty())
			{
				lblSearchStatus.setTextFill(Color.RED);
				lblSearchStatus.setText("Please enter an ISBN");
			}
			else
			{
				lblSearchStatus.setText("");
				Book b = new Book().getBook(txtISBN.getText());
				if(b == null) 
				{
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Book Not Found in the Library !");
					alert.setContentText("Continue to add it as a new book ?");
					
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK)
					{
						lblSearchStatus.getScene().getWindow().hide();
						new WindowController().openWindow("/ui/AddBook.fxml", "Add Book");
					}
				}
				else
				{
					txtISBN1.setText(b.getISBN());
					txtISBN1.setDisable(true);
					txtTitle.setText(b.getTitle());
					txtTitle.setDisable(true);
					//txtcheckoutmaxvalue.setText(b.getCheckoutmaxvalue());
					//txtcheckoutmaxvalue.setDisable(true);
					txtNoofCopies.setText(Integer.toString(b.getNoOfCopies()));
					txtNoofCopies.setDisable(true);
					
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Book with this ISBN found in the Library");
					alert.setContentText("Do you want to add a copy of this book ?");

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK)
					{						
						isCopy = true;						
						//lblSearchStatus.getScene().getWindow().hide();
						//new WindowController().openWindow("/ui/AddBookCopy.fxml", "Add Book Copy");					    
					}				
				}
				//txtISBN.getScene().getWindow().hide();
				//new WindowController().openWindow("/ui/MemberEdit.fxml", "Edit Member");
			}			
		}catch(Exception e1){ e1.printStackTrace(); }

	}
	
	/*@FXML void displayBookInfo(Book b)  throws InvocationTargetException 
	{
		try
		{
		lblSearchStatus.getScene().getWindow().hide();
		
		/*FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
        Parent root = loader.load();
        BookController book = loader.getController();
        book.txtTitle.setText(b.getTitle());
        txtTitle.getScene().setRoot(root);
		FXMLLoader loader = new FXMLLoader();
		Parent root;
		Stage dialogue = new Stage();
		root = (Parent) loader.load(getClass().getResource("/ui/AddBook.fxml").openStream());
		BookController dc = loader.getController();
		dc.txtTitle.setText(b.getTitle());
		//dc.setTextArea("text");
		dialogue.show();
		
		
		txtISBN.setText(b.getISBN());
		//BookController b1 = (BookController)FxmlLoader.getController();

		//new WindowController().openWindow("/ui/AddBook.fxml", "Book Information");
		txtTitle.setText(b.getTitle());
		System.out.println(txtTitle.getText());

		//new WindowController().openWindow("/ui/AddBookCopy.fxml", "Book Information");
		new WindowController().openWindow("/ui/AddBook.fxml", "Book Information");
		}catch(Exception e1){ e1.printStackTrace(); }
	}*/
	
	
	@FXML void btnMenuAddBookClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/BookSearch.fxml", "Book Search");

		//new WindowController().openWindow("/ui/AddBook.fxml", "Add Book");
	}
	
	@FXML void btnMenuEditBookClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/BookSearch.fxml", "Book Search");
	}
	
	@FXML void btnMenuGoBackClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/Dashboard.fxml", "DashBoard", "");
	}
	
}
