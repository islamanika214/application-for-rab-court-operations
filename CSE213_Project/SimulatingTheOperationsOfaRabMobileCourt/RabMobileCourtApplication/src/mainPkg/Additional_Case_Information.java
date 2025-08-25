package mainPkg;

public class Additional_Case_Information {
    public int addiCaseInfId, caseId, defendantId;
    public String defenHist, crimDescip;

    public Additional_Case_Information(int addiCaseInfId, int caseId, int defendantId, String defenHist, String crimDescip) {
        this.addiCaseInfId = addiCaseInfId;
        this.caseId = caseId;
        this.defendantId = defendantId;
        this.defenHist = defenHist;
        this.crimDescip = crimDescip;
    }

    public int getAddiCaseInfId() {
        return addiCaseInfId;
    }

    public void setAddiCaseInfId(int addiCaseInfId) {
        this.addiCaseInfId = addiCaseInfId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getDefendantId() {
        return defendantId;
    }

    public void setDefendantId(int defendantId) {
        this.defendantId = defendantId;
    }

    public String getDefenHist() {
        return defenHist;
    }

    public void setDefenHist(String defenHist) {
        this.defenHist = defenHist;
    }

    public String getCrimDescip() {
        return crimDescip;
    }

    public void setCrimDescip(String crimDescip) {
        this.crimDescip = crimDescip;
    }

    @Override
    public String toString() {
        return "Additional_Case_Information{" + "addiCaseInfId=" + addiCaseInfId + ", caseId=" + caseId + ", defendantId=" + defendantId + ", defenHist=" + defenHist + ", crimDescip=" + crimDescip + '}';
    }
    
    
}
