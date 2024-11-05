package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dto.UserDTO;
import org.example.tm.UserTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    public AnchorPane root;
    public TextField txtName;
    public TableView<UserTm> tblUser;
    public TextField txtPassword;
    public TextField txtContact;
    public TableColumn<?,?> colId;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> colpw;
    
    public TableColumn<?,?> colTel;

    public TableColumn<?,?> colJobRole;
    public Label txtuserid;
    public ComboBox cmbjobrole;

    UserBOImpl userBO=new UserBOImpl();


    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllUsers();
        setUserJobRole();
        setCellValueFactory();
/*
        getCurrenteuId();
*/
    }
    private void setUserJobRole() {
        ObservableList<String> JobRole = FXCollections.observableArrayList(
                "Admin",
                "Cordinator"
        );
        cmbjobrole.setItems(JobRole);
    }


    private void loadAllUsers() {
        ObservableList<UserTm> oblist = FXCollections.observableArrayList();
        ArrayList<UserDTO> userlist = userBO.getAll();
        for (UserDTO dto : userlist) {
            oblist.add(new UserTm(dto.getU_id(), dto.getU_name(), dto.getPw(), dto.getJob_role(),dto.getTel()));
        }
        tblUser.setItems(oblist);
    }

    public void btnDashboardOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/resources/view/Dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }


    public void btnSaveOnAction(ActionEvent event) {
        String u_name = txtName.getText();
        String pw = txtPassword.getText();
        String job_role = cmbjobrole.getAccessibleRoleDescription();
        String tel = txtContact.getText();

        boolean isSaved = userBO.save(new UserDTO(u_name, pw, job_role, tel));
        //System.out.println("fghjk");
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "User Saved!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
        }
    }
    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("u_name"));
        colpw.setCellValueFactory(new PropertyValueFactory<>("pw"));
        colJobRole.setCellValueFactory(new PropertyValueFactory<>("job_role"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

  /*  private void getCurrenteuId() throws SQLException, ClassNotFoundException {
        String currentId = userBO.getCurrentId();

        String nextuserId = generateNextUserId(currentId);
        txtuserid.setText(nextuserId);
    }
    private String generateNextUserId(String currentId) {
        if(currentId != null) {
            String[] split = currentId.split("U");
            int idNum = Integer.parseInt(split[1]);
            return "U" + ++idNum;
        }
        return "U1";
    }*/

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnDeleteOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void txtNameOnAction(ActionEvent event) {

    }
    public void nametextKeyReleased(KeyEvent keyEvent) {
    }

    public void passwordtextKeyReleased(KeyEvent keyEvent) {
    }


    public void txtSearchOnAction(ActionEvent event) {
    }

    public void teltextKeyReleased(KeyEvent keyEvent) {
    }

    public void idtextKeyReleased(KeyEvent keyEvent) {
    }
}
