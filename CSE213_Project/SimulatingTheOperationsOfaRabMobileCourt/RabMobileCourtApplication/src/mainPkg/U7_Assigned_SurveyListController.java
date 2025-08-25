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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Assigned_SurveyListController implements Initializable {

    @FXML
    private ListView<String>assignedSurveyListView;
    ObservableList<String> initSurveyList=FXCollections.observableArrayList();
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
        
        try{
            File file=new File("User7_All_File//assignrd_Initial_Survey_File//assigned_Initial_Survey.txt");
            if(!file.exists()){
                System.out.println("File Doesnt Exist");
                return;
            }
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String[] part=sc.nextLine().split("#");
                String initSurvey=part[0]+" "+part[1]+" "+part[2];
                initSurveyList.add(initSurvey);
                
            }
           
            
            
            
        }catch(Exception e){
            
        }
        assignedSurveyListView.setItems(initSurveyList);
        
    }    

    @FXML
    private void backDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }
    
}
