package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import dataaccess.LibraryMember;

public class MemberController {
	LibraryMember l;
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
	@FXML Label lblSearchStatus;
	
	@FXML void addMemberClick(ActionEvent e) {
		
		l = new LibraryMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
		l.addLibraryMember();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
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
	
	@FXML void btnGobackClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	}
	
	@FXML void btnMemberSearchClick(ActionEvent e) {
		l = new LibraryMember().getMember(txtSearchField.getText());
		if(l == null) {
			lblSearchStatus.setText("Not Found");
			txtMemberId.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtPhone.setText("");
			btnRemoveMember.setDisable(true);
			btnEditMember.setDisable(true);
		}
		else {
			lblSearchStatus.setText("");
			txtMemberId.setText(l.getMemberId());
			txtMemberId.setDisable(true);
			txtFirstName.setText(l.getFirstName());
			txtLastName.setText(l.getLastName());
			txtPhone.setText(l.getPhone());
			btnRemoveMember.setDisable(false);
			btnEditMember.setDisable(false);
		}
	}
	
	@FXML void btnRemoveMemberFormClick(ActionEvent e) {
		l= new LibraryMember();
		l.removeMember(txtMemberId.getText());
		txtMemberId.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	}
	
	@FXML void btnUpdateMemberFormClick(ActionEvent e) {
		l = new LibraryMember();
		l.editMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
	}
	
	@FXML void btnGoBackToManageMemberMenuClick(ActionEvent e) {
		txtMemberId.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	}
	
}
