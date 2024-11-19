package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.custom.impl.StudentBOImpl;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dto.StudentDTO;
import org.example.dto.UserDTO;
import org.example.tm.StudentTm;
import org.example.tm.UserTm;

import java.io.IOException;
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
    public JFXButton btnclear;
    public JFXButton btndelete;
    public JFXButton btnupdate;
    public JFXButton btnsave;
    StudentBOImpl studentBO=new StudentBOImpl();
    UserBOImpl userBO=new UserBOImpl();

    static UserDTO liveUserDto;
    public void initialize() {
        liveUserDto = LoginformController.getLiveUserDto();
        setCellValueFactory();
        loadAllStudents();
        checkroll(liveUserDto);
    }

    /*public void setLiveUserDto(UserDTO userDto) {
        liveUserDto = userDto;
        if (liveUserDto == null) {
            System.out.println("UserDTO is not initialized correctly.");
        } else {
            System.out.println("UserDTO initialized: " + liveUserDto.getU_name());
            checkroll(); // Call checkroll after setting liveUserDto }
        }
    }*/
     /*private void checkroll() {
            if (liveUserDto != null && "user".equals(liveUserDto.getJob_role())) {
                btnsave.setVisible(true);
                btndelete.setVisible(false);
                btnupdate.setVisible(true);
                btnclear.setVisible(true); }
     }*/


    private void checkroll(UserDTO liveUserDto) {
        if (liveUserDto.getJob_role().equals("user")) {
            btnsave.setVisible(true);
            btndelete.setVisible(false);
            btnupdate.setVisible(true);
            btnclear.setVisible(true);

        }
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

    public void btnDashboardOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
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
                loadAllStudents();
            } else {
                new Alert(Alert.AlertType.WARNING, "No record found to delete!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
            e.printStackTrace(); // Log the exception for debugging
        }
        loadAllStudents();
        clearFields();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();

        try {
            boolean isUpdated = studentBO.update(new StudentDTO( name, address, email, contact));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
                loadAllStudents();  
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "No record found to update!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
            e.printStackTrace(); // Log the exception for debugging
        }
        

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

        // Debugging userDTO
        if (liveUserDto == null) {
            System.out.println("userDTO is null!");
        } else {
            System.out.println("userDTO: " + liveUserDto);
        }

        // Check if liveUserDto is properly set
        StudentDTO studentDTO = new StudentDTO(name, address, email, contact);
        boolean isSaved = studentBO.save(studentDTO, liveUserDto);  // liveUserDto should not be null

        if (isSaved) {
            loadAllStudents();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save student!").show();
        }
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

    public void updatestudent(MouseEvent mouseEvent) {
        TableView<StudentTm> table = (TableView<StudentTm>) mouseEvent.getSource();
        StudentTm student = table.getSelectionModel().getSelectedItem(); // Get the selected student
        if (student != null) {  
            String name = student.getS_name();
            String address = student.getAddress();
            String email = student.getEmail();
            String contact = student.getTel();
            
            txtName.setText(name);
            txtAddress.setText(address);
            txtEmail.setText(email);
            txtContact.setText(contact);
        }
    }
}
