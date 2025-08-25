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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetCourtScheduleSceneController implements Initializable {

    @FXML
    private TableView<?> tableView;
    @FXML
    private TextField caseIdTextField;
    @FXML
    private TextField caseTitleTextField;
    @FXML
    private TextField defIdTextField;
    @FXML
    private TextField defNameTextField;
    @FXML
    private DatePicker nextHearDatePicker;
    @FXML
    private ComboBox<?> propCourtRoomCB;
    @FXML
    private TextArea viewHearDetTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MagistrateDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void loadCasesButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void saveHearDetButtonOnClick(ActionEvent event) {
    }

}
