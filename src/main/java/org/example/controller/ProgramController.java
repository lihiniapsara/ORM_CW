package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BOFactory;
import org.example.bo.custom.impl.ProgramBOImpl;
import org.example.dto.ProgramDTO;
import org.example.dto.StudentDTO;
import org.example.dto.UserDTO;
import org.example.tm.ProgramTm;
import org.example.tm.StudentTm;

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
    public TextField txtid;


    ProgramBOImpl programBO=new ProgramBOImpl();

    private List<ProgramTm> programList = new ArrayList<>();

    public void initialize() {
        loadAllPrograms();
        setCellValueFactory();

    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("program_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("program_name"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colfee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private void loadAllPrograms() {
        ObservableList<ProgramTm> oblist = FXCollections.observableArrayList();
        ArrayList<ProgramDTO> programList = programBO.getAll();
        for (ProgramDTO dto : programList) {
            oblist.add(new ProgramTm(dto.getProgram_id(), dto.getProgram_name(), dto.getDuration(), dto.getFee()));
        }
        tblProgram.setItems(oblist);

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
        String id = txtid.getText();
        String name = txtName.getText();
        String duration = txtDuration.getText();
        String fee = txtfee.getText();

        boolean isSaved = programBO.save(new ProgramDTO(id,name, duration, fee));
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!").show();
            loadAllPrograms(); // Refresh the table
            clearFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save!").show();
        }
    }

    public void clearFields() {
        txtid.clear();
        txtName.clear();
        txtDuration.clear();
        txtfee.clear();
    }

    public void btnUpdateOnAction(ActionEvent event) {
        String id = txtid.getText();
        String name = txtName.getText();
        String duration = txtDuration.getText();
        String fee = txtfee.getText();

        try {
            boolean isUpdated = programBO.update(new ProgramDTO(id,name, duration, fee));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
                loadAllPrograms();
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "No record found to update!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again!").show();
            e.printStackTrace();
        }

    }


    public void btnDeleteOnAction(ActionEvent event) {
        String id = txtid.getText();

        // Validation to ensure the ID field is not empty
        if (id.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please enter the Program ID!").show();
            return;
        }

        // Assuming you have a delete method in ProgramBO
        boolean isDeleted = programBO.delete(id);

        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Program Deleted!").show();
            loadAllPrograms(); // Refresh the table
            clearFields(); // Clear the input fields after deletion
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

    public void updateprogram(MouseEvent mouseEvent) {
        TableView<ProgramTm> table = (TableView<ProgramTm>) mouseEvent.getSource();
        ProgramTm program = table.getSelectionModel().getSelectedItem();
        if (program != null) {
            String id = program.getProgram_id();
            String name = program.getProgram_name();
            String duration = program.getDuration();
            String fee = program.getFee();

            txtid.setText(id);
            txtName.setText(name);
            txtDuration.setText(duration);
            txtfee.setText(fee);
        }

    }
}
