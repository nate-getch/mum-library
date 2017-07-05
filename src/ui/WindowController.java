package ui;

import business.LibraryMember;
import business.User;
import business.UserRole;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowController {
	public WindowController() {

	}
	
	public void openWindow(String uiPage, String title) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(uiPage));
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setResizable(false);
			stage.setScene(new Scene(root));

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void openWindow(String uiPage, String title, String role) {
		try {
			role = User.urole;
			Parent root = FXMLLoader.load(getClass().getResource(uiPage));
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			if (uiPage == "/ui/Dashboard.fxml") {
				if (role.equals("ADMIN")) {
					root.lookup("#btnCheckoutBook").setDisable(true);					
				} else if (role.equals("LIBRARIAN")) {
					root.lookup("#btnManageMember").setDisable(true);
					root.lookup("#btnAddBook").setDisable(true);
				}
				else if (role.equals("BOTH")) {
				
				}
			}

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
