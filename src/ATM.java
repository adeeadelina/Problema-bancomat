import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ATM {
    // descending order
    TreeMap<Integer, Integer> balance = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private static ATM instance = null;
    private ATM() {}
    public static ATM getInstance() {
        if(instance == null) {
            instance = new ATM();
        }
        return instance;
    }
    // TODO comentariu mai bun despre key si value
    // key - type, value - how many
    public void createInitialBalance() {
        balance.put(1, 100);
        balance.put(5, 100);
        balance.put(10, 100);
        balance.put(50, 50);
        balance.put(100, 50);
    }

    public boolean isAvailable (int amount) {
        if (amount <= calculateBalance()) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(calculateBalance() > 0) {
            return false;
        }
        return true;
    }

    public int calculateBalance() {
        int currentBalance = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            currentBalance += entry.getKey() * entry.getValue();
        }
        return currentBalance;
    }
    public void updateBalance(int nrOfBills, int typeOfBills) {
        balance.put(typeOfBills, balance.get(typeOfBills) - nrOfBills);

    }

    public void verifyBalance() {
        int keyToRemove = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            if(entry.getValue() == 0) {
                keyToRemove = entry.getKey();
            }
        }
        balance.remove(keyToRemove);
    }

}
