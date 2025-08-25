package mainPkg;

import java.io.Serializable;
import java.time.LocalDate;

public class Search_Warrant implements Serializable {

    public int warrantId;
    public String institutionName;
    public String institutionType;
    public int badgeNumber;
    public LocalDate searchDate;
    public String reasonForSearch;

    public Search_Warrant(int warrantId, String institutionName, String institutionType, int badgeNumber, LocalDate searchDate, String reasonForSearch) {
        this.warrantId = warrantId;
        this.institutionName = institutionName;
        this.institutionType = institutionType;
        this.badgeNumber = badgeNumber;
        this.searchDate = searchDate;
        this.reasonForSearch = reasonForSearch;
    }

    public Search_Warrant() {
    }

    public int getWarrantId() {
        return warrantId;
    }

    public void setWarrantId(int warrantId) {
        this.warrantId = warrantId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public LocalDate getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDate searchDate) {
        this.searchDate = searchDate;
    }

    public String getReasonForSearch() {
        return reasonForSearch;
    }

    public void setReasonForSearch(String reasonForSearch) {
        this.reasonForSearch = reasonForSearch;
    }

    @Override
    public String toString() {
        return "Search_Warrant : " + " Warrant ID= " + warrantId + ", Institution Name= " + institutionName + ", Institution Type= " + institutionType + ", Badge Number= " + badgeNumber + ", Search Date= " + searchDate + ", Reason For Search= " + reasonForSearch + "\n";
    }

}
