package mainPkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnalyzCrimActivSceneController implements Initializable {

    @FXML
    private TextField occAmountTextField;
    @FXML
    private TextField occYearTextField;
    @FXML
    private ComboBox<String> crimeTypeCB;
    @FXML
    private BarChart<String, Number> anaCriActBarChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private TextArea viewSavedInfoTextArea;
    @FXML
    private TextField inYrOfCriTextField;
    @FXML
    private Label outputLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crimeTypeCB.getItems().addAll("Food Adulteration", "Over-Priced", "Fake Products", "False Advertisement");

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>(); //mandatory for bar chart

    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @FXML
    private void saveActInfoButtonOnClick(ActionEvent event) {
        // Validate input
        if (!isInteger(occAmountTextField.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setHeaderText("Input Data Type Not Allowed");
            a.setContentText("Occurance Amount must be an integer!");
            a.showAndWait();
            return;
        }

        // Validate input
        if (!isInteger(occYearTextField.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setHeaderText("Input Data Type Not Allowed");
            a.setContentText("Occurance Year must be an integer for example 2023!");
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
                f = new File("CrimActivityObject.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                Criminal_Activity c = new Criminal_Activity(
                        Integer.parseInt(occAmountTextField.getText()),
                        Integer.parseInt(occYearTextField.getText()),
                        crimeTypeCB.getValue()
                );
                oos.writeObject(c);

            } catch (IOException ex) {
                Logger.getLogger(AnalyzCrimActivSceneController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AnalyzCrimActivSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            showInfoAlertAfterConfirmation("The data has been saved.");
        } else {
            //show appropriate cancellation message
            showInfoAlertAfterConfirmation("The Data was not saved!");
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
    private void viewSavedInfoButtonOnClick(ActionEvent event) {

        viewSavedInfoTextArea.setText("");
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CrimActivityObject.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            Criminal_Activity ca;
            try {
                viewSavedInfoTextArea.setText("");
                while (true) {
                    ca = (Criminal_Activity) ois.readObject();
                    System.out.println(ca.toString());
                    viewSavedInfoTextArea.appendText(ca.toString());
                }
            }//end of nested try//end of nested try//end of nested try//end of nested try
            catch (IOException | ClassNotFoundException e) {
                //
            }//nested catch     
            viewSavedInfoTextArea.appendText("All objects loaded successfully from bin file.\n");
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

    @FXML
    private void loadBarChartButtonOnClick(ActionEvent event) {
        // Clear existing data in the chart
        anaCriActBarChart.getData().clear();

        // Create a new series for the chart
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Initialize variables to store accumulated occurrences for each crime type
        int foodAdulterationOccurrences = 0;
        int overPricedOccurrences = 0;
        int fakeProductsOccurrences = 0;
        int falseAdvertisementOccurrences = 0;
        // Read data from the file and accumulate occurrences
        File f = new File("CrimActivityObject.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Criminal_Activity ca = (Criminal_Activity) ois.readObject();
                int occurrence = ca.getOccuranceAmount();

                // Accumulate occurrences based on crime type
                switch (ca.getCrimeType()) {
                    case "Food Adulteration":
                        foodAdulterationOccurrences += occurrence;
                        break;
                    case "Over-Priced":
                        overPricedOccurrences += occurrence;
                        break;
                    case "Fake Products":
                        fakeProductsOccurrences += occurrence;
                        break;
                    case "False Advertisement":
                        falseAdvertisementOccurrences += occurrence;
                        break;
                    // Add more cases for additional crime types if needed
                }
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AnalyzCrimActivSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Add accumulated values to the series
        series.getData().add(new XYChart.Data<>("Food Adulteration", foodAdulterationOccurrences));
        series.getData().add(new XYChart.Data<>("Over-Priced", overPricedOccurrences));
        series.getData().add(new XYChart.Data<>("Fake Products", fakeProductsOccurrences));
        series.getData().add(new XYChart.Data<>("False Advertisement", falseAdvertisementOccurrences));

        // Add the series to the chart
        anaCriActBarChart.getData().add(series);
    }

    @FXML
    private void viewMaxMinActButtonOnClick(ActionEvent event) {
        // Validate input
        if (!isInteger(inYrOfCriTextField.getText())) {
            showValidationErrorAlert("Year must be an integer!");
            return;
        }

        int yearToFind = Integer.parseInt(inYrOfCriTextField.getText());

        // Variables to store min and max occurrences
        int minOccurrence = Integer.MAX_VALUE;
        int maxOccurrence = Integer.MIN_VALUE;

        File f = new File("CrimActivityObject.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Criminal_Activity ca = (Criminal_Activity) ois.readObject();
                if (ca.getOccuranceYear() == yearToFind) {
                    int occurrence = ca.getOccuranceAmount();
                    // Update min and max occurrences
                    minOccurrence = Math.min(minOccurrence, occurrence);
                    maxOccurrence = Math.max(maxOccurrence, occurrence);
                }
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AnalyzCrimActivSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (minOccurrence == Integer.MAX_VALUE && maxOccurrence == Integer.MIN_VALUE) {
            // No data found for the specified year
            outputLabel.setText("No data found for the specified year.");
        } else {
            outputLabel.setText("Minimum Occurrence: " + minOccurrence + ", Maximum Occurrence: " + maxOccurrence);
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
}
