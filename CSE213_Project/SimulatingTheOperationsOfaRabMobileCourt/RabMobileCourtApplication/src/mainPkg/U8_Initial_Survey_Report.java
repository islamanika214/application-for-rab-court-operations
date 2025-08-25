/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

import java.time.LocalDate;

/**
 *
 * @author Hamida
 */
public class U8_Initial_Survey_Report {
    private String initialSurveyId;
    private String institutionName;
    private String institutionLocation;
    private LocalDate initialSurveyDate;
    private String description;

    public U8_Initial_Survey_Report() {
    }

    public U8_Initial_Survey_Report(String initialSurveyId, String institutionName, String institutionLocation, LocalDate initialSurveyDate, String description) {
        this.initialSurveyId = initialSurveyId;
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
        this.initialSurveyDate = initialSurveyDate;
        this.description = description;
    }

    

    public String getInitialSurveyId() {
        return initialSurveyId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public LocalDate getInitialSurveyDate() {
        return initialSurveyDate;
    }

    public String getDescription() {
        return description;
    }
    

    public void setInitialSurveyId(String initialSurveyId) {
        this.initialSurveyId = initialSurveyId;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setInstitutionLocation(String institutionLocation) {
        this.institutionLocation = institutionLocation;
    }

    public void setInitialSurveyDate(LocalDate initialSurveyDate) {
        this.initialSurveyDate = initialSurveyDate;
        
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "initialSurveyId : " + initialSurveyId + 
                ", \n institutionName : " + institutionName + ",  institutionLocation : " + institutionLocation + 
                ",   initialSurveyDate  : " + initialSurveyDate + ", \n Suspecious Activities: \n" + description + "\n------------------------------\n";
    }
    

    
    
    
    
}
