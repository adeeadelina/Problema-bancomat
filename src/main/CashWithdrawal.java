import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class CashWithdrawal {
    public static ATM atmMachine = ATM.getInstance();

    public void createATM() {
        atmMachine.createInitialBalance();
    }
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int amount = scanner.nextInt();
//            System.out.println(atmMachine.calculateBalance());
//            System.out.println(amount);
//            if (!atmMachine.isEmpty()) {
//                if (atmMachine.isAvailable(amount)) {
//                    ArrayList<Bills> billsReturned = withdraw(amount);
//                    System.out.println(billsReturned);
//                } else {
//                    System.out.println("Cannot withdraw money.");
//                }
//            } else {
//                System.out.println("Cannot withdraw money.");
//            }
//        }
//    }

    public static HashSet<Bills> withdraw(int amount) {
        HashSet<Bills> billsReturned = new HashSet<>();
        int nrOfBills = 0, typeOfBills = 0, totalBills = 0;
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
        System.out.println("Total number of bills used: " + totalBills);
        System.out.println("");
        return billsReturned;
    }
}
