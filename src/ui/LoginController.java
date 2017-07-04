package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import business.User;

public class LoginController {
	@FXML private TextField userName;
	@FXML private TextField password;
	@FXML private Label loginStatus;
	
	@FXML void loginBtnClick(ActionEvent e) {
		User u = new User();
		
		u = u.login(userName.getText(), password.getText());
		if(u.equals(null)) {
			loginStatus.setText("Invalid Login info");
		}
		else {
			System.out.println(u);
			userName.getScene().getWindow().hide();
			new WindowController().openWindow("/ui/Dashboard.fxml", "DashBoard", u);
		}
			
	}
}
