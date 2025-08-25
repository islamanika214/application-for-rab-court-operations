/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateCaseFileSceneController implements Initializable {

    @FXML
    private TextField caseIdTextField;
    @FXML
    private TextField caseTitleTextField;
    @FXML
    private TextField offiBadgeNumTextField;
    @FXML
    private TextField eviListTextField;
    @FXML
    private TextField eyeWitInfoTextField;
    @FXML
    private TextField defInfoTextField;
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
    private void viewDraftButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void saveCaseFileButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) {
    }

}
