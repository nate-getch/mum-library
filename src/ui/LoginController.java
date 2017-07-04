package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.User;

public class LoginController {
	@FXML private TextField userName;
	@FXML private TextField password;
	
	@FXML void loginBtnClick(ActionEvent e) {
		User u = new User();
		
		User x = u.login(userName.getText(), password.getText());
		if(x.equals(null)) {
			//u.CreateUser();
		}
		else {
			System.out.println(x);
			userName.getScene().getWindow().hide();
			new WindowController().openWindow("/ui/Home.fxml", "DashBoard", x.getRole());
		}
			
	}
}
