/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author Hamida
 */
public class U8_Emergency_Alert {
    private String emergancyAlertId;
    private String institutionName;
    private String institutionLocation;
    private String alertReciever;
    private String description;

    public U8_Emergency_Alert() {
    }

    public U8_Emergency_Alert(String emergancyAlertId, String institutionName, String institutionLocation, String alertReciever, String description) {
        this.emergancyAlertId = emergancyAlertId;
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
        this.alertReciever = alertReciever;
        this.description = description;
    }

    public String getEmergancyAlertId() {
        return emergancyAlertId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public String getAlertReciever() {
        return alertReciever;
    }

    public String getDescription() {
        return description;
    }

    public void setEmergancyAlertId(String emergancyAlertId) {
        this.emergancyAlertId = emergancyAlertId;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setInstitutionLocation(String institutionLocation) {
        this.institutionLocation = institutionLocation;
    }

    public void setAlertReciever(String alertReciever) {
        this.alertReciever = alertReciever;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "emergancyAlertId : " + emergancyAlertId + ", \n institutionName : " + institutionName + ", \ninstitutionLocation : " + institutionLocation + 
                ", \nalertReciever : " + alertReciever + ", \ndescription : " + description + "\n-----------------------\n";
    }
    
    
    
    
    
    
    
}
