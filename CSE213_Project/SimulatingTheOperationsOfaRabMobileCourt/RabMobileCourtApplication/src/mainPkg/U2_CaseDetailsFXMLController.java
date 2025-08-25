/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U2_CaseDetailsFXMLController implements Initializable {

    @FXML
    private TextField caseNumberTextField;
    @FXML
    private TextArea caseDetailsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void searchCaseDetailsOnClick(ActionEvent event) {

        String caseN = caseNumberTextField.getText();
        int caseNumber = Integer.parseInt(caseN);

        caseDetailsTextArea.setText("");
        File f = null;
        FileInputStream fis = null;

        DataInputStream dis = null;
        String str = "";
        try {
            f = new File("AssignLawyers.bin");
            if (!f.exists()) {
                caseDetailsTextArea.setText("Oops something went wrong! AssignLawyers.bin binary file does not exist...!!!!!");
            } else {

                fis = new FileInputStream(f);

                dis = new DataInputStream(fis);

                

                while (dis.available() > 0) {
                    int currentCaseNumber = dis.readInt();
                    if (caseNumber == currentCaseNumber) {

                        str
                                += //"Case Number : " + Integer.toString(dis.readInt())
                                " Lawyer Name : " + dis.readUTF()
                                + "; Case Details : " + dis.readUTF() + "\n";
                        caseDetailsTextArea.setText(str);

                        
                    }else {
                        caseDetailsTextArea.setText("There is no existing case available with that Case Number");
                    }
                }
            }
        } catch (IOException ex) {
            caseDetailsTextArea.setText(str);
            Logger.getLogger(U2_CaseDetailsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(U2_CaseDetailsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void pDFGenerateOnClick(ActionEvent event) {
    }

    @FXML
    private void returnHomeOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("U2_LawyerDashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();
    }

}
