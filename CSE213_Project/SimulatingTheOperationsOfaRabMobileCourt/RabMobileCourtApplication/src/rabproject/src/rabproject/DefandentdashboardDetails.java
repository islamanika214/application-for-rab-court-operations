
package rabproject;

import java.time.LocalDate;


public class DefandentdashboardDetails {
    int NID,phone;
    LocalDate date;
    String NameOfConvict,FatherName,MotherName,Address;

    public DefandentdashboardDetails(int NID, int phone, LocalDate date, String NameOfConvict, String FatherName, String MotherName, String Address) {
        this.NID = NID;
        this.phone = phone;
        this.date = date;
        this.NameOfConvict = NameOfConvict;
        this.FatherName = FatherName;
        this.MotherName = MotherName;
        this.Address = Address;
    }
}
