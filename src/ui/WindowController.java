package ui;

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

	public void openWindow(String uiPage, String title, User u) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(uiPage));
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			if (uiPage == "/ui/Dashboard.fxml") {
				if (u.getRole().toString() == "ADMIN") {
					root.lookup("#btnCheckoutBook").setDisable(true);
					//root.lookup("#greetingText").setVisible(false);
					
				} else if (u.getRole().toString() == "LIBRARION") {
					//root.lookup("#btnAddMember").setDisable(true);
					//root.lookup("#btnEditMember").setDisable(true);
					//root.lookup("#btnAddBook").setDisable(true);
					//root.lookup("#btnAddBookCopy").setDisable(true);
				}
			}

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
