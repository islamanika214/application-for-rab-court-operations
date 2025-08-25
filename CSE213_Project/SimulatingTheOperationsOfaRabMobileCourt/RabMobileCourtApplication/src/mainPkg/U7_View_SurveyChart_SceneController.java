/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_View_SurveyChart_SceneController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private PieChart surveyPieChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January","February","March","April",
                "May","June","July","August","September","October",
                "November","December");
        yearComboBox.getItems().addAll("2023","2024","2025");
       
        //Load November 2023 Survey chart(Bar Chart and pie chart) when initialize the Scene
        barChart.getData().clear();
        surveyPieChart.getData().clear();
        XYChart.Series set1=new XYChart.Series<>();
        ObservableList<PieChart.Data> pieData=FXCollections.observableArrayList();
        
        
        
        try{
            File file=new File("User8_All_File//Survey_Chart//survey_Bar_Chart//November2023.txt");
            if(!file.exists())file.createNewFile();
            
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
    private void showChartOnClick(ActionEvent event) {
        barChart.getData().clear();
        surveyPieChart.getData().clear();
        XYChart.Series set1=new XYChart.Series<>();
        ObservableList<PieChart.Data> pieData=FXCollections.observableArrayList();
        
        String month=monthComboBox.getValue();
        if(month == null){
            showAlert("Enter Month of SurveyChart", "Month of SurveyChart cannot be empty.");
            
            return;
        }
        String year=yearComboBox.getValue();
        if(year == null){
            showAlert("Enter Year of SurveyChart", "Year of SurveyChart cannot be empty.");
            return;
        }
        try{
            File file=new File("User8_All_File//Survey_Chart//survey_Bar_Chart//"+month+year+".txt");
            if(!file.exists()){
                showAlert("Survey Chart Not Exits", "Survey Chart Not Exits for" +month+" "+year+ " !");
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
    //Method for Alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
