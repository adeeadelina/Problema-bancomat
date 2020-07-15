import java.util.HashSet;
import java.util.Map;

public class CashWithdrawal {
    public static ATM atmMachine = ATM.getInstance();

    public void createATM() {
        atmMachine.createInitialBalance();
    }

    public HashSet<Bills> withdraw(int amount) {
        if (!isAmountCorrect(amount) || !atmMachine.isAvailable(amount)) {
            System.out.println("Cannot withdraw money.");
            return null;
        }
        HashSet<Bills> billsReturned = new HashSet<>();
        int nrOfBills = 0, typeOfBills, totalBills = 0;
        while (amount != 0) {
            for (Map.Entry<Integer, Integer> entry : atmMachine.balance.entrySet()) {
                if (entry.getKey() <= amount) {
                    nrOfBills = amount / entry.getKey();
                    typeOfBills = entry.getKey();
                    if (nrOfBills > entry.getValue()) {
                        nrOfBills = entry.getValue();
                    }
                    totalBills += nrOfBills;
                    amount -= typeOfBills * nrOfBills;
                    if (nrOfBills != 0) {
                        Bills goodBills = new Bills(nrOfBills, typeOfBills);
                        billsReturned.add(goodBills);
                    }
                    atmMachine.updateBalance(nrOfBills, typeOfBills);
                }
            }
            // when the split into bills cannot be done
            if (nrOfBills == 0) {
                System.out.println("Cannot withdraw money.");
                return null;
            }
            atmMachine.verifyBalance();

        }
        printTotalNumberOfBills(totalBills);
        return billsReturned;
    }

    //checks if the amount is a valid number for such request
    public boolean isAmountCorrect(int amount) {
        return amount > 0;
    }

    public void printTotalNumberOfBills(int totalNumberOfBills) {
        System.out.println("Total number of bills used: " + totalNumberOfBills);
        System.out.println();
    }
}
