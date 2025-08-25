/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Generate_Chart_for_CaseController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private TextField CetegoryTextField;
    @FXML
    private TextField valueTextField;
    @FXML
    private TextArea showCurrentDataTextArea;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private PieChart surveyPieChart;
    
    ObservableList<XYChart.Data> barChartList=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January","February","March","April",
                "May","June","July","August","September","October",
                "November","December");
        yearComboBox.getItems().addAll("2023","2024","2025");
        
    }    

    @FXML
    private void addChartDataOnClick(ActionEvent event) {
        String month=monthComboBox.getValue();
        if(month == null){
            showAlert("", "Please Select Month of Case Report Chart");
            return;
        }
        String year=yearComboBox.getValue();
        if(year == null){
            showAlert("", "Please Select year of Case Report Chart");
            return;
        }
        String cetegory=CetegoryTextField.getText();
        if(cetegory.equals("")){
            showAlert("", "Please Enter  Cetegory");
            return;
        }
        String valueStr=valueTextField.getText();
        if(valueStr.equals("")){
            showAlert("", "Please Enter Value");
            return;
        }else if (isInteger(valueStr)) {
            int integerValue = Integer.parseInt(valueStr);
            System.out.println("Value of" +cetegory+" : " + integerValue );
        } else {
            showAlert("Invalid Input", "Value must be a Number.");
            return;
        }
        
        Number value=Integer.parseInt(valueStr);
        
        
        
        try{
            File file=new File("User7_All_File//chart_data_of_case//"+month+year+".txt");
            if(!file.exists())file.createNewFile();
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(cetegory+"#"+value+"\n");
            fileWriter.close();
            
            XYChart.Data data=new XYChart.Data(cetegory,value);
        
            barChartList.add(data);
            showCurrentDataTextArea.setText(barChartList.toString());
        
        
        }catch(Exception e){
            System.out.println("Something Wrong!");
        }
        
        
        CetegoryTextField.clear();
        valueTextField.clear();
       
    }

    @FXML
    private void showChartOnClick(ActionEvent event) {
        barChart.getData().clear();
        surveyPieChart.getData().clear();
        XYChart.Series set1=new XYChart.Series<>();
        ObservableList<PieChart.Data> pieData=FXCollections.observableArrayList();
        
        String month=monthComboBox.getValue();
        if(month == null){
            showAlert("", "Please Select Month of Report Chart");
            return;
        }
        String year=yearComboBox.getValue();
        if(year == null){
            showAlert("", "Please Select Year of Report Chart");
            return;
        }
        try{
            File file=new File("User7_All_File//chart_data_of_case//"+month+year+".txt");
            if(!file.exists()){
                showAlert("Report chart doesn't exists", "Report chart doesn't exists");
                return;
            }
            
            Scanner sc=new Scanner(file);
            
            while(sc.hasNextLine()){
                String [] part=sc.nextLine().split("#");
                set1.getData().add(new XYChart.Data(part[0],Integer.parseInt(part[1])));
                pieData.add(new PieChart.Data(part[0],Double.parseDouble(part[1])));
                
            }
            
            
        }catch(Exception e){
            
        }
        barChart.getData().addAll(set1);
        
        surveyPieChart.getData().addAll(pieData);
        
    }

    @FXML
    private void backToDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }
    //Mthod for show alert 
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    //method for check valid integer
    
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
}
