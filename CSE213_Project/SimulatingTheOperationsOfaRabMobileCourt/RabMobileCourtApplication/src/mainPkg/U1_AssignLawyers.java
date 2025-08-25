/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author Anika
 */
public class U1_AssignLawyers {
    private int caseNumber;
    private String lawyerName, caseDetails;

    public U1_AssignLawyers(int caseNumber, String lawyerName, String caseDetails) {
        this.caseNumber = caseNumber;
        this.lawyerName = lawyerName;
        this.caseDetails = caseDetails;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public String getCaseDetails() {
        return caseDetails;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    public void setCaseDetails(String caseDetails) {
        this.caseDetails = caseDetails;
    }

    @Override
    public String toString() {
        return "U1_AssignLawyers{" + "caseNumber=" + caseNumber + ", lawyerName=" + lawyerName + ", caseDetails=" + caseDetails + '}';
    }

    
    
    
    
    
    
}
