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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_BudgetAllocationFXMLController implements Initializable {

    @FXML
    private TextField budgetTextField;
    @FXML
    private TableView<U1_Budget> budgetAllocationTableView;
    @FXML
    private TableColumn<U1_Budget, String> operationTableCol;
    @FXML
    private TableColumn<U1_Budget, String> placeTableCol;
    @FXML
    private TableColumn<U1_Budget, Integer> budgetTableCol;
    @FXML
    private ComboBox<String> operationTypeComboBox;
    @FXML
    private ComboBox<String> placeComboBox;

    ObservableList<U1_Budget> budgetList = FXCollections.observableArrayList();

    ArrayList<U1_Budget> bList = new ArrayList<>();
    @FXML
    private ComboBox<String> opesearchrationTypeComboBox1;
    @FXML
    private PieChart budgetPieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationTypeComboBox.getItems().addAll("Social Justice", "Terrorism", "Public Safety");
        placeComboBox.getItems().addAll("Mirpur", "Bashundhara", "ECB", "Dhanmondi", "Banani");
        opesearchrationTypeComboBox1.getItems().addAll("Social Justice", "Terrorism", "Public Safety");
        operationTableCol.setCellValueFactory(new PropertyValueFactory<U1_Budget, String>("operationtype"));
        placeTableCol.setCellValueFactory(new PropertyValueFactory<U1_Budget, String>("operationPlace"));
        budgetTableCol.setCellValueFactory(new PropertyValueFactory<U1_Budget, Integer>("budget"));

    }

    @FXML
    private void pieChartButtonOnClick(ActionEvent event) throws IOException {
        ObservableList<PieChart.Data> List = FXCollections.observableArrayList();
        for (U1_Budget bt : bList) {
            if (bt.getOperationtype().equals(opesearchrationTypeComboBox1.getValue())) {
                List.add(new PieChart.Data(bt.getOperationPlace(), bt.getBudget()));
            }

        }
        PieChart budgetChart = new PieChart(List);
        budgetChart.setTitle("Budget % in Following places");
        budgetPieChart.setData(List);
    }

    @FXML
    private void allocateBudgetOnClick(ActionEvent event) {

        try {
            String b = budgetTextField.getText();
            int budget = Integer.parseInt(b);
            String operationtype = operationTypeComboBox.getValue();
            String operationPlace = placeComboBox.getValue();

            U1_Budget bdgt = new U1_Budget(budget, operationtype, operationPlace);
            budgetList.add(bdgt);
            bList.add(bdgt);
            budgetAllocationTableView.setItems(budgetList);

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
            f = new File("Budget.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }

            dos = new DataOutputStream(fos);

//            String b = budgetTextField.getText();
//            int budget = Integer.parseInt(b);
//            String operationtype = operationTypeComboBox.getValue();
//            String operationPlace = placeComboBox.getValue();
            for (U1_Budget bt : budgetList) {
                dos.writeInt(bt.getBudget());
                dos.writeUTF(bt.getOperationtype());
                dos.writeUTF(bt.getOperationPlace());

            }

        } catch (IOException e) {
            Logger.getLogger(U1_BudgetAllocationFXMLController.class.getName()).log(Level.SEVERE, null, e);
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
