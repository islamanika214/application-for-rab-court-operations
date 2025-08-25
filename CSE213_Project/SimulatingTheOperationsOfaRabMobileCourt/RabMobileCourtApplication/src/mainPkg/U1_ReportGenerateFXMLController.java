/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_ReportGenerateFXMLController implements Initializable {

    @FXML
    private TextArea reportTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void saveTofileButtonOnClick(ActionEvent event) {
        
         File f = null;
        FileOutputStream fos = null;

        DataOutputStream dos = null;

        try {
            f = new File("Report File.txt");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }

            dos = new DataOutputStream(fos);
            
            
            

            
            if (reportTextArea.getText() != null) {
                  
                
                dos.writeUTF(reportTextArea.getText());
                
            } else {

                System.err.println("Something went wrong!!! Please check the Field");
            }

        } catch (IOException e) {
            Logger.getLogger(U1_CommandOp_AminFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                Logger.getLogger(U1_CommandOp_AminFXMLController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

        
    

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("DistrictOfficerdashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

}
