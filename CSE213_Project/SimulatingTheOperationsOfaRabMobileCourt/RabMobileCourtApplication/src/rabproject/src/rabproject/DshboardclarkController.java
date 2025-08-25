package rabproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DshboardclarkController implements Initializable {

    @FXML
    private Label nameofconvict;
    @FXML
    private Label nid;
    @FXML
    private TextField fathername;
    @FXML
    private TextField mothername;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextField caseid;
    @FXML
    private TextField casetitle;
    @FXML
    private TextField casedetails;
    @FXML
    private TextField time;
    @FXML
    private DatePicker date;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }


    @FXML
    private void RegisterCase(ActionEvent event) {
        // Validate input before creating CaseDetails instance
        String caseIdText = caseid.getText();
        String nidText = nid.getText();
        String phoneText = phone.getText();

        if (isValidCaseId(caseIdText) && isValidNID(nidText) && isValidPhone(phoneText)) {
            try {
                CaseDetails cd = new CaseDetails(
                        Integer.parseInt(caseIdText),
                        Integer.parseInt(nidText),
                        Integer.parseInt(phoneText),
                        date.getValue(),
                        casetitle.getText(),
                        casedetails.getText(),
                        nameofconvict.getText(),
                        address.getText(),
                        fathername.getText(),
                        mothername.getText(),
                        time.getText()
                );
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                File f = null;
                try {
                    f = new File("Cases.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }

                    oos.writeObject(cd);
                    System.out.println("write object sucessfull ");

                } catch (IOException ex) {
                    Logger.getLogger(DshboardclarkController.class
                            .getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (oos != null) {
                            oos.close();

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(DshboardclarkController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }

                // Use the cd instance as needed
                System.out.println("Case Details submitted: " + cd);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing Case ID, NID, or Phone to integer.");
            }
        } else {
            System.out.println("Invalid Case ID, NID, or Phone. Please enter non-empty numeric values.");
        }

//         write code for victine add
    }

    private boolean isValidCaseId(String caseIdText) {
        return !caseIdText.isEmpty() && caseIdText.matches("\\d+");
    }

    private boolean isValidNID(String nidText) {
        return !nidText.isEmpty() && nidText.matches("\\d+");
    }

    private boolean isValidPhone(String phoneText) {
        return !phoneText.isEmpty() && phoneText.matches("\\d+");
    }

    @FXML
    private void operationToBeonductedOnclick(ActionEvent event) throws IOException {

        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("timetableofoperations.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();

    }

    @FXML
    private void witnessandcasedetailsonclick(ActionEvent event) throws IOException {

        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("witnessandcasedetails.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

  //  @FXML
  //  private void generatepdfonclick(ActionEvent event) {

  //  }

    @FXML
    private void bailapplicationonclick(ActionEvent event) throws IOException {

        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("bailpapers.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

}
