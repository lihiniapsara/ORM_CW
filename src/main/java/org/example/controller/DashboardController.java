package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {
    public AnchorPane ancorpane;
    public AnchorPane root;

    public void btnLogOutOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginform.fxml"));
        Parent rootNode = loader.load();
        ancorpane.getChildren().clear();
        ancorpane.getChildren().add(rootNode);
    }

    public void loadStudentPageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/student.fxml"));
        Parent rootNode = loader.load();
        ancorpane.getChildren().clear();
        ancorpane.getChildren().add(rootNode);
    }

    public void loadProgramePageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/program.fxml"));
        Parent rootNode = loader.load();
        ancorpane.getChildren().clear();
        ancorpane.getChildren().add(rootNode);
    }

    public void loadPayementPageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/payment.fxml"));
        Parent rootNode = loader.load();
        ancorpane.getChildren().clear();
        ancorpane.getChildren().add(rootNode);
    }

    public void loadUserPageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user.fxml"));
        Parent rootNode = loader.load();
        ancorpane.getChildren().clear();
        ancorpane.getChildren().add(rootNode);
    }

}
