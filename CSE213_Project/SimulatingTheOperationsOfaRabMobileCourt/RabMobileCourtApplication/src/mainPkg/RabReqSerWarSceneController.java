package mainPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RabReqSerWarSceneController implements Initializable {

    @FXML
    private ComboBox<String> typeOfInstiComboBox;
    @FXML
    private TextField nameOfInstiTextField;
    @FXML
    private DatePicker propDateOfSerDatePicker;
    @FXML
    private TextArea reasForSerTextArea;
    @FXML
    private TextField serWarIdTextField;
    @FXML
    private TextField badgeNumTextField;
    @FXML
    private TextArea showSavedInfoTextArea;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeOfInstiComboBox.getItems().addAll("Educational", "Restaurant", "General Store", "Cosmetic Shop", "Other");
    }

    @FXML
    private void saveWarInfoButtonOnClick(ActionEvent event) {

        // Validate input for serWarIdTextField
        if (!isInteger(serWarIdTextField.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setHeaderText("Input Data Type Not Allowed");
            a.setContentText("Warrant ID must be an integer!");
            a.showAndWait();
            return;
        }

        // Validate input for badgeNumTextField
        if (!isInteger(badgeNumTextField.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setHeaderText("Input Data Type Not Allowed");
            a.setContentText("Officer Badge Number must be an integer!");
            a.showAndWait();
            return;
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setContentText("Please select Ok to confirm! Otherwise Cancel");

        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {

            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                f = new File("SerWarObjects.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                Search_Warrant e = new Search_Warrant(
                        Integer.parseInt(serWarIdTextField.getText()),
                        nameOfInstiTextField.getText(),
                        typeOfInstiComboBox.getValue(),
                        Integer.parseInt(badgeNumTextField.getText()),
                        propDateOfSerDatePicker.getValue(),
                        reasForSerTextArea.getText()
                );
                oos.writeObject(e);

            } catch (IOException ex) {
                Logger.getLogger(RabReqSerWarSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(RabReqSerWarSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            showInfoAlertAfterConfirmation("The data has been saved.");
        } else {
            //show appropriate cancellation message
            showInfoAlertAfterConfirmation("The Data was not saved!");
        }

    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showInfoAlertAfterConfirmation(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setContentText(str);
        a.showAndWait();
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RabOfficerDashScene.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
    }

    @FXML
    private void showSavedInfoButtonOnClick(ActionEvent event) {

        showSavedInfoTextArea.setText("");
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("SerWarObjects.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Search_Warrant sw;
            try {
                showSavedInfoTextArea.setText("");
                while (true) {
                    sw = (Search_Warrant) ois.readObject();
                    System.out.println(sw.toString());
                    showSavedInfoTextArea.appendText(sw.toString());
                }
            }//end of nested try//end of nested try
            catch (IOException | ClassNotFoundException e) {
                //
            }//nested catch     
            showSavedInfoTextArea.appendText("All objects loaded successfully from bin file.\n");
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
    }

}
