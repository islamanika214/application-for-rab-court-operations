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
public class U8_Request_For_Initial_SurveyController implements Initializable {

    @FXML
    private TextField institutionNameTextField;
    @FXML
    private TextArea surveyDetailsTextArea;
    @FXML
    private DatePicker surveyDatePicker;
    @FXML
    private TextField investigatorIdTextField;
    @FXML
    private TextField institutionLocationTextField;
    @FXML
    private TextArea notificationTextArea;

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
    private void sendInitialSurveyRequestOnClick(ActionEvent event) {
        
    
        String investigatorId=investigatorIdTextField.getText();
        if(investigatorId.equals("")){
            showAlert("", "Please Enter Investigator Id");
            return;
        }else if (isInteger(investigatorId)) {
            int parsedSurveyId = Integer.parseInt(investigatorId);
        } else {
            showAlert("Invalid investigator Id", "investigator Id must be an integer.");
            return;
        }

        
        
        String institutionName=institutionNameTextField.getText();
        if(institutionName.equals("")){
            showAlert("", "Please Enter Institution Name");
            return;
        }
        
        String institutionLocation=institutionLocationTextField.getText();
        if(institutionLocation.equals("")){
            showAlert("", "Please Enter Institution Location");
            return;
        }
        LocalDate surveyDate=surveyDatePicker.getValue();
        if(surveyDate == null){
            showAlert("", "Please Enter Survey Detals");
            return;
        }
        String surveyDetals=surveyDetailsTextArea.getText();
        if(surveyDetals.equals("")){
            showAlert("", "Please Enter Survey Detals");
            return;
        }
        
        try{
            String fileName="User8_All_File"+"//Request_Initial_Survey"+"//initsuvey.txt";
            File file=new File(fileName);
            if(!file.exists())file.createNewFile();
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(investigatorId+"#"+institutionName+"#"+institutionLocation+"#"+surveyDate+"#"+surveyDetals+"\n");
            fileWriter.close();
            
        }catch(Exception e){
            
        }
        U8_Survey_Request surveyRequest=new U8_Survey_Request(investigatorId,institutionName,institutionLocation,surveyDate,surveyDetals);
        notificationTextArea.setText(surveyRequest.toString());
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Request Sends!");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText("Request Sends to Operations Administrator Successfully!");
        informationAlert.showAndWait();

        
        
        //Clear the fields
        institutionNameTextField.clear();
    
        surveyDetailsTextArea.clear();
        surveyDatePicker.setValue(null);
    
        investigatorIdTextField.clear();
        institutionLocationTextField.clear();


        
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
