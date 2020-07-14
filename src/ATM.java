import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ATM {
    // TODO comparator pentru a le avea in ordine descrescatoare
    TreeMap<Integer, Integer> balance = new TreeMap<>();
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
            return true;
        }
        return false;
    }

    public int calculateBalance() {
        int currentBalance = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            currentBalance += entry.getKey() * entry.getValue();
        }
        return currentBalance;
    }


}
