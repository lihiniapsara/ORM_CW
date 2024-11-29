package org.example.contraller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    public Button btnPayment;
    public Button btnRegistration1;
    public Button backbtn;
    @FXML
    private Button btnCourseManagement;

    @FXML
    private Button btnRegistration;

    @FXML
    private Button btnStudentManagement;

    @FXML
    private Button btnUserManagement;

    @FXML
    void openCourseManagement(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/Programme.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) btnStudentManagement.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Course Page");
    }

    @FXML
    void openRegistration(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/register_course.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) btnStudentManagement.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Registration Page");
    }

    @FXML
    void openStudentManagement(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/Student.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) btnStudentManagement.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Student Page");
    }

    @FXML
    void openUserManagement(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/userManagement.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) btnStudentManagement.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("User Page");
    }

    public void backOnAction(ActionEvent actionEvent) {

    }

    public void openPayment(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/payment.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) btnStudentManagement.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Payment Page");
    }
}
