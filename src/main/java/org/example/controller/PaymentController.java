package org.example.controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.custom.impl.PaymentBOImpl;
import org.example.bo.custom.impl.ProgramBOImpl;
import org.example.tm.PaymentTm;

import java.io.IOException;
import java.util.List;

public class PaymentController {
    public AnchorPane root;
    public TableView<PaymentTm> tblPayment;
    public TableColumn<?, ?> colpaymentId;
    public TextField txtAmount;
    public TableColumn<?, ?> colPaymentType;
    public TableColumn<?, ?> colamount;
    public Label txtpaymentid;
    public ComboBox cmbprogramid;
    public ComboBox cmbpaymenttype;
    public TableColumn coldate;
    public DatePicker datepicker;


    PaymentBOImpl paymentBO = new PaymentBOImpl();
    ProgramBOImpl programBO = new ProgramBOImpl();

    public void initialize() {
        setCellValueFactory();
        loadAllPayments();
        setProgramId();
        setPaymentType();
    }

    public void loadAllPayments() {
       /* List<PaymentTm> paymentList = paymentBO.findAllPayments();
        ObservableList<PaymentTm> observableList = FXCollections.observableArrayList(paymentList);
        tblPayment.setItems(observableList);*/
    }

    public void setCellValueFactory() {
        colpaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colPaymentType.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        colamount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    public void setProgramId() {
/*
        cmbprogramid.setItems(FXCollections.observableArrayList(paymentBO.findAllProgramIds()));
*/
    }

    public void setPaymentType() {
/*
        cmbpaymenttype.setItems(FXCollections.observableArrayList(paymentBO.findAllPaymentTypes()));
*/
    }

   /* public void setPaymentType() {
        ObservableList<String> paymentmethod = FXCollections.observableArrayList(
                "Cash", "Credit Card", "Debit Card", "Check"
        );
        cmbpaymenttype.setItems(paymentmethod);    }*/

    public void amounttextKeyReleased(KeyEvent keyEvent) {
    }


    public void btnSaveOnAction(ActionEvent event) {
        String id = txtpaymentid.getText();
        String prgram_id = cmbprogramid.getAccessibleHelp();
        String payment_type = cmbpaymenttype.getAccessibleHelp();
        String amount = txtAmount.getText();


        boolean result = paymentBO.savePayment(id, prgram_id, payment_type, amount);

        if (result) {
            new Alert(Alert.AlertType.CONFIRMATION, "Payment Saved!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to Save Payment!").show();
        }
    }


    public void btnUpdateOnAction(ActionEvent event) {
        /*String id = txtpaymentid.getText();
        String amount = txtAmount.getText();
        // ...

        PaymentTm paymentTm = new PaymentTm(id, amount, // ...);
        boolean result = paymentBO.updatePayment(paymentTm);

        if (result) {
            // ...
        } else {
            // ...
        }*/
    }

    public void btnDeleteOnAction(ActionEvent event) {
       /* String id = txtpaymentid.getText();
        boolean result = paymentBO.deletePayment(id);

        if (result) {
            // ...
        } else {
            // ...
        }*/
    }

    public void btnClearOnAction(ActionEvent event) {
        // ...
    }

    public void btnDashboardOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();    }

    public void idtextKeyReleased(KeyEvent keyEvent) {
       /* String id = txtpaymentid.getText();
        PaymentTm paymentTm = paymentBO.searchPayment(id);

        if (paymentTm != null) {
            // ...
        } else {
            // ...
        }*/
    }


    public void updatepayment(MouseEvent mouseEvent) {
    }
}