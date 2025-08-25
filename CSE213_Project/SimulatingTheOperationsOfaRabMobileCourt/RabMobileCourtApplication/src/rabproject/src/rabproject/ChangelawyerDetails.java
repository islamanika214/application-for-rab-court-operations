
package rabproject;

import java.time.LocalDate;


public class ChangelawyerDetails {
    int caseId;
    LocalDate date;
    String caseTitle,details,time,lawyer;

    public ChangelawyerDetails(int caseId, LocalDate date, String caseTitle, String details, String time, String lawyer) {
        this.caseId = caseId;
        this.date = date;
        this.caseTitle = caseTitle;
        this.details = details;
        this.time = time;
        this.lawyer = lawyer;
    }
}
