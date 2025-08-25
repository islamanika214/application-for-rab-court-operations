/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdditionalCaseInfoSceneController implements Initializable {

    @FXML
    private TextArea viewCaseInfoReqTextArea;
    @FXML
    private TextField addiCaseInfoIdTField;
    @FXML
    private TextField caseIdTextField;
    @FXML
    private TextField defenIdTextField;
    @FXML
    private RadioButton yesRadioB;
    @FXML
    private RadioButton noRadioB;
    @FXML
    private TextArea pastHistTextArea;
    @FXML
    private TextArea viewDraftTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void viewAdditionalInfoButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewDraftButtonOnClick(ActionEvent event) {
    }


    @FXML
    private void saveInfoButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RabOfficerDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

}
