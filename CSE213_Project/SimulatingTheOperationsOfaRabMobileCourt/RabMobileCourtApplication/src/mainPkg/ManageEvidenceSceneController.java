package mainPkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ManageEvidenceSceneController implements Initializable {

    @FXML
    private ComboBox<String> eviTypeCB;
    @FXML
    private TextField eviNameTextField;
    @FXML
    private DatePicker dateOfAcqDP;
    @FXML
    private TextField eviIdTextField;
    @FXML
    private TableView<Evidence> eviTable;
    @FXML
    private TableColumn<Evidence, Integer> eviIdTableCol;
    @FXML
    private TableColumn<Evidence, String> eviNameTableCol;
    @FXML
    private TableColumn<Evidence, String> eviTypeCol;
    @FXML
    private TableColumn<Evidence, LocalDate> dateCol;
    @FXML
    private TableColumn<Evidence, Integer> caseIdCol;
    @FXML
    private TextField caseIdTextField;
    @FXML
    private PieChart eviPieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        eviTypeCB.getItems().addAll("Testimonial", "Eyewitness", "Solid", "Picture", "Video Footage");

        eviIdTableCol.setCellValueFactory(new PropertyValueFactory<Evidence, Integer>("evidenceId"));
        eviNameTableCol.setCellValueFactory(new PropertyValueFactory<Evidence, String>("eviName"));
        eviTypeCol.setCellValueFactory(new PropertyValueFactory<Evidence, String>("evidenceType"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Evidence, LocalDate>("dateOfAcquire"));
        caseIdCol.setCellValueFactory(new PropertyValueFactory<Evidence, Integer>("caseId"));
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RabOfficerDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void loadTableButtonOnClick(ActionEvent event) {
        Evidence newEvidence = new Evidence(
                Integer.parseInt(eviIdTextField.getText()),
                eviNameTextField.getText(),
                eviTypeCB.getValue(),
                dateOfAcqDP.getValue(),
                Integer.parseInt(caseIdTextField.getText())
        );
        eviTable.getItems().add(newEvidence);
    }

    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
    }

}
