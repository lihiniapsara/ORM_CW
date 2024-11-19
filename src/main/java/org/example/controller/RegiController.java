package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.IOException;

public class RegiController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public TextField txttel;
    public AnchorPane rootNode;

    UserBOImpl userBO=new UserBOImpl();


    public void btnRegisterOnAction(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String tel = txttel.getText();

        if (username.isEmpty() || password.isEmpty() || tel.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter all fields!").show();
        } else {
            String encriptpw = null;

            try {
                encriptpw = BCrypt.hashpw(password, BCrypt.gensalt());
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Try Again!").show();
                return;
            }
            UserDTO admin = new UserDTO(username, encriptpw, "Admin", tel);

            boolean isSaved = userBO.registeradmin(admin);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Registered!").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        }
    }

    public void clearFields() {
        txtUsername.clear();
        txtPassword.clear();
        txttel.clear();
    }

    public void btnBackOnAction(ActionEvent event) {
        try {
            System.out.println("Attempting to load FXML");
            AnchorPane root = FXMLLoader.load(getClass().getResource("/view/Loginform.fxml"));
            System.out.println("FXML file loaded successfully");

            if (rootNode == null) {
                throw new NullPointerException("rootNode is null");
            }

            Scene scene = new Scene(root);
            Stage stage = (Stage) rootNode.getScene().getWindow();
            if (stage == null) {
                throw new NullPointerException("Stage is null");
            }
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Login Form");
        } catch (IOException e) {
            System.out.println("Failed to load FXML");
            new Alert(Alert.AlertType.ERROR, "Failed to load Login Form.").show();
            e.printStackTrace();
        } catch (NullPointerException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }
}
