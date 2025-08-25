
package mainPkg;

import java.time.LocalDate;


public class U1_NewOperation {
    private String institutionName , location, numberOfOfficer, magistrateName;
    private LocalDate operationDate;

    public U1_NewOperation(String institutionName, String location, String numberOfOfficer, String magistrateName, LocalDate operationDate) {
        this.institutionName = institutionName;
        this.location = location;
        this.numberOfOfficer = numberOfOfficer;
        this.magistrateName = magistrateName;
        this.operationDate = operationDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getLocation() {
        return location;
    }

    public String getNumberOfOfficer() {
        return numberOfOfficer;
    }

    public String getMagistrateName() {
        return magistrateName;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfOfficer(String numberOfOfficer) {
        this.numberOfOfficer = numberOfOfficer;
    }

    public void setMagistrateName(String magistrateName) {
        this.magistrateName = magistrateName;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "U1_NewOperation{" + "institutionName=" + institutionName + ", location=" + location + ", numberOfOfficer=" + numberOfOfficer + ", magistrateName=" + magistrateName + ", operationDate=" + operationDate + '}';
    }

    

    
    
    
    
}
