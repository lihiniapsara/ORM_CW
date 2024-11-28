package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("resources/view/LoginForm.fxml"))));
       // FXMLLoader.load(this.getClass().getResource("/view/dashboard.fxml"))

/*
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/customer.fxml"))));
*/

/*
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/item.fxml"))));
*/

        stage.setTitle("Login Form");
        stage.centerOnScreen();
        stage.show();
    }
}
