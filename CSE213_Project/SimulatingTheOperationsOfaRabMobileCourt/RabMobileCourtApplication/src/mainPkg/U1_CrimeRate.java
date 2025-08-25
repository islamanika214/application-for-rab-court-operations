/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPkg;

/**
 *
 * @author Anika
 */
public class U1_CrimeRate {
    private int crimeCount;
    private String districtName;

    public U1_CrimeRate(int crimeCount, String districtName) {
        this.crimeCount = crimeCount;
        this.districtName = districtName;
    }

    public int getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(int crimeCount) {
        this.crimeCount = crimeCount;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("U1_CrimeRate{");
        sb.append("crimeCount=").append(crimeCount);
        sb.append(", districtName=").append(districtName);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
