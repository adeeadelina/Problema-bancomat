import java.util.Map;
import java.util.Scanner;

public class CashWithdrawal {
    public static ATM atmMachine = ATM.getInstance();
    // TODO cand nu mai raman bancnote de un tip, sterge entry-ul
    public static void main(String[] args) {
        atmMachine.createInitialBalance();
        System.out.println(89 % 50);
        Scanner scanner = new Scanner(System.in);
        // TODO stop while loop
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            System.out.println(atmMachine.calculateBalance());
            System.out.println(amount);
            System.out.println(atmMachine.balance);
            if(!atmMachine.isEmpty() && atmMachine.isAvailable(amount)) {
                System.out.println("ajung macar acia");
                withdraw(amount);
            }
        }
    }

    // TODO metoda cu while in care se intampla calculul a cate bancnote
    public static void withdraw(int amount) {
        System.out.println("ajung aici");
        int nrOfBills = 0, typeOfBills = 0, totalBills = 0;
        while (amount != 0) {
            for (Map.Entry<Integer, Integer> entry : atmMachine.balance.entrySet()) {
                if (entry.getKey() <= amount) {
                    nrOfBills = amount/entry.getKey();
                    typeOfBills = entry.getKey();
                    if (nrOfBills > entry.getValue()) {
                        nrOfBills = entry.getValue();
                    }
                    totalBills += nrOfBills;
                    amount -= typeOfBills * nrOfBills;
                    System.out.println(nrOfBills + " x " + typeOfBills);
                }
            }
            atmMachine.updateBalance(nrOfBills, typeOfBills);
        }
        System.out.println("Total number of bills: " + totalBills);
        System.out.println("");
    }
}
