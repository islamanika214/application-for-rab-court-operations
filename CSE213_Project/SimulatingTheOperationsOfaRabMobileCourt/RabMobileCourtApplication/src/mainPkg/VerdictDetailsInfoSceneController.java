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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerdictDetailsInfoSceneController implements Initializable {

    @FXML
    private TextField caseIdTextField;
    @FXML
    private TextField verIdTextField;
    @FXML
    private ComboBox<?> verTypeCB;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> caseIdTableCol;
    @FXML
    private TableColumn<?, ?> verIDTableCol;
    @FXML
    private TableColumn<?, ?> verTypeTableCol;
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveVerDetailsButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewInTableButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewInPieChartButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MagistrateDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

}
