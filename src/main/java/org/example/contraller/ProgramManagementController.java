package org.example.contraller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BoFactory;
import org.example.bo.custom.ProgramBo;
import org.example.dto.ProgramDto;
import org.example.entity.Programme;

import java.io.IOException;

public class ProgramManagementController {

    ProgramBo programBo = (ProgramBo) BoFactory.getBoFactory().getBO(BoFactory.BOTypes.PROGRAM);

    @FXML
    private Button btnAddProgram;

    @FXML
    private Button btnDeleteProgram;

    @FXML
    private Button btnSearchProgram;

    @FXML
    private Button btnUpdateProgram;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colProgramID;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private TableView<ProgramDto> tblPrograms;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtProgramID;

    @FXML
    private TextField txtProgramName;


    public void initialize() {
        setcellvaluefactory();
        getallProgram();
    }
    private void clearFields() {
        txtProgramID.clear();
        txtProgramName.clear();
        txtDuration.clear();
        txtFee.clear();
    }

    private void setcellvaluefactory() {
        colProgramID.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fees"));

    }

    private void getallProgram() {
        ObservableList<ProgramDto> programmes = programBo.getAllProgram();


        tblPrograms.setItems(programmes);
    }



    @FXML
    void addProgram(ActionEvent event) {
        String programId = txtProgramID.getText();
        String programName = txtProgramName.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        if (programId.isEmpty() || programName.isEmpty() || duration.isEmpty() || fee <= 0) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
        }else {
            Programme programme = new Programme(programId, programName, duration, fee);
            boolean result = programBo.addProgram(programme);
            if (result) {
                getallProgram();
                new Alert(Alert.AlertType.CONFIRMATION, "Add Successful").show();
            }
        }
    clearFields();
    }

    @FXML
    void deleteProgram(ActionEvent event) {
        String programId = txtProgramID.getText();
        if (programId.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
        }else{
            boolean result = programBo.deleteProgram(programId);
            getallProgram();
            if (result) {
                getallProgram();
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Successful").show();
            }
        }
        clearFields();
    }

    @FXML
    void searchProgram(ActionEvent event) {
        String programId = txtProgramID.getText();
        if (programId.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
        }   else{
            ProgramDto programDto = programBo.searchProgram(programId);
            if (programDto != null) {
                txtProgramID.setText(programDto.getProgramId());
                txtProgramName.setText(programDto.getName());
                txtDuration.setText(programDto.getDuration());
                txtFee.setText(String.valueOf(programDto.getFees()));
            }else{
                new Alert(Alert.AlertType.ERROR, "Search Failed").show();
            }
        }
    }

    @FXML
    void updateProgram(ActionEvent event) {
        String id = txtProgramID.getText();
        if (id.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all the fields").show();
        }else{
            String programName = txtProgramName.getText();
            String duration = txtDuration.getText();
            double fee = Double.parseDouble(txtFee.getText());
            ProgramDto programDto = new ProgramDto(id, programName, duration, fee);
            boolean result = programBo.updateProgram(programDto);
            getallProgram();
            if (result) {
                getallProgram();
                new Alert(Alert.AlertType.CONFIRMATION, "Update Successful").show();
            }
        }
    clearFields();
    }

    public void onClickedAction(javafx.scene.input.MouseEvent mouseEvent) {
        TableView<ProgramDto> tableView = (TableView<ProgramDto>) mouseEvent.getSource();
        ProgramDto selectedData = tableView.getSelectionModel().getSelectedItem();

        if (selectedData != null) {
            String programId = selectedData.getProgramId();
            String programName = selectedData.getName();
            String duration = selectedData.getDuration();
            double fee = selectedData.getFees();

            txtProgramID.setText(programId);
            txtProgramName.setText(programName);
            txtDuration.setText(duration);
            txtFee.setText(String.valueOf(fee));
        }

    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) txtProgramID.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Login Page");
    }
}
