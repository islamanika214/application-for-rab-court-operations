
package rabproject;

import java.time.LocalDate;


public class HirelawyerDetails {
    
    int caseId;
    LocalDate date;
    String caseTitle,details,time,lawyername;

    public HirelawyerDetails(int caseId, LocalDate date, String caseTitle, String details, String time, String lawyername) {
        this.caseId = caseId;
        this.date = date;
        this.caseTitle = caseTitle;
        this.details = details;
        this.time = time;
        this.lawyername = lawyername;
    }


    
}
