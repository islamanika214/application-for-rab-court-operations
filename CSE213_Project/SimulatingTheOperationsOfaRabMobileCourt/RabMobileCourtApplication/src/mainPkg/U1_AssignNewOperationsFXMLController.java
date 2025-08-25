/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class U1_AssignNewOperationsFXMLController implements Initializable {

    @FXML
    private TextField institutionNameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private ComboBox<String> numberOfOfficerComboBox;
    @FXML
    private ComboBox<String> magistrateComboBox;
    @FXML
    private DatePicker operationDateDatePicker;
    @FXML
    private TextArea operationDetailsTextArea;

    //private ArrayList<String> operationList = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberOfOfficerComboBox.getItems().addAll("1", "2", "3", "4", "5");
        magistrateComboBox.getItems().addAll("Nafiul Islam", "Nushrat Anika", "Jarin Afrin", "Opshora Hossain", "Tasmia Islam");

    }

    @FXML
    private void saveToFileButtonOnClick(ActionEvent event) {
        
        File f = null;
        FileOutputStream fos = null;

        DataOutputStream dos = null;

        try {
            f = new File("NewOperation.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }

            dos = new DataOutputStream(fos);
            
            String opDate;
            LocalDate operationDate = operationDateDatePicker.getValue();
            opDate = operationDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            

            
            if (magistrateComboBox.getValue() != null && institutionNameTextField.getText() != null  && locationTextField.getText() != null  && numberOfOfficerComboBox.getValue() != null) {
                  
                dos.writeUTF(magistrateComboBox.getValue());
                dos.writeUTF(numberOfOfficerComboBox.getValue());
                dos.writeUTF(institutionNameTextField.getText());
                dos.writeUTF(locationTextField.getText());
                dos.writeUTF(opDate);
            } else {

                System.err.println("Something went wrong!!! Please check inputs.");
            }

        } catch (IOException e) {
            Logger.getLogger(U1_AssignNewOperationsFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                Logger.getLogger(U1_AssignNewOperationsFXMLController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        
        
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("DistrictOfficerdashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

    @FXML
    private void operationDetailsButtonOnClick(ActionEvent event) {
        try {
            String institutionName = institutionNameTextField.getText();
            String opDate;
            LocalDate operationDate = operationDateDatePicker.getValue();
            opDate = operationDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            String location = locationTextField.getText();
            String numberOfOfficer = numberOfOfficerComboBox.getValue();
            String magistrateName = magistrateComboBox.getValue();
            //ArrayList<String> operationLists = new ArrayList<>(operationList);

            StringBuilder sb = new StringBuilder();
            sb.append('{');
            sb.append("Institution Name= ").append(institutionName);
            sb.append(", Location= ").append(location);
            sb.append(", Number Of Officer= ").append(numberOfOfficer);
            sb.append(", Magistrate Name= ").append(magistrateName);
            sb.append(", Operation Date= ").append(operationDate);
            sb.append('}');
            operationDetailsTextArea.setText(sb.toString() + "\n");
        } catch(Exception err){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Alert");
            error.setHeaderText("Fatal Error!");
            error.setContentText("Please fill all the fields proprly!");
            error.showAndWait();
        }

        

    }

}
