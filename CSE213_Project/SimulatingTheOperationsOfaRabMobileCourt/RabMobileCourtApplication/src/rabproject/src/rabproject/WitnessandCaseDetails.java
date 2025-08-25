package rabproject;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.scene.control.cell.PropertyValueFactory;

public class WitnessandCaseDetails implements Serializable {

    int caseId;
    LocalDate date;
    String caseTitle, details, evidences, witness, time;



    public WitnessandCaseDetails(int caseId, LocalDate date, String time, String caseTitle, String details, String evidences, String witness) {
        this.caseId = caseId;
        this.date = date;
        this.time = time;
        this.caseTitle = caseTitle;
        this.details = details;
        this.evidences = evidences;
        this.witness = witness;
    }

   

}
