package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import dataaccess.LibraryMember;

public class MemberController {
	@FXML TextField txtMemberId;
	@FXML TextField txtFirstName;
	@FXML TextField txtLastName;
	@FXML TextField txtPhone;
	@FXML Button btnAddMember;
	
	@FXML void addMemberClick(ActionEvent e) {
		
		LibraryMember l = new LibraryMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
		l.addLibraryMember();
		l.getMemberList();
	}
}
