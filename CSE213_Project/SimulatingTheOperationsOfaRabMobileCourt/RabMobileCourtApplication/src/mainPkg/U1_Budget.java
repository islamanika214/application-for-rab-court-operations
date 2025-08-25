/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author User
 */
public class U1_Budget {
    private int budget;
    private String operationtype, operationPlace;

    public U1_Budget(int budget, String operationtype, String operationPlace) {
        this.budget = budget;
        this.operationtype = operationtype;
        this.operationPlace = operationPlace;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(String operationtype) {
        this.operationtype = operationtype;
    }

    public String getOperationPlace() {
        return operationPlace;
    }

    public void setOperationPlace(String operationPlace) {
        this.operationPlace = operationPlace;
    }

    @Override
    public String toString() {
        return "U1_Budget{" + "budget=" + budget + ", operationtype=" + operationtype + ", operationPlace=" + operationPlace + '}';
    }
    
    
}
