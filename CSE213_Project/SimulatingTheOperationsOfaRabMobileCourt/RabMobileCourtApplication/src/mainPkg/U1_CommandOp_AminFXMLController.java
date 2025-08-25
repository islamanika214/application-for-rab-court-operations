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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_CommandOp_AminFXMLController implements Initializable {

    @FXML
    private TextField institutionNameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField urgencyReasonTextField;
    @FXML
    private DatePicker investigationDateDatePicker;
    @FXML
    private TextArea investigationInfoTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loadInformationDetailsOnClick(ActionEvent event) {
        try {
            String institutionName = institutionNameTextField.getText();
            String location = locationTextField.getText();
            String urgencyReason = urgencyReasonTextField.getText();
            String investigationD;
            LocalDate investigationDate = investigationDateDatePicker.getValue();
            investigationD = investigationDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

            StringBuilder sb = new StringBuilder();
            sb.append('{');
            sb.append("Institution Name = ").append(institutionName);
            sb.append(", Location = ").append(location);
            sb.append(", Urgency Reason = ").append(urgencyReason);
            sb.append(", Investigation Date = ").append(investigationDate);
            sb.append('}');

            investigationInfoTextArea.setText(sb.toString() + "\n");
        } catch (Exception err) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Alert");
            error.setHeaderText("Fatal Error!");
            error.setContentText("Please fill all the fields proprly!");
            error.showAndWait();

        }
    }

    @FXML
    private void saveToFileOnClick(ActionEvent event) {

        File f = null;
        FileOutputStream fos = null;

        DataOutputStream dos = null;

        try {
            f = new File("Command Report.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }

            dos = new DataOutputStream(fos);

            String investigationD;
            LocalDate investigationDate = investigationDateDatePicker.getValue();
            investigationD = investigationDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

            if (urgencyReasonTextField.getText() != null && institutionNameTextField.getText() != null && locationTextField.getText() != null) {

                dos.writeUTF(institutionNameTextField.getText());
                dos.writeUTF(urgencyReasonTextField.getText());
                dos.writeUTF(locationTextField.getText());
                dos.writeUTF(investigationD);
            } else {

                System.err.println("Something went wrong!!! Please check inputs.");
            }

        } catch (IOException e) {
            Logger.getLogger(U1_CommandOp_AminFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                Logger.getLogger(U1_CommandOp_AminFXMLController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @FXML
    private void returnHomeOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("DistrictOfficerdashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

}
