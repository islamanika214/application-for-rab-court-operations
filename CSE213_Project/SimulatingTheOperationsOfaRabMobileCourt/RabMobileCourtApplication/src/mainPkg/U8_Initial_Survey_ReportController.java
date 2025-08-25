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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U8_Initial_Survey_ReportController implements Initializable {

    @FXML
    private TextField InitialSurveyIdTextField;
    @FXML
    private TextField institutionNameTextField;
    @FXML
    private TextField InsttitutionLocationTextField;
    @FXML
    private DatePicker surveydatePicker;
    @FXML
    private TextArea SuspeciousActvitiesTextArea;
    @FXML
    private TextArea showReportTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backDashBoardOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U8_Undercover_Investigator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void saveToFileButtonOnClick(ActionEvent event) {
        String initialSurveyId=InitialSurveyIdTextField.getText();
        

        if(initialSurveyId.equals("")){
            showAlert("Enter Initial Survey Id", "Initial Survey Id cannot be empty.");
    
            return;
        }
        else if (isInteger(initialSurveyId)) {
            int parsedSurveyId = Integer.parseInt(initialSurveyId);
            System.out.println("Survey Id (Integer): " + parsedSurveyId);
        } else {
            showAlert("Invalid Survey Id", "Survey Id must be an integer.");
            return;
        }
        String institutionName=institutionNameTextField.getText();
        if(institutionName.equals("")){
            showAlert("Enter Institution Name", "Institution Name cannot be empty.");
    
            return;
        }
        
        String institutionLocation=InsttitutionLocationTextField.getText();
        
        if(institutionLocation.equals("")){
            showAlert("Enter Institution Location", "Institution Location cannot be empty.");
    
            return;
        }
        
        LocalDate initialSurveyDate=surveydatePicker.getValue();
        if(initialSurveyDate==null){
            showAlert("Enter Initial Survey Date", "Initial Survey Date cannot be empty.");
    
            return;
        }
        
        String description=SuspeciousActvitiesTextArea.getText();
        if(description.equals("")){
            showAlert("Enter Description", "Suspecious Activity cannot be empty.");
    
            return;
        }
        U8_Initial_Survey_Report initialSurveyReport=new U8_Initial_Survey_Report(
                initialSurveyId,institutionName,institutionLocation,initialSurveyDate,description);
        //Save the data's to a file
        try{
            File file =new File("User8_All_File//Initial_Surevey_Report_File//initialsurveyReport.txt");
            if(!file.exists())file.createNewFile();
        
            FileWriter fileWriter=new FileWriter(file,true);
            
            fileWriter.write(initialSurveyReport.toString());
            fileWriter.close();
            
            
        }catch(Exception e){
            
            System.out.println("Something went Wrong!");
        }
        ///Show Information alert that the data's are save in the file
        
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Information");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText("Initial Report is Save in file.");
        informationAlert.showAndWait();
        
        InitialSurveyIdTextField.clear();
        institutionNameTextField.clear();
        InsttitutionLocationTextField.clear();
        surveydatePicker.setValue(null);
        SuspeciousActvitiesTextArea.clear();


        
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private boolean isInteger(String input) {
        try {
            
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }

    @FXML
    private void loadreportOnclick(ActionEvent event) {
        try{
            File file=new File("User8_All_File//Initial_Surevey_Report_File//initialsurveyReport.txt");
            if(!file.exists())file.createNewFile();
            
            Scanner sc=new Scanner(file);
            String str="";
            while(sc.hasNextLine()){
                String part=sc.nextLine();
                str+=part+"\n";
                
            }
            showReportTextArea.setText(str);
                    
            
        }catch(Exception e){
            System.out.println("Something went Wrong!");
        }
    }
}
