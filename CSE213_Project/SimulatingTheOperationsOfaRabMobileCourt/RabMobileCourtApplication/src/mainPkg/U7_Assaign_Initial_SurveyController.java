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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Assaign_Initial_SurveyController implements Initializable {

    @FXML
    private TextField institutionNametextField;
    @FXML
    private TextField institutionLocationTextField;
    @FXML
    private TextArea surveyDescriptionTextArea;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));

    }

    

    @FXML
    private void assignSurveyOnClick(ActionEvent event) {
        String institutionName=institutionNametextField.getText();
        if(institutionName.equals("")){
            showAlert("Enter Institution Name", "Institution Name cannot be empty.");
            return;
        }
                
        String institutionLocation=institutionLocationTextField.getText();
                
        if(institutionLocation.equals("")){
            showAlert("Enter Institution Location", "Institution Location cannot be empty.");
            return;
        }
        String surveyDescription=surveyDescriptionTextArea.getText();
        if(surveyDescription.equals("")){
            showAlert("Enter Description", "Initail Survey Description cannot be empty.");
            return;
        }
        
        try{
            File file=new File("User7_All_File//assignrd_Initial_Survey_File//assigned_Initial_Survey.txt");
            if(!file.exists())file.createNewFile();
            FileWriter fileWriter=new FileWriter(file,true);
            
            fileWriter.write(institutionName+"#"+institutionLocation+"#"+surveyDescription+"\n");
            fileWriter.close();
            
        }catch(Exception e){
            
        }
        
        U7_Initial_Survey initialSurvey=new U7_Initial_Survey(institutionName,institutionLocation,surveyDescription);
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Initial_Survey_Assign");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText(initialSurvey.toString()+"is Assigned!");
        informationAlert.showAndWait();
        
        
        institutionNametextField.clear();
        institutionLocationTextField.clear();
        surveyDescriptionTextArea.clear();
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
