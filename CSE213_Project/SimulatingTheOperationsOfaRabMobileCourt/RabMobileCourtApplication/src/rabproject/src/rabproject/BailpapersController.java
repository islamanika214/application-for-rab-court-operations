/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Shakib
 */
public class BailpapersController implements Initializable {

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
    @FXML
    private TextField evidences;
    @FXML
    private TextField witness;
    @FXML
    private TableColumn<BailDetaails, String> casaeidcol;
    @FXML
    private TableColumn<BailDetaails, String> casetitlecol;
    @FXML
    private TableColumn<BailDetaails, String> casedetalscol;
    @FXML
    private TableColumn<BailDetaails, String> timecol;
    @FXML
    private TableColumn<BailDetaails, LocalDate> datecol;
    @FXML
    private TableColumn<BailDetaails, String> evidencescol;
    @FXML
    private TableColumn<BailDetaails, String> witnesscol;
    @FXML
    private TableColumn<BailDetaails, String> namecol;
    @FXML
    private TableColumn<BailDetaails, Integer> nidcol;
    @FXML
    private TextField name;
    @FXML
    private TextField nid;
    @FXML
    private TableView<BailDetaails> bailtable;
    ObservableList<BailDetaails> bailList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        casaeidcol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("caseid"));
        casetitlecol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("casetitle"));
        casedetalscol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("casedetals"));
        timecol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("time"));
        datecol.setCellValueFactory(new PropertyValueFactory<BailDetaails, LocalDate>("date"));
        evidencescol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("evidences"));
        witnesscol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("witness"));
        namecol.setCellValueFactory(new PropertyValueFactory<BailDetaails, String>("name"));
        nidcol.setCellValueFactory(new PropertyValueFactory<BailDetaails, Integer>("nid"));
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Bailapplication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            BailDetaails bd;
            try {
                while (true) {
                    bd = (BailDetaails) ois.readObject();
                    bailList.add(bd);
                    System.out.println(bd.toString());
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
        bailtable.setItems(bailList);

    }

    @FXML
    private void applyforbailonclick(ActionEvent event) {
        // Validate input before creating BailDetaails instance
        String caseIdText = caseid.getText();
        String nidText = nid.getText();

        if (isValidCaseId(caseIdText) && isValidNID(nidText)) {
            try {
                BailDetaails bd = new BailDetaails(
                        Integer.parseInt(caseIdText),
                        Integer.parseInt(nidText),
                        date.getValue(),
                        time.getText(),
                        name.getText(),
                        casetitle.getText(),
                        casedetails.getText(),
                        evidences.getText(),
                        witness.getText()
                );
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;
                File f = null;
                try {
                    f = new File("Bailapplication.bin");
                    if (f.exists()) {
                        fos = new FileOutputStream(f, true);
                        oos = new AppendableObjectOutputStream(fos);
                    } else {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                    }

                    oos.writeObject(bd);
                    bailList.add(bd);
                    System.out.println("write object sucessfull ");

                } catch (IOException ex) {
                    Logger.getLogger(BailpapersController.class
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
                alert.setTitle("Bail Paper Added");

                // Show the alert
                alert.showAndWait();

                // Use the bd instance as needed
                System.out.println("Bail Details submitted: " + bd);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing Case ID or NID to integer.");
            }
        } else {
            System.out.println("Invalid Case ID or NID. Please enter non-empty numeric values.");
        }

    }

    private boolean isValidNID(String nidText) {
        return !nidText.isEmpty() && nidText.matches("\\d+");
    }

    private boolean isValidCaseId(String caseIdText) {
        return !caseIdText.isEmpty() && caseIdText.matches("\\d+");
    }

}
