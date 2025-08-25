/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U8_Check_Survey_ScheduleController implements Initializable {

    @FXML
    private TableView<Survey_Schedule> surveyScheduleTableView;
    @FXML
    private TableColumn<Survey_Schedule,String> surveyIdCol;
    @FXML
    private TableColumn<Survey_Schedule, String> institutionCol;
    @FXML
    private TableColumn<Survey_Schedule, String> locationCol;
    @FXML
    private TableColumn<Survey_Schedule, LocalDate> surveyDateCol;
    //ObservableList<U8_Survey_Schedule> surveyScheduleList=FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        U8_Make_Survey_ScheduleController.surveyScheduleList.clear();
        try{
            
            File file=new File("User8_All_File//survey_Schedule_File.txt");
            if(!file.exists())file.createNewFile();
            
            
            Scanner sc=new Scanner(file);
            while(sc.hasNext()){
                String[] part=sc.nextLine().split("#");
                
                Survey_Schedule surveyScedule=new Survey_Schedule(part[0],part[1],part[2],LocalDate.parse(part[3]));
                System.out.println(surveyScedule.toString());
                U8_Make_Survey_ScheduleController.surveyScheduleList.add(surveyScedule);
                
                
            }
            
                    
        
        }catch(Exception e){
            System.out.println("Something is Wrong!");

        }
        surveyIdCol.setCellValueFactory(new PropertyValueFactory<>("surveyId"));
        institutionCol.setCellValueFactory(new PropertyValueFactory<>("institutionName"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("institutionLocation"));
        surveyDateCol.setCellValueFactory(new PropertyValueFactory<>("surveyDate"));
        
        surveyScheduleTableView.setItems(U8_Make_Survey_ScheduleController.surveyScheduleList);
        
        
        
    }    

    @FXML
    private void BackDashBoardOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U8_Undercover_Investigator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void SignOutOnAction(ActionEvent event) {
    }

    @FXML
    private void makeSurveyDoneOnClick(ActionEvent event) throws IOException {
        Survey_Schedule selectedSchedule=surveyScheduleTableView.getSelectionModel().getSelectedItem();
        U8_Make_Survey_ScheduleController.surveyScheduleList.remove(selectedSchedule);
        
        
        File file=new File("User8_All_File//survey_Schedule_File.txt");
        if(!file.exists())file.createNewFile();
            
        FileWriter fileWriter=new FileWriter(file);
            

        for (Survey_Schedule ss:U8_Make_Survey_ScheduleController.surveyScheduleList){
             
             fileWriter.write(ss.getSurveyId()+"#"+ss.getInstitutionName()+"#"+ss.getInstitutionLocation()+"#"+ss.getSurveyDate()+"\n");        
            // fileWriter.close();
        }
        fileWriter.close();
        try{
            File file1=new File("User8_All_File//previously_Survey_Lit_File.txt");
            if(!file1.exists())file1.createNewFile();
            FileWriter fileWriter1=new FileWriter(file1,true);
            fileWriter1.write(selectedSchedule.getSurveyId()+"#"+selectedSchedule.getInstitutionName()+"#"+selectedSchedule.getInstitutionLocation()+"#"+selectedSchedule.getSurveyDate()+"\n");
            fileWriter1.close();
        }catch(Exception e){
            System.out.println("something wrong 2");
        }
        //Show Alert that the survey is Done
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Survey Done");
        informationAlert.setHeaderText(null);
        informationAlert.setContentText("Survey : "+selectedSchedule.getSurveyId() + " is Done!");
        informationAlert.showAndWait();
       
        
        
        
        
         
        
        
    }
    
}
