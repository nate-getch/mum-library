package ui;

import business.UserRole;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowController {
	public WindowController() {

	}

	public void openWindow(String uiName, String title, UserRole role) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(uiName));
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			if (uiName == "/ui/Home.fxml") {
				if (role.toString() == "ADMIN") {
					//root.lookup("#btnCheckOutBook").setDisable(true);
				} else if (role.toString() == "LIBRARION") {
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
