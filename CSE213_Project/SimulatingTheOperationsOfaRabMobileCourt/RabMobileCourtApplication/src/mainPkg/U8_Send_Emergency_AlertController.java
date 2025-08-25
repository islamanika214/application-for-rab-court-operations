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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class U8_Send_Emergency_AlertController implements Initializable {

    @FXML
    private ComboBox<String> selectUserComboBox;
    @FXML
    private TextField emergencyElertId;
    @FXML
    private TextField institutionNameTextField;
    @FXML
    private TextField institutionLocationTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextArea showEmergencyAlertTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectUserComboBox.getItems().addAll("Operations Administrator","RAB Officer","Distrcict Officer");
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
    private void sendEmergencyAlertButtonOnClick(ActionEvent event) {
        String emergancyAlertId=emergencyElertId.getText();
        

        if(emergancyAlertId.equals("")){
            showAlert("Enter Emerganc yAlert Id", "Emergancy Alert Id cannot be empty.");
    
            return;
        }
        else if (isInteger(emergancyAlertId)) {
            int parsedSurveyId = Integer.parseInt(emergancyAlertId);
            System.out.println("Survey Id (Integer): " + parsedSurveyId);
        } else {
            showAlert("Invalid emergancy Alert Id", "Emergancy Alert Id must be an integer.");
            return;
        }
        String institutionName=institutionNameTextField.getText();
        if(institutionName.equals("")){
            showAlert("Enter Institution Name", "Institution Name cannot be empty.");
    
            return;
        }
        
        String institutionLocation=institutionLocationTextField.getText();
        
        if(institutionLocation.equals("")){
            showAlert("Enter Institution Location", "Institution Location cannot be empty.");
    
            return;
        }
        String alertReceiver=selectUserComboBox.getValue();
        if(alertReceiver==null){
            showAlert("Select Receiver","Select Emergancy Alert Receiver from ComboBox");
            return;
        }
        
        
        
        
        
        
        String description=descriptionTextArea.getText();
        if(description.equals("")){
            showAlert("Enter Description", "Enter Description og Alert");
    
            return;
        }
        U8_Emergency_Alert emergancyAlert=new U8_Emergency_Alert(emergancyAlertId,institutionName,institutionLocation,alertReceiver,description);
        
        try{
            File file =new File("User8_All_File//Emergency_Alert_File//EmergencyAlert.txt");
            if(!file.exists())file.createNewFile();
            
            FileWriter fileWriter=new FileWriter(file,true);
            fileWriter.write(emergancyAlert.toString());
            fileWriter.close();
            
            
        }catch(Exception e){
            
        }
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Emergency Alert");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText("Emergency Alert Send Successfully!");
        informationAlert.showAndWait();
        
        //clear fields
        selectUserComboBox.setValue(null);
        emergencyElertId.clear();
        institutionNameTextField.clear();
        institutionLocationTextField.clear();
        descriptionTextArea.clear();

        
        
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
    private void loadAlertButtonOnClick(ActionEvent event) {
        try{
            File file=new File("User8_All_File//Emergency_Alert_File//EmergencyAlert.txt");
            if(!file.exists())file.createNewFile();
            
            Scanner sc=new Scanner(file);
            String str="";
            while(sc.hasNextLine()){
                String part=sc.nextLine();
                str+=part+"\n";
                
            }
            showEmergencyAlertTextArea.setText(str);
                    
            
        }catch(Exception e){
            System.out.println("Something went Wrong!");
        }
    
    }
}
