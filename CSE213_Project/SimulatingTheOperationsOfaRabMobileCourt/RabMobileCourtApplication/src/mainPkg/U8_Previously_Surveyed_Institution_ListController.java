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
public class U8_Previously_Surveyed_Institution_ListController implements Initializable {

    @FXML
    private ListView<String> previouslySurveyedListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        File file=new File("User8_All_File//previously_Survey_Lit_File.txt");
        if(!file.exists())file.createNewFile();
        
        Scanner sc=new Scanner(file);
        String str="";
        while(sc.hasNextLine()){
            String [] part=sc.nextLine().split("#");
            str += part[0]+" "+part[1]+" "+part[2]+" "+part[3] +"\n";
        }
        previouslySurveyedListView.getItems().addAll(str);
        
        
        }catch(Exception e){
        }
        
        
        
    }    

    @FXML
    private void backDashBoardOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U8_Undercover_Investigator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }
    
}
