/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Generate_Case_ReportController implements Initializable {

    @FXML
    private TextArea reportDetailsTextArea;
    @FXML
    private DatePicker caseReportDatePicker;
    @FXML
    private TextArea showSaveReportTextArea;
    @FXML
    private Label notificationLabel;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private TextField caseReportIdTextField;
    @FXML
    private ComboBox<String> monthComboBox;

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
    private void saveReportOnClick(ActionEvent event) {
        String month=monthComboBox.getValue();
        if(month==null){
            showAlert("", "Please Select case Report Month");
            return;
        }
        
        String year=yearComboBox.getValue();
        if(year==null){
            showAlert("", "Please Select case Report Year");
            return;
        }
        
        String reportId=caseReportIdTextField.getText();
        if(reportId.equals("")){
            showAlert("", "Please Select Report id");
            return;
        }else if (isInteger(reportId)) {
            int parsedSurveyId = Integer.parseInt(reportId);
            System.out.println("Survey Id (Integer): " + parsedSurveyId);
        } else {
            showAlert("Invalid Survey Id", "Survey Id must be an integer.");
            return;
        }
        
        LocalDate reportDate=caseReportDatePicker.getValue();
        if(reportDate==null){
            showAlert("", "Please Select Report Date");
            return;
        }
        
        String Description=reportDetailsTextArea.getText();
        if(Description.equals("")){
            showAlert("", "Please Select Report Details");
            return;
        }
        
        
        
        try{
            
            File file=new File("User7_All_File//Case_Report//"+month+year+".txt");
            if(!file.exists())file.createNewFile();
            
            boolean existCaseReportId=false;
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String [] part=sc.nextLine().split("#");
                if(reportId.equals(part[0])){
                    existCaseReportId=true;
                    break;
                }
            
            }
            
            if(existCaseReportId){
                showAlert("", "Report Id Already Exist!");
                return;
            }
            else{
                FileWriter fileWriter=new FileWriter(file,true);
                fileWriter.write(reportId+"#"+reportDate+"#"+Description+"\n");
                fileWriter.close();
            }
        
        }catch(Exception e){
            notificationLabel.setText("Something is Wrong!");
            
        }
        
        
        U7_Case_Report caseReport=new U7_Case_Report(reportId,reportDate,Description);
        showSaveReportTextArea.setText(caseReport.toString());
        
        caseReportIdTextField.clear();
        caseReportIdTextField.clear();
        caseReportDatePicker.setValue(null);
        
        
        
    }

    @FXML
    private void viewCaseReportOnClick(ActionEvent event) {
        String month=monthComboBox.getValue();
        if(month==null){
            showAlert("", "Please Select case Report Month");
            return;
        }
        
        String year=yearComboBox.getValue();
        if(year==null){
            showAlert("", "Please Select case Report Year");
            return;
        }
        
        try{
            File file=new File("User7_All_File//Case_Report//"+month+year+".txt");
            if(!file.exists()){
                showAlert("Case Report Doesn't exist!", "Case Report Doesn't exist!");
                return;
                
            }
            Scanner sc=new Scanner(file);
            String caseReportStr="Case Report of" +month+" "+year +"\n";
            while(sc.hasNextLine()){
                String [] part=sc.nextLine().split("#");
                U7_Case_Report caseReport=new U7_Case_Report(part[0],LocalDate.parse(part[1]),part[2]);
                caseReportStr +=caseReport.toString()+"\n\n";
            }
            showSaveReportTextArea.setText(caseReportStr);
            
            
        }catch(Exception e){
            
        }
    }

    @FXML
    private void backToDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }
    //Method for show alert
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
