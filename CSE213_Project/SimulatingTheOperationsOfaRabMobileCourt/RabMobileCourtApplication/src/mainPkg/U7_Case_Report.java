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
public class U7_Case_Report {
    private String caseReportId;
    private LocalDate reportDate;
    private String description;

    public U7_Case_Report() {
    }

    public U7_Case_Report(String caseReportId, LocalDate reportDate, String description) {
        this.caseReportId = caseReportId;
        this.reportDate = reportDate;
        this.description = description;
    }

    public String getCaseReportId() {
        return caseReportId;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public String getDescription() {
        return description;
    }

    public void setCaseReportId(String caseReportId) {
        this.caseReportId = caseReportId;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "caseReportId : " + caseReportId + ", reportDate : " + reportDate + 
                ",\n Case Report Details : \n" + description ;
    }

    
    
    
    
    
}
