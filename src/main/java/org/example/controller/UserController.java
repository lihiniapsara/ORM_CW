package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dto.UserDTO;
import org.example.tm.UserTm;

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

    UserBOImpl userBO=new UserBOImpl();


    public void initialize() {
        loadAllUsers();
    }

    private void loadAllUsers() {
        ObservableList<UserTm> oblist = FXCollections.observableArrayList();
        ArrayList<UserDTO> userlist = userBO.getAll();
        for (UserDTO dto : userlist) {
            oblist.add(new UserTm(dto.getU_id(), dto.getU_name(), dto.getPw(), dto.getJob_role(),dto.getTel()));
        }
        tblUser.setItems(oblist);
    }

    public void btnDashboardOnAction(ActionEvent event) {
    }

    public void btnSaveOnAction(ActionEvent event) {
    }

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
