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
	@FXML Button btnAddMemberMenu;
	@FXML Button btnEditMemberMenu;
	@FXML Button btnGoback;
	@FXML Button btnEditMember;
	@FXML Button btnRemoveMember;
	@FXML TextField txtSearchField;
	@FXML Button btnSearchSubmit;
	
	@FXML void addMemberClick(ActionEvent e) {
		
		LibraryMember l = new LibraryMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
		l.addLibraryMember();
		//l.getMemberList();
	}
	
	@FXML void btnAddMemberMenuClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/AddMember.fxml", "Add Member");
	}
	
	@FXML void btnEditMemberMenuClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/MemberSearch.fxml", "Search Member");
	}
	
	@FXML void btnRemoveMemberClick(ActionEvent e) {
		
	}
	
	@FXML void btnGobackClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	}
	
	@FXML void btnMemberSearchClick(ActionEvent e) {
		LibraryMember l = new LibraryMember().getMember(txtSearchField.getText());
		if(l == null) {
			System.out.println("Not FOund");
		}
		else {
			txtSearchField.getScene().getWindow().hide();
			new WindowController().openWindow("/ui/MemberEdit.fxml", "Edit Member");
		}
	}
	
}
