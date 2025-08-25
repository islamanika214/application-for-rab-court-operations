package rabproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HirelawyerController implements Initializable {

    @FXML
    private TextField caseid;
    @FXML
    private TextField casetitle;
    @FXML
    private TextField casedetails;
    @FXML
    private TextField time;
    @FXML
    private ComboBox<String> lawyercombo;
    @FXML
    private TableColumn<HirelawyerDetails, String> caseidcol;
    @FXML
    private TableColumn<HirelawyerDetails, String> casetitlecol;
    @FXML
    private TableColumn<HirelawyerDetails, String> casedetailscol;
    @FXML
    private TableColumn<HirelawyerDetails, String> timecol;
    @FXML
    private TableColumn<HirelawyerDetails, LocalDate> datecol;
    @FXML
    private TableColumn<HirelawyerDetails, String> lawyercol;
    @FXML
    private DatePicker localdate;
    ObservableList<HirelawyerDetails> HirelawyerList = FXCollections.observableArrayList();
    @FXML
    private TableView<HirelawyerDetails> lawyertable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        caseidcol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, String>("caseid"));
        casetitlecol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, String>("casetitle"));
        casedetailscol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, String>("casedetails"));
        timecol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, String>("time"));
        datecol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, LocalDate>("date"));
        lawyercol.setCellValueFactory(new PropertyValueFactory<HirelawyerDetails, String>("lawyer"));
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("HireLawyer.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            HirelawyerDetails hld;
            try {
                while (true) {
                    hld = (HirelawyerDetails) ois.readObject();
                    HirelawyerList.add(hld);
                    System.out.println(hld.toString());
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }

        }
        lawyertable.setItems(HirelawyerList);
    }

    @FXML
    private void dismisslawyereonaction(ActionEvent event) {

    }

    @FXML
    private void addlawyeronactiopn(ActionEvent event) {

        // Validate input before creating HirelawyerDetails instance
        String caseIdText = caseid.getText();

        if (isValidCaseId(caseIdText)) {
            try {
                HirelawyerDetails hld = new HirelawyerDetails(
                        Integer.parseInt(caseIdText),
                        localdate.getValue(),
                        casetitle.getText(),
                        casedetails.getText(),
                        time.getText(),
                        lawyercombo.getValue()
                );
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                File f = null;
                try {
                    f = new File("HireLawyer.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }

                    oos.writeObject(hld);
                    HirelawyerList.add(hld);
                    System.out.println("write object sucessfull ");

                } catch (IOException ex) {
                    Logger.getLogger(HirelawyerController.class
                            .getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (oos != null) {
                            oos.close();

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(BailpapersController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lawyer Hired");

                // Show the alert
                alert.showAndWait();

                // Use the hld instance as needed
                System.out.println("Hire Lawyer Details submitted: " + hld);

            } catch (NumberFormatException e) {
                System.out.println("Error parsing Case ID to integer.");
            }
        } else {
            System.out.println("Invalid Case ID. Please enter a non-empty numeric value.");
        }

    }

    private boolean isValidCaseId(String caseIdText) {
        return !caseIdText.isEmpty() && caseIdText.matches("\\d+");
    }
}
