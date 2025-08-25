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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U8_Make_Survey_ScheduleController implements Initializable {

    @FXML
    private TextField surveyIdTextField;
    @FXML
    private TextField InstitutionNameTextField;
    @FXML
    private TextField institutionLocationTextField;
    @FXML
    private DatePicker surveyDatePicker;
    @FXML
    private Label notificationTextArea;

    static ObservableList<Survey_Schedule> surveyScheduleList=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToDashBoardOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U8_Undercover_Investigator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void saveSurveyScheduleOnClick(ActionEvent event) {
        String surveyId=surveyIdTextField.getText();
        if(surveyId.equals("")){
            showAlert("Enter Survey Id", "Survey Id cannot be empty.");
    
            return;
        }
        else if (isInteger(surveyId)) {
            int parsedSurveyId = Integer.parseInt(surveyId);
            System.out.println("Survey Id (Integer): " + parsedSurveyId);
        } else {
            showAlert("Invalid Survey Id", "Survey Id must be an integer.");
            return;
        }
        
        String institutionName=InstitutionNameTextField.getText();
        if(institutionName.equals("")){
            showAlert("Enter Institution Name", "Institution Name cannot be empty.");
            
            return;
            
        }
        String institutionLocation=institutionLocationTextField.getText();
        if(institutionLocation.equals("")){
            showAlert("Enter Institution Location", "Institution Location cannot be empty.");
            
            return;
            
        }
        LocalDate surveyDate=surveyDatePicker.getValue();
         
        if(surveyDate==null){
            showAlert("Enter Survey Date", "Survey Date cannot be empty.");
            
            return;
            
        }
        
        try{
            
            File file=new File("User8_All_File//survey_Schedule_File.txt");
            if(!file.exists())file.createNewFile();
            
            boolean existSurveyId=false;
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String[] part=sc.nextLine().split("#");
                if(surveyId.equals(part[0])){
                    existSurveyId=true;
                    break;
                }
            }
            if (existSurveyId){
                    showAlert("Duplicate Survey Id", "A survey with this ID already exists.");
                    return;
            }
            else{
                FileWriter fileWriter=new FileWriter(file,true);
                fileWriter.write(surveyId+"#"+institutionName+"#"+institutionLocation+"#"+surveyDate+ "\n");
                fileWriter.close();
            }
            
            
        }catch(Exception e){
            System.out.println("Something is Wrong!");
        }
        
        Survey_Schedule surveySchedule=new Survey_Schedule(surveyId,institutionName,institutionLocation,surveyDate);
        
        //surveyScheduleList.add(surveySchedule);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Saved");
        alert.setHeaderText(null);
        alert.setContentText(surveySchedule.toString()+"Succesfully Added!");
        alert.showAndWait();
        
        
        surveyIdTextField.clear();
        InstitutionNameTextField.clear();
        institutionLocationTextField.clear();
        surveyDatePicker.setValue(null);

        
        
        
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    //Method for valid integer check
    private boolean isInteger(String input) {
        try {
            // Attempt to parse the input as an integer
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            // Parsing failed, input is not an integer
            return false;
        }
    }
        
    
}
