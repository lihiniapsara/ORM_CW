package org.example.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BOFactory;
import org.example.bo.custom.impl.ProgramBOImpl;
import org.example.dto.ProgramDTO;
import org.example.tm.ProgramTm;

import java.util.ArrayList;
import java.util.List;

public class ProgramController {
    public TextField txtName;
    public TextField txtDuration;
    public TextField txtfee;
    public TableView<ProgramTm> tblProgram;
    public TableColumn<?, ?> colId;
    public TableColumn<?, ?> colName;

    public TableColumn<?, ?> colfee;
    public Label txtProgramId;
    public AnchorPane root;
    public TableColumn<?, ?> colduration;


    ProgramBOImpl programBO=new ProgramBOImpl();

    private List<ProgramTm> programList = new ArrayList<>();

    public void initialize() {
        setCellValueFactory();
        loadAllPrograms();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("program_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("program_name"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colfee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void loadAllPrograms() {
        programList.clear();
        List<ProgramDTO> programDTOs = programBO.getAllPrograms(); // Assuming this method exists in ProgramBO
        for (ProgramDTO programDTO : programDTOs) {
            programList.add(new ProgramTm(programDTO.getProgram_id(), programDTO.getProgram_name(), programDTO.getDuration(), programDTO.getFee()));
        }
        tblProgram.getItems().setAll(programList);
    }

    public void nametextKeyReleased(KeyEvent keyEvent) {
        // Validation or functionality for name input
    }

    public void durationKeyReleased(KeyEvent keyEvent) {
        // Validation or functionality for duration input
    }

    public void feetextKeyReleased(KeyEvent keyEvent) {
        // Validation or functionality for fee input
    }

    public void btnSaveOnAction(ActionEvent event) {

        String name = txtName.getText();
        String duration = txtDuration.getText();
        String fee = txtfee.getText();

        boolean isSaved = programBO.save(new ProgramDTO(name, duration, fee));
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
            loadAllPrograms(); // Refresh the table
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save!").show();
        }
    }

    public void clearFields() {
        txtName.clear();
        txtDuration.clear();
        txtfee.clear();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String name = txtName.getText();
        String duration = txtDuration.getText();
        String fee = txtfee.getText();

        long programId = Long.parseLong(txtProgramId.getText()); // Ensure ID is fetched properly

        if (name.isEmpty() || duration.isEmpty() || fee.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please fill all fields!").show();
            return;
        }

        ProgramDTO programDTO = new ProgramDTO(programId, name, duration, fee);
        boolean isUpdated = programBO.update(programDTO); // Assuming this method exists in ProgramBO

        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Updated!").show();
            loadAllPrograms(); // Refresh the table
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update program!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {
        long programId = Long.parseLong(txtProgramId.getText()); // Ensure ID is fetched properly

        boolean isDeleted = programBO.delete(programId); // Assuming this method exists in ProgramBO

        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Deleted!").show();
            loadAllPrograms(); // Refresh the table
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to delete program!").show();
        }
    }

    public void btnClearOnAction(ActionEvent event) {
        txtName.clear();
        txtDuration.clear();
        txtfee.clear();
        txtProgramId.setText("0"); // Reset the ID if needed
    }

    public void idtextKeyReleased(KeyEvent keyEvent) {
        // You can implement search functionality here if needed
    }

    public void btnDashboardOnAction(ActionEvent event) {
        // Navigate to the dashboard
    }
}
