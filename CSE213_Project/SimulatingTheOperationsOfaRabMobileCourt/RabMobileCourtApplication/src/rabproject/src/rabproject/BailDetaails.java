
package rabproject;

import java.io.Serializable;
import java.time.LocalDate;


public class BailDetaails implements Serializable{
    
    int caseId,nid;
    LocalDate date;
    String name,caseTitle,details,evidences,witness, time;

    public BailDetaails(int caseId, int nid, LocalDate date, String time, String name, String caseTitle, String details, String evidences, String witness) {
        this.caseId = caseId;
        this.nid = nid;
        this.date = date;
        this.time = time;
        this.name = name;
        this.caseTitle = caseTitle;
        this.details = details;
        this.evidences = evidences;
        this.witness = witness;
    }

 
    
    
}
