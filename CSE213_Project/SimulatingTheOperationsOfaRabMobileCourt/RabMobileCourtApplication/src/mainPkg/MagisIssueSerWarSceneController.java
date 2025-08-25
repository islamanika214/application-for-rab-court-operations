package mainPkg;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MagisIssueSerWarSceneController implements Initializable {

    @FXML
    private TableView<Search_Warrant> warReqTable;
    @FXML
    private TableColumn<Search_Warrant, Integer> warIdCol;
    @FXML
    private TableColumn<Search_Warrant, String> nameInstCol;
    @FXML
    private TableColumn<Search_Warrant, String> typeInstCol;
    @FXML
    private TableColumn<Search_Warrant, LocalDate> propDateOfSerCol;
    @FXML
    private TableColumn<Search_Warrant, Integer> badgeNumCol;
    @FXML
    private TableColumn<Search_Warrant, String> serReasCol;
    @FXML
    private TextField warIdTextField;
    @FXML
    private TextField instiNameTextField;
    @FXML
    private TextField rabOffiIdTextField;
    @FXML
    private TextField numOfSubTextField;
    @FXML
    private TextField usersNameTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextArea viewDraftTextArea;

    private Issued_Warrant draftWarrant;

    @FXML
    private ComboBox<String> intiTypeCB;
    @FXML
    private DatePicker fromDatePicker;
    @FXML
    private DatePicker toDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        warIdCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, Integer>("warrantId"));
        nameInstCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, String>("institutionName"));
        typeInstCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, String>("institutionType"));
        propDateOfSerCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, LocalDate>("searchDate"));
        badgeNumCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, Integer>("badgeNumber"));
        serReasCol.setCellValueFactory(new PropertyValueFactory<Search_Warrant, String>("reasonForSearch"));

        intiTypeCB.getItems().addAll("Educational", "Restaurant", "General Store", "Cosmetic Shop", "Other");

    }

    @FXML
    private void loadWarReqButtonOnClick(ActionEvent event) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("SerWarObjects.bin"));
            while (true) {
                Search_Warrant s = (Search_Warrant) ois.readObject();
                if (s == null) {
                    break; // Exit the loop when the end of the file is reached
                }
                warReqTable.getItems().add(s);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MagistrateDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void viewDraftButtonOnClick(ActionEvent event) {
        // Validate that usersNameTextField and datePicker are not empty
        if (usersNameTextField.getText().isEmpty() || datePicker.getValue() == null) {
            showValidationErrorAlert("Please enter a User Name and Date as Signeture.");
            return; // Stop execution if validation fails
        }

        // Initialize the draftWarrant variable
        draftWarrant = new Issued_Warrant(
                Integer.parseInt(warIdTextField.getText()),
                Integer.parseInt(rabOffiIdTextField.getText()),
                instiNameTextField.getText(),
                Integer.parseInt(numOfSubTextField.getText()),
                usersNameTextField.getText(),
                datePicker.getValue());

        viewDraftTextArea.setText(draftWarrant.toString());
    }

    @FXML
    private void issueWarButtonOnClick(ActionEvent event) {

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setContentText("Please select Ok to confirm! Otherwise Cancel");

        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {

            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                if (draftWarrant != null) {
                    f = new File("IssuedWarrantObjects.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }
                    oos.writeObject(draftWarrant);
                } else {
                    showInfoAlertAfterConfirmation("Draft Warrant is null. Please generate it before issuing.");
                }

            } catch (IOException ex) {
                Logger.getLogger(MagisIssueSerWarSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MagisIssueSerWarSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            showInfoAlertAfterConfirmation("The Data was not saved!");
        }
    }

    private void showInfoAlertAfterConfirmation(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setContentText(str);
        a.showAndWait();
    }

    private void showValidationErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void loadSpecificWarButtonOnClick(ActionEvent event) {

        String selectedType = intiTypeCB.getSelectionModel().getSelectedItem();

        warReqTable.getItems().clear();

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("SerWarObjects.bin"));
            while (true) {
                Search_Warrant s = (Search_Warrant) ois.readObject();
                if (s == null) {
                    break;
                }
                if (s.getInstitutionType().equals(selectedType)) {
                    warReqTable.getItems().add(s);
                }
            }
        } catch (EOFException e) {

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void loadSpecificDateWarButtonOnClick(ActionEvent event) {
        LocalDate fromDate = fromDatePicker.getValue();
        LocalDate toDate = toDatePicker.getValue();

        if (fromDate == null || toDate == null) {
            showValidationErrorAlert("Please select both From and To dates.");
            return;
        }

        warReqTable.getItems().clear();

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("SerWarObjects.bin"));
            while (true) {
                Search_Warrant s = (Search_Warrant) ois.readObject();
                if (s == null) {
                    break;
                }
                LocalDate searchDate = s.getSearchDate();

                if (searchDate.isAfter(fromDate.minusDays(1)) && searchDate.isBefore(toDate.plusDays(1))) {
                    warReqTable.getItems().add(s);
                }
            }
        } catch (EOFException e) {

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
