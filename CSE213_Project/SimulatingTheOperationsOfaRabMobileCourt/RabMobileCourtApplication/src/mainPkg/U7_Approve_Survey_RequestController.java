/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamida
 */
public class U7_Approve_Survey_RequestController implements Initializable {

    @FXML
    private TableView<U8_Survey_Request> initialSurveyRequestTableView;
    @FXML
    private TableColumn<U8_Survey_Request, String> investigatorIdCol;
    @FXML
    private TableColumn<U8_Survey_Request, String> instituionNameCol;
    @FXML
    private TableColumn<U8_Survey_Request, String> institutionLocationCol;
    @FXML
    private TableColumn<U8_Survey_Request, LocalDate> surveyDate;
    @FXML
    private TableColumn<U8_Survey_Request, String> surveyDetails;

    ObservableList<U8_Survey_Request> surveyRequestList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        investigatorIdCol.setCellValueFactory(new PropertyValueFactory<>("investigatorId"));
        instituionNameCol.setCellValueFactory(new PropertyValueFactory<>("institutionName"));
        institutionLocationCol.setCellValueFactory(new PropertyValueFactory<>("institutionLocation"));
        surveyDate.setCellValueFactory(new PropertyValueFactory<>("surveyDate"));
        surveyDetails.setCellValueFactory(new PropertyValueFactory<>("surveyDetails"));

        try {
            String fileName = "User8_All_File" + "//Request_Initial_Survey" + "//initsuvey.txt";
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File Doesnt Exists");
                return;
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] part = sc.nextLine().split("#");
                U8_Survey_Request surveyRequest = new U8_Survey_Request(part[0], part[1], part[2], LocalDate.parse(part[3]), part[4]);
                System.out.println(surveyRequest);
                surveyRequestList.add(surveyRequest);

            }

        } catch (Exception e) {

        }
        System.out.println(surveyRequestList);
        initialSurveyRequestTableView.setItems(surveyRequestList);

    }

    @FXML
    private void approveSurveyRequestOnClick(ActionEvent event) {
    }

    @FXML
    private void rejectSurveyRequestOnClick(ActionEvent event) {
    }

    @FXML
    private void backToDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));

    }

}
