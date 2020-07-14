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
}
