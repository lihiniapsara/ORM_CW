package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.custom.UserBO;
import org.example.bo.custom.impl.UserBOImpl;
import org.example.dao.custom.UserDAO;
import org.example.dao.custom.impl.UserDAOImpl;
import org.example.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

public class LoginformController {
    public TextField txtId;
    public TextField txtPw;
    public AnchorPane rootNode;
    UserBOImpl userBO=new UserBOImpl();
    UserDAOImpl userDAO=new UserDAOImpl();
    static  UserDTO liveUserDto;

    public void idtextKeyReleased(KeyEvent keyEvent) {
    }

    public void btnLoginOnAction(ActionEvent event) throws IOException {
        String name = txtId.getText();
        String pw = txtPw.getText();

        if (name.isEmpty() || pw.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter both ID and Password!").show();
        } else {
            UserDTO userDTO = userBO.getdata(name);
            if (userDTO == null) {
                new Alert(Alert.AlertType.ERROR, "User not found!").show();
            } else {
                if (BCrypt.checkpw(pw, userDTO.getPw())) {
                    if (userDTO.getJob_role().equals("Admin")) {
                        System.out.println("Admin");
                        liveUserDto=userDTO;


                    }else {
                        liveUserDto=userDTO;
                        System.out.println("User");
                    }
                    navigateDashboard();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Password is incorrect!").show();
                }
            }
        }
    }

    private void navigateDashboard() throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");

    }

    public void linkRegistrationOnAction(ActionEvent event) throws IOException {
        if (userDAO.ifhaveadmin()) {
            new Alert(Alert.AlertType.ERROR, "Admin already exists!").show();
        }else {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/view/reg.fxml"));

            Scene scene = new Scene(root);

            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Registration Form");
        }

    }

    static UserDTO getLiveUserDto() {
        return liveUserDto;
    }
}
