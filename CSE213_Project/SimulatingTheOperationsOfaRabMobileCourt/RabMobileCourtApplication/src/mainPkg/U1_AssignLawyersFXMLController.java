package mainPkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class U1_AssignLawyersFXMLController implements Initializable {

    @FXML
    private TextField caseNumberTextField;
    @FXML
    private ComboBox<String> lawyerNameComboBox;
    @FXML
    private TableView<U1_AssignLawyers> caseAndLaywerNameTableView;
    @FXML
    private TableColumn<U1_AssignLawyers, Integer> caseNumColumn;
    @FXML
    private TableColumn<U1_AssignLawyers, String> lawyerNameColumn;

    ObservableList<U1_AssignLawyers> assigns = FXCollections.observableArrayList();
    @FXML
    private Label showerrormessageLabel;
    @FXML
    private TableColumn<U1_AssignLawyers, String> caseDetailsColumn;
    @FXML
    private TextField caseDetailsTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lawyerNameComboBox.getItems().addAll("Nafiul Islam", "Nushrat Anika", "Jarin Afrin", "Opshora Hossain", "Tasmia Islam");
        caseNumColumn.setCellValueFactory(new PropertyValueFactory<U1_AssignLawyers, Integer>("caseNumber"));
        lawyerNameColumn.setCellValueFactory(new PropertyValueFactory<U1_AssignLawyers, String>("lawyerName"));
        caseDetailsColumn.setCellValueFactory(new PropertyValueFactory<U1_AssignLawyers, String>("caseDetails"));
    }

    @FXML
    private void savetoFileOnClick(ActionEvent event) {

        File f = null;
        FileOutputStream fos = null;

        DataOutputStream dos = null;

        try {
            f = new File("AssignLawyers.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
            } else {
                fos = new FileOutputStream(f);
            }

            dos = new DataOutputStream(fos);

            int caseNumber = Integer.parseInt(caseNumberTextField.getText());
            if (lawyerNameComboBox.getValue() != null && caseDetailsTextField.getText() != null) {
                dos.writeInt(caseNumber);
                dos.writeUTF(lawyerNameComboBox.getValue());
                dos.writeUTF(caseDetailsTextField.getText());
            } else {

                System.err.println("Something went wrong!!! Please check inputs.");
            }

        } catch (IOException e) {
            Logger.getLogger(U1_AssignLawyersFXMLController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                Logger.getLogger(U1_AssignLawyersFXMLController.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        caseNumberTextField.clear();
        caseDetailsTextField.clear();

    }

    @FXML
    private void returnHomeOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        FXMLLoader someLoader = new FXMLLoader(getClass().getResource("DistrictOfficerdashBoardFXML.fxml"));
        root = (Parent) someLoader.load();
        Scene someScene = new Scene(root);

        Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        someStage.setScene(someScene);
        someStage.show();

    }

    @FXML
    private void loadInTheTableButtonOnClick(ActionEvent event) {
        try {
            String caseNum = caseNumberTextField.getText();
            int caseNumber = Integer.parseInt(caseNum);
            String lawyer = lawyerNameComboBox.getValue();
            String caseDetails = caseDetailsTextField.getText();

            if (caseNumber <= 0) {
                throw new IllegalArgumentException("Case number must be a positive integer.");
            }
            if (lawyer == null || lawyer.isEmpty()) {
                throw new IllegalArgumentException("Require a Lawyer name.");
            }
            if (caseDetails.isEmpty()) {
                throw new IllegalArgumentException("Please write the Case details.");
            }

            U1_AssignLawyers assign = new U1_AssignLawyers(caseNumber, lawyer, caseDetails);
            assigns.add(assign);
            caseAndLaywerNameTableView.setItems(assigns);

            showerrormessageLabel.setText("");

        } //catch (NumberFormatException e) {showerrormessageLabel.setText("Invalid case number format. Please enter a valid integer.")} 
        catch (IllegalArgumentException e) {
            showerrormessageLabel.setText(e.getMessage());
        }
    }

}
