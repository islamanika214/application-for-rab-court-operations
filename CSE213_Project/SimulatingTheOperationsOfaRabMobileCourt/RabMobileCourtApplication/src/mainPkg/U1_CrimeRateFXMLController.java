/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_CrimeRateFXMLController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private TextArea crimeRateTextArea;
    @FXML
    private ComboBox<String> districtNameComboBox;
    @FXML
    private TextField crimeCountTextField;

    ArrayList<U1_CrimeRate> crimeRate = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        districtNameComboBox.getItems().addAll("Dhaka", "Khulna", "Barishal", "Chittagong", "Comilla");

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
    private void pieChartViewButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void loadButtonOnclick(ActionEvent event) {

        String c = crimeRateTextArea.getText();
        int crimeCount = Integer.parseInt(c);
        String districtName = districtNameComboBox.getValue();

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("crimeCount=").append(crimeCount);
        sb.append(", districtName=").append(districtName);
        sb.append('}');

        crimeCountTextField.setText(sb.toString() + "\n");

    }

}
