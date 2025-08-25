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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimetableofoperationsController implements Initializable {

    @FXML
    private TextField caseid;
    @FXML
    private TextField lawyer;
    @FXML
    private TextField casetitle;
    @FXML
    private TextField districtofficer;
    @FXML
    private TextField assignedofficer;
    @FXML
    private TextField magistrate;
    @FXML
    private TextField place;
    @FXML
    private DatePicker date;
    @FXML
    private TextField time;
    @FXML
    private TableView<OperationbDetails> table;
    @FXML
    private TableColumn<OperationbDetails, Integer> caseidcol;
    @FXML
    private TableColumn<OperationbDetails, String> casetitlecol;
    @FXML
    private TableColumn<OperationbDetails, String> districtofficercol;
    @FXML
    private TableColumn<OperationbDetails, String> assignedofficercol;
    @FXML
    private TableColumn<OperationbDetails, String> magistratecol;
    @FXML
    private TableColumn<OperationbDetails, String> lawyercol;
    @FXML
    private TableColumn<OperationbDetails, String> placecol;
    @FXML
    private TableColumn<OperationbDetails, LocalDate> datecol;
    @FXML
    private TableColumn<OperationbDetails, String> timecol;
    ObservableList<OperationbDetails> odList = FXCollections.observableArrayList(); // operationDetailsList

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        columnFxid.setCellValueFactory(new PropertyValueFactory<ModelClass, Type>("ModelcCassFieldName"));
        caseidcol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, Integer>("caseId"));
        casetitlecol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("caseTitle"));
        districtofficercol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("districtofficer"));
        assignedofficercol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("assignedofficer"));
        magistratecol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("magistrate"));
        lawyercol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("lawyer"));
        placecol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("place"));
        datecol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, LocalDate>("date"));
        timecol.setCellValueFactory(new PropertyValueFactory<OperationbDetails, String>("String"));
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Operations.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OperationbDetails opd;
            try {
                while (true) {
                    opd = (OperationbDetails) ois.readObject();
                    odList.add(opd);
                    System.out.println(opd.toString());
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
        table.setItems(odList);

    }

    @FXML
    private void addoperationonaction(ActionEvent event) {
        String caseIdText = caseid.getText();
        if (isValidCaseId(caseIdText)) {
            try {
                OperationbDetails opd = new OperationbDetails(
                        Integer.parseInt(caseIdText),
                        date.getValue(),
                        casetitle.getText(),
                        districtofficer.getText(),
                        assignedofficer.getText(),
                        magistrate.getText(),
                        lawyer.getText(),
                        place.getText(),
                        time.getText()
                );
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                File f = null;
                try {
                    f = new File("Operations.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }

                    oos.writeObject(opd);
                    odList.add(opd);
                    System.out.println("write object sucessfull ");

                } catch (IOException ex) {
                    Logger.getLogger(TimetableofoperationsController.class
                            .getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (oos != null) {
                            oos.close();

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(TimetableofoperationsController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }

                // Use the opd instance as needed
                System.out.println("Operation Details submitted: " + opd);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing Case ID to integer.");
            }
        } else {
            System.out.println("Invalid Case ID. Please enter a non-empty numeric value.");
        }

        //return;
    }

    private boolean isValidCaseId(String caseIdText) {
        return !caseIdText.isEmpty() && caseIdText.matches("\\d+");
    }
}
