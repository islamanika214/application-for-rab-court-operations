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
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DefenInfoSceneController implements Initializable {

    @FXML
    private RadioButton maleRB;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private RadioButton transRB;

    private ToggleGroup tg;
    @FXML
    private CheckBox relatedToOrgCheckBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField contdetailsTextField;
    @FXML
    private TextField permAddrTextField;
    @FXML
    private TextField nidNumTextField;
    @FXML
    private TextField nameOfInstiTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        maleRB.setToggleGroup(tg);
        femaleRB.setToggleGroup(tg);
        transRB.setToggleGroup(tg);
        
        maleRB.setSelected(true); //optional

    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RabOfficerDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void saveInfoButtonOnClick(ActionEvent event) {
    }

}
