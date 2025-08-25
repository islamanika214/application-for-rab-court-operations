/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author Hamida
 */
public class U8_Survey_Report {
    private String surveyId;
    private String institutionName;
    private String surveyDetails;

    public U8_Survey_Report() {
    }

    public U8_Survey_Report(String surveyId, String institutionName, String surveyDetails) {
        this.surveyId = surveyId;
        this.institutionName = institutionName;
        this.surveyDetails = surveyDetails;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getSurveyDetails() {
        return surveyDetails;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setSurveyDetails(String surveyDetails) {
        this.surveyDetails = surveyDetails;
    }

    @Override
    public String toString() {
        return "surveyId: " + surveyId + 
                ", institutionName : " + institutionName + "\n"+
                ", surveyDetails \n" + surveyDetails ;
    }
    
    
    
    
    
    
    
}
