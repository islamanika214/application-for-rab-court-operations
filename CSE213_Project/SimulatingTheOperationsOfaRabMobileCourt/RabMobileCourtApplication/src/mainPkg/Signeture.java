package mainPkg;

import java.time.LocalDate;

public class Signeture {

    protected String userName;
    protected LocalDate dateOfSigning;

    public Signeture(String userName, LocalDate dateOfSigning) {
        this.userName = userName;
        this.dateOfSigning = dateOfSigning;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDateOfSigning() {
        return dateOfSigning;
    }

    public void setDateOfSigning(LocalDate dateOfSigning) {
        this.dateOfSigning = dateOfSigning;
    }

    @Override
    public String toString() {
        return "Signeture{" + "userName=" + userName + ", dateOfSigning=" + dateOfSigning + '}';
    }

}
