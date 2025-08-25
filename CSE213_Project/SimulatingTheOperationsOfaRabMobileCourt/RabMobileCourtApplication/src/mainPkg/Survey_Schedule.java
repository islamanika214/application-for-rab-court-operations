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
public class Survey_Schedule {
    private String surveyId;
    private String institutionName;
    private String institutionLocation;
    private LocalDate surveyDate;

    public Survey_Schedule() {
    }

    public Survey_Schedule(String surveyId, String institutionName, String institutionLocation, LocalDate surveyDate) {
        this.surveyId = surveyId;
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
        this.surveyDate = surveyDate;
    }
    
    
    
    public String getSurveyId() {
        return surveyId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public LocalDate getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setInstitutionLocation(String institutionLocation) {
        this.institutionLocation = institutionLocation;
    }

    public void setSurveyDate(LocalDate surveyDate) {
        this.surveyDate = surveyDate;
    }

    @Override
    public String toString() {
        return "surveyId : " + surveyId + ", institutionName : " + institutionName + 
                ", institutionLocation : " + institutionLocation + ", surveyDate : " + surveyDate + "\n";
    }
    
    
    
}
