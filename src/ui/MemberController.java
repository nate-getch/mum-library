package ui;

import business.LibraryMember;
import business.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MemberController {
	LibraryMember l;
	@FXML TextField txtMemberId;
	@FXML TextField txtFirstName;
	@FXML TextField txtLastName;
	@FXML TextField txtPhone;
	@FXML TextField txtstreet;
	@FXML TextField txtcity;
	@FXML TextField txtstate;
	@FXML TextField txtzip;	
	@FXML Button btnAddMember;
	@FXML Button btnAddMemberMenu;
	@FXML Button btnEditMemberMenu;
	@FXML Button btnGoBack;
	@FXML Button btnEditMember;
	@FXML Button btnRemoveMember;
	@FXML TextField txtSearchField;
	@FXML Button btnSearchSubmit;
	@FXML Label lblSearchStatus;
	
	@FXML void addMemberClick(ActionEvent e) {
		
		l = new LibraryMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(),
				              txtstreet.getText(), txtcity.getText(), txtstate.getText(), txtzip.getText());
		l.addLibraryMember();
		btnAddMember.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
	//	l.getMemberList();
	}
	
	@FXML void btnAddMemberMenuClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/AddMember.fxml", "Add Member");
	}
	
	@FXML void btnEditMemberMenuClick(ActionEvent e) {
		btnAddMemberMenu.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/MemberSearch.fxml", "Search Member");
	}
	
	@FXML void btnGoBackClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/Dashboard.fxml", "DashBoard", "");
	}
	
	@FXML void btnMemberSearchClick(ActionEvent e) {
		l = new LibraryMember().getMember(txtSearchField.getText());
		if(l == null) {
			lblSearchStatus.setText("Not Found");
			txtMemberId.setText("");
			txtFirstName.setText("");
			txtLastName.setText("");
			txtPhone.setText("");
			txtstreet.setText("");
			txtcity.setText("");
			txtstate.setText("");
			txtzip.setText("");
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
			txtstreet.setText(l.getStreet());
			txtcity.setText(l.getCity());
			txtstate.setText(l.getState());
			txtzip.setText(l.getZip());
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
		l.editMember(txtMemberId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(), 
				     txtstreet.getText(), txtcity.getText(), txtstate.getText(), txtzip.getText());
		lblSearchStatus.setText("Updated");
		txtMemberId.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
		
	}
	
	@FXML void btnGoBackToManageMemberMenuClick(ActionEvent e) {
		btnGoBack.getScene().getWindow().hide();
		new WindowController().openWindow("/ui/ManageMemberMenu.fxml", "Manage Member");
		
	}
	
}
