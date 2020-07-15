import javax.management.Notification;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ATM {
    private static ATM instance = null;
    // descending order
    TreeMap<Integer, Integer> balance = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    private ATM() {
    }

    public static ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    // key - type of bill, value - how many bills of that type
    public void createInitialBalance() {
        balance.put(1, 100);
        balance.put(5, 100);
        balance.put(10, 100);
        balance.put(50, 50);
        balance.put(100, 50);
    }

    public boolean isAvailable(int amount) {
        if (amount <= calculateBalance()) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (calculateBalance() > 0) {
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

    // if there are types with no bills left, erase them
    // identify warning and critical cases
    public void verifyBalance() {
        int keyToRemove = 0;
        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            if (entry.getValue() == 0) {
                keyToRemove = entry.getKey();
            }
        }
        balance.remove(keyToRemove);
        if (balance.containsKey(100)) {
            verify100WarningCase();
            verify100CriticalCase();
        }
        if (balance.containsKey(50)) {
            verify50WarningCase();
        }
    }

    public void verify100WarningCase() {
        if (balance.get(100) < 10 && balance.get(100) >= 5) {
            MailNotification notification = new MailNotification("WARNING: Number of 100 bills under 20%");
            notification.sendMail();
        }
    }

    public void verify100CriticalCase() {
        if (balance.get(100) < 5) {
            MailNotification notification = new MailNotification("CRITICAL: Number of 100 bills under 10%");
            notification.sendMail();
        }
    }

    public void verify50WarningCase() {
        if (balance.get(50) < 8) {
            MailNotification notification = new MailNotification("WARNING: Number of 50 bills under 15%");
            notification.sendMail();
        }
    }

}
