/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
public class U7_Scheedule_Meeting_Scene2Controller implements Initializable {

    @FXML
    private TableView<U7_Schedule_Meeting> scheeduleMeetingTableView;
    @FXML
    private TableColumn<U7_Schedule_Meeting, String> meetingIdCol;
    @FXML
    private TableColumn<U7_Schedule_Meeting, LocalDate> dateCol;
    @FXML
    private TableColumn<U7_Schedule_Meeting, String> timeCol;
    @FXML
    private TableColumn<U7_Schedule_Meeting, String> participantsCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        meetingIdCol.setCellValueFactory(new PropertyValueFactory<>("meetingId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("meetingDate"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("MeetingTime"));
        participantsCol.setCellValueFactory(new PropertyValueFactory<>("participant"));
        
        scheeduleMeetingTableView.setItems(U7_Scheedule_meeting_Scene1Controller.scheduleMeetingList);
    }    

    @FXML
    private void backDashBoardOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("U7_Operations_Administrator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));

    }

    @FXML
    private void signOutOnClick(ActionEvent event) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("U8_Undercover_Investigator_DashBoard.fxml"));
        Parent secondRoot=loader.load();
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(secondRoot));
        */

    }
    
}
