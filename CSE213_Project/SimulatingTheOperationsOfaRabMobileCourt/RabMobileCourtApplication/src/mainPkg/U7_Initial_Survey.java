package mainPkg;

public class U7_Initial_Survey {

    private String institutionName;
    private String institutionLocation;
    private String surveyDeacription;

    public U7_Initial_Survey() {
    }

    public U7_Initial_Survey(String institutionName, String institutionLocation, String surveyDeacription) {
        this.institutionName = institutionName;
        this.institutionLocation = institutionLocation;
        this.surveyDeacription = surveyDeacription;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getInstitutionLocation() {
        return institutionLocation;
    }

    public String getSurveyDeacription() {
        return surveyDeacription;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setInstitutionLocation(String institutionLocation) {
        this.institutionLocation = institutionLocation;
    }

    public void setSurveyDeacription(String surveyDeacription) {
        this.surveyDeacription = surveyDeacription;
    }

    @Override
    public String toString() {
        return "institutionName : " + institutionName + ", institutionLocation : " + 
                institutionLocation + ", surveyDeacription : " + surveyDeacription +"\n";
    }

}
