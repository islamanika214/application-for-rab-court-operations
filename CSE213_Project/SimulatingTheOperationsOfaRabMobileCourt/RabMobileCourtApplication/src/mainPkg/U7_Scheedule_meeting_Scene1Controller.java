/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Scheedule_meeting_Scene1Controller implements Initializable {

    @FXML
    private TextField meetingIdTextField;
    @FXML
    private DatePicker meetingDatePicker;
    @FXML
    private Label displayTextArea;
    @FXML
    private CheckBox underCoverInvestigatorCheckBox;
    @FXML
    private CheckBox magistrateCheckBox;
    @FXML
    private CheckBox rabOfficerCheckBox;
    @FXML
    private CheckBox districtOfficerCheckBox;
    @FXML
    private CheckBox p5CheckBox;
    @FXML
    private TextField meetingTimeTextFiled;
    
    static ObservableList<U7_Schedule_Meeting> scheduleMeetingList=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        String meetingId=meetingIdTextField.getText();
        if(meetingId.equals("")){
            showAlert("", "Please Select Meeting Id.");
            return;
        }else if (isInteger(meetingId)) {
            System.out.println(meetingId);
        } else {
            showAlert("Invalid meeting Id", "Meeting Id must be an integer.");
            return;
        }
        
        LocalDate meetingDate=meetingDatePicker.getValue();
        if(meetingDate==null){
            showAlert("", "Please Select Meeting Date");
            return;
        }
        String mTime=meetingTimeTextFiled.getText();
        if(mTime.equals("")){
            showAlert("", "Please Enter Meeting Date");
            return;
        }
        
        String participant=" ";
        
        if(underCoverInvestigatorCheckBox.isSelected()){
            participant+="underCover Investigator";
        }
        if(magistrateCheckBox.isSelected()){
            participant+=", Magistrate";
        }
        if(rabOfficerCheckBox.isSelected()){
            participant+=", Rab Officer";
        }
        if(districtOfficerCheckBox.isSelected()){
            participant+=", District Officer";
        }
        if(p5CheckBox.isSelected()){
            participant+=", Others";
        }
        
        U7_Schedule_Meeting meetingSchedule=new U7_Schedule_Meeting(meetingId,meetingDate,mTime,participant);
        scheduleMeetingList.add(meetingSchedule);
        displayTextArea.setText(meetingSchedule.toString());
        
        meetingIdTextField.clear();
        meetingDatePicker.setValue(null);
        meetingTimeTextFiled.clear();
        
        
    }

    @FXML
    private void showMeetingScheduleOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Scheedule_Meeting_Scene2.fxml"));
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
    
    //Method for check valid Integer
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

    
    
