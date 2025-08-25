package mainPkg;

public class Eye_Witness {
    public int witnessId;
    public String name, testimony;

    public Eye_Witness(int witnessId, String name, String testimony) {
        this.witnessId = witnessId;
        this.name = name;
        this.testimony = testimony;
    }

    public int getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(int witnessId) {
        this.witnessId = witnessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestimony() {
        return testimony;
    }

    public void setTestimony(String testimony) {
        this.testimony = testimony;
    }

    @Override
    public String toString() {
        return "Eye_Witness{" + "witnessId=" + witnessId + ", name=" + name + ", testimony=" + testimony + '}';
    }
    
    
}
