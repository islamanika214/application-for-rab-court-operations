package rabproject;

import java.time.LocalDate;

public class CaseDetails {

    int caseId,NID,phone;
    LocalDate date;
    String caseTitle,CaseDetails,NameOfConvict,Address,FatherName,MotherName,time;

    public CaseDetails(int caseId, int NID, int phone, LocalDate date, String caseTitle, String CaseDetails, String NameOfConvict, String Address, String FatherName, String MotherName, String time) {
        this.caseId = caseId;
        this.NID = NID;
        this.phone = phone;
        this.date = date;
        this.caseTitle = caseTitle;
        this.CaseDetails = CaseDetails;
        this.NameOfConvict = NameOfConvict;
        this.Address = Address;
        this.FatherName = FatherName;
        this.MotherName = MotherName;
        this.time = time;
    }


}
