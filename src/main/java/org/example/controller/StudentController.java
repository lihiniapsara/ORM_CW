package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.example.bo.custom.impl.StudentBOImpl;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dto.StudentDTO;
import org.example.dto.UserDTO;
import org.example.tm.StudentTm;
import org.example.tm.UserTm;

import java.util.ArrayList;

public class StudentController {
    public AnchorPane root;
    public TextField txtAddress;
    public TextField txtEmail;
    public TableView<StudentTm> tblStudent;
    public TextField txtContact;
    public TableColumn<?,?> colId;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> coladdress;
    public TableColumn<?,?> colEmail;
    public TableColumn<?,?> colTel;

    public TextField txtName;
    public Label lblStudentId;
    StudentBOImpl studentBO=new StudentBOImpl();
    public void initialize() {
        setCellValueFactory();
        loadAllStudents();
    }


    public void teltextKeyReleased(KeyEvent keyEvent) {
    }
    public void nametextKeyReleased(KeyEvent keyEvent) {
    }

    public void emailtextKeyReleased(KeyEvent keyEvent) {
    }

    public void txtSearchOnAction(ActionEvent event) {
    }

    public void addressKeyReleased(KeyEvent keyEvent) {
    }


    public void idtextKeyReleased(KeyEvent keyEvent) {
    }

    public void btnDashboardOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        String tel = txtContact.getText(); // Assuming txtContact is a TextField

        // Perform the deletion operation
        try {
            boolean isDeleted = studentBO.delete(tel);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "No record found to delete!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
            e.printStackTrace(); // Log the exception for debugging
        }

        clearFields();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        long id = Long.parseLong(lblStudentId.getText());
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();

        try {
            boolean isUpdated = studentBO.update(new StudentDTO(id, name, address, email, contact));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "No record found to update!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
            e.printStackTrace(); // Log the exception for debugging
        }

        clearFields();

    }

    public void btnSaveOnAction(ActionEvent event) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();

        // Debugging: Print values to ensure they're not null
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Contact: " + contact);

        StudentDTO studentDTO = new StudentDTO(name, address, email, contact);
        boolean isSaved = studentBO.save(studentDTO);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
        }
        loadAllStudents();
        clearFields();
    }
    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("s_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("s_name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllStudents() {
        ObservableList<StudentTm> oblist = FXCollections.observableArrayList();
        ArrayList<StudentDTO> studentlist = studentBO.getAll();
        for (StudentDTO dto : studentlist) {
            oblist.add(new StudentTm(dto.getS_id(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getContact()));
        }
        tblStudent.setItems(oblist);
    }

    private void clearFields() {
        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtContact.clear();
    }

}
