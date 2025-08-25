package rabproject;

import java.time.LocalDate;

public class OperationbDetails {

    int caseId;
    LocalDate date;

    String caseTitle, districtofficer, assignedofficer, magistrate, lawyer, place, time;

    public OperationbDetails(int caseId, LocalDate date, String caseTitle, String districtofficer, String assignedofficer, String magistrate, String lawyer, String place, String time) {
        if (caseId < 0)
            throw new IllegalArgumentException("wrong ID");
        this.caseId = caseId;
        this.date = date;
        this.caseTitle = caseTitle;
        this.districtofficer = districtofficer;
        this.assignedofficer = assignedofficer;
        this.magistrate = magistrate;
        this.lawyer = lawyer;
        this.place = place;
        this.time = time;
    }

}
