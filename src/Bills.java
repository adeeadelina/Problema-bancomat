public class Bills {
    public int nrOfBills;
    public int typeOfBills;

    public Bills(int nrOfBills, int typeOfBills) {
        this.nrOfBills = nrOfBills;
        this.typeOfBills = typeOfBills;
    }

    public String toString() {
        return "(" + nrOfBills + ", " + typeOfBills + ")";
    }
}
