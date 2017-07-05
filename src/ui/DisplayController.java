package ui;

import javafx.collections.FXCollections;

//import org.apache.http.NameValuePair

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.CheckOutRecord;
import business.*;

public class DisplayController implements Initializable {
    
	@FXML
	private TableView<CheckOutRecord> checkout;
	@FXML
	private TableColumn<CheckOutRecord, String> UserId;
	@FXML
	private TableColumn<CheckOutRecord, String> ISBN;
	@FXML
	private TableColumn<CheckOutRecord, String> copyNumber;
	@FXML
	private TableColumn<CheckOutRecord, LocalDate> date;
	@FXML
	private TableColumn<CheckOutRecord, LocalDate> dueDate;

	@FXML
	private ObservableList<CheckOutRecord> checkoutList;
	
	private CheckOutRecord cr = new CheckOutRecord();
	private List<CheckOutRecord> records ;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
   
		UserId.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, String>("UserId"));
		ISBN.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, String>("ISBN"));
		copyNumber.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, String>("copyNumber"));
		date.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, LocalDate>("date"));
		dueDate.setCellValueFactory(new PropertyValueFactory<CheckOutRecord, LocalDate>("dueDate"));
		
		records =  cr.getCheckoutRecordList();
		checkoutList = FXCollections.observableArrayList(records);	
		checkout.getItems().setAll(checkoutList);


}
}
