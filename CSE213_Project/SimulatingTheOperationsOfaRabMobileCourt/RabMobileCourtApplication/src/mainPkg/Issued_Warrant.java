package mainPkg;

import java.time.LocalDate;

public class Issued_Warrant {

    private int warrantId;
    private int badgeNum;
    private String instituteName;
    private int numOfSub;
    private String signName;
    private LocalDate date;

    public Issued_Warrant(int warrantId, int badgeNum, String instituteName, int numOfSub, String signName, LocalDate date) {
        this.warrantId = warrantId;
        this.badgeNum = badgeNum;
        this.instituteName = instituteName;
        this.numOfSub = numOfSub;
        this.signName = signName;
        this.date = date;
    }

    public int getWarrantId() {
        return warrantId;
    }

    public void setWarrantId(int warrantId) {
        this.warrantId = warrantId;
    }

    public int getBadgeNum() {
        return badgeNum;
    }

    public void setBadgeNum(int badgeNum) {
        this.badgeNum = badgeNum;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public int getNumOfSub() {
        return numOfSub;
    }

    public void setNumOfSub(int numOfSub) {
        this.numOfSub = numOfSub;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Issued_Warrant: " + "Warrant ID=" + warrantId + ", Badge Number= " + badgeNum + ", Institute Name= " + instituteName + ", Number Of Subordinates= " + numOfSub + ", Signed by= " + signName + ", Date= " + date;
    }

}
