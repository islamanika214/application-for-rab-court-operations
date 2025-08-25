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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnnounceVerdictSceneController implements Initializable {

    @FXML
    private DatePicker dateOfVerDatePicker;
    @FXML
    private TextField verIdTextField;
    @FXML
    private TextField defNameTextField;
    @FXML
    private TextField instiNameTextField;
    @FXML
    private ComboBox<?> instiTypeCB;
    @FXML
    private TextArea crimeDetailsTextArea;
    @FXML
    private TextField secOfLawTextField;
    @FXML
    private RadioButton fineRB;
    @FXML
    private RadioButton jailRB;
    @FXML
    private TextArea viewTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void viewButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void createPdfButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MagistrateDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

}
