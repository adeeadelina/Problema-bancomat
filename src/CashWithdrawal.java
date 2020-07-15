import java.util.Map;
import java.util.Scanner;

public class CashWithdrawal {
    public static ATM atmMachine = ATM.getInstance();

    // TODO cand nu mai raman bancnote de un tip, sterge entry-ul
    public static void main(String[] args) {
        atmMachine.createInitialBalance();
        System.out.println(89 % 50);
        Scanner scanner = new Scanner(System.in);
        // TODO stop while loop la testare>>
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            System.out.println(atmMachine.calculateBalance());
            System.out.println(amount);
            if (!atmMachine.isEmpty()) {
                if (atmMachine.isAvailable(amount)) {
                    withdraw(amount);
                } else {
                    System.out.println("Cannot withdraw money.");
                }
            } else {
                System.out.println("ATM is empty.");
            }
        }
    }

    // TODO metoda cu while in care se intampla calculul a cate bancnote
    public static void withdraw(int amount) {
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
                        System.out.println(nrOfBills + " x " + typeOfBills);
                    }
                    atmMachine.updateBalance(nrOfBills, typeOfBills);
                }
            }
            // when the split into bills cannot be done
            if (nrOfBills == 0) {
                System.out.println("Cannot withdraw money.");
            }
            atmMachine.verifyBalance();

        }
        System.out.println("Total number of bills used: " + totalBills);
        System.out.println("");
    }
}
