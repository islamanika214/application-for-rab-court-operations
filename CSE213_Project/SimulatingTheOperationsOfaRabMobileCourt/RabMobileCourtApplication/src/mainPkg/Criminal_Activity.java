package mainPkg;

import java.io.Serializable;

public class Criminal_Activity implements Serializable{

    public int occuranceAmount, occuranceYear;
    public String crimeType;

    public int getOccuranceAmount() {
        return occuranceAmount;
    }

    public void setOccuranceAmount(int occuranceAmount) {
        this.occuranceAmount = occuranceAmount;
    }

    public int getOccuranceYear() {
        return occuranceYear;
    }

    public void setOccuranceYear(int occuranceYear) {
        this.occuranceYear = occuranceYear;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public Criminal_Activity(int occuranceAmount, int occuranceYear, String crimeType) {
        this.occuranceAmount = occuranceAmount;
        this.occuranceYear = occuranceYear;
        this.crimeType = crimeType;
    }

    @Override
    public String toString() {
        return "Criminal_Activity: " + "Occurance Amount= " + occuranceAmount + ", Occurance Year= " + occuranceYear + ", Crime Type= " + crimeType + "\n";
    }

}
