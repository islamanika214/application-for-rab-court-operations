/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class U1_CommandOperation {
    private String institutionName, location, urgencyReason;
    private LocalDate investigationDate;

    public U1_CommandOperation(String institutionName, String location, String urgencyReason, LocalDate investigationDate) {
        this.institutionName = institutionName;
        this.location = location;
        this.urgencyReason = urgencyReason;
        this.investigationDate = investigationDate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getLocation() {
        return location;
    }

    public String getUrgencyReason() {
        return urgencyReason;
    }

    public LocalDate getInvestigationDate() {
        return investigationDate;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUrgencyReason(String urgencyReason) {
        this.urgencyReason = urgencyReason;
    }

    public void setInvestigationDate(LocalDate investigationDate) {
        this.investigationDate = investigationDate;
    }

    @Override
    public String toString() {
        return "U1_CommandOperation{" + "institutionName=" + institutionName + ", location=" + location + ", urgencyReason=" + urgencyReason + ", investigationDate=" + investigationDate + '}';
    }

    

    
    
    
}
