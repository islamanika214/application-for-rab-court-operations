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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;                                 //Available_Lawyer_List
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_AvailableLawyersFXMLController implements Initializable {

    @FXML
    private TextArea lawyerListTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void availableLawyerlistButtonOnClick(ActionEvent event) {
        
        lawyerListTextArea.clear();
        File f = null;
        
        Scanner sc; String str; String[] tokens;
        try {
            
            FileChooser fc = new FileChooser();
            f = fc.showOpenDialog(null);
            sc = new Scanner(f);
            if(f.exists()){
                lawyerListTextArea.appendText("Available Lawyer List:\n");
                while(sc.hasNextLine()){
                    str=sc.nextLine();
                    tokens = str.split(",");
                    lawyerListTextArea.appendText(
                            "Id="+tokens[0]
                            + " ,Name="+tokens[1]+"\n"                    
                    );
                }
            }
            else 
                lawyerListTextArea.setText("Something went wrong Available_Lawyer_List.txt does not exist...");
        } 
        catch (IOException ex) {
            Logger.getLogger(U1_AvailableLawyersFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
        }        
    }
    

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("DistrictOfficerdashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);
        

        
        Stage someStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }
    
}
