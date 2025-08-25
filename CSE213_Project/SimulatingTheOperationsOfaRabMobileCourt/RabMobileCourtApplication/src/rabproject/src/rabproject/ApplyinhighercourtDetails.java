
package rabproject;

import java.time.LocalDate;


public class ApplyinhighercourtDetails {
    int caseId;
    LocalDate date;
    String caseTitle,details,time;

    public ApplyinhighercourtDetails(int caseId, LocalDate date, String caseTitle, String details, String time) {
        this.caseId = caseId;
        this.date = date;
        this.caseTitle = caseTitle;
        this.details = details;
        this.time = time;
    }
    
}
