import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;

public class ATMTest {

    @BeforeEach
    public void setATM() {
        CashWithdrawal newCashWithdrawal = new CashWithdrawal();
        newCashWithdrawal.createATM();
    }

    //too much money
    @Test
    public void exceptionWithdraw1() {
        assertNull(CashWithdrawal.withdraw(9200));
    }

    //the exact amount
    @Test
    public void exceptionWithdraw2() {
        HashSet<Bills> expectedResult = new HashSet<>();
        expectedResult.add(new Bills(100, 1));
        expectedResult.add(new Bills(100, 5));
        expectedResult.add(new Bills(100, 10));
        expectedResult.add(new Bills(50, 50));
        expectedResult.add(new Bills(50, 100));
        HashSet<Bills> actualResult = CashWithdrawal.withdraw(9100);
        assertEquals(expectedResult, actualResult);
    }

    //0 ron
    @Test
    public void exceptionWithdraw3() {
        assertNull(CashWithdrawal.withdraw(0));
    }

    @Test
    public void multipleWithdraw1() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(50, 100));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(5000);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(50, 50));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(2500);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(98, 10));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(980);
        assertEquals(expectedResult3, actualResult3);
    }

    @Test
    public void multipleWithdraw2() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(50, 100));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(5000);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(50, 50));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(2500);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(98, 10));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(980);
        assertEquals(expectedResult3, actualResult3);

        HashSet<Bills> expectedResult4 = new HashSet<>();
        expectedResult4.add(new Bills(2, 10));
        expectedResult4.add(new Bills(26, 5));
        HashSet<Bills> actualResult4 = CashWithdrawal.withdraw(150);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    public void multipleWithdraw3() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(1, 5));
        expectedResult1.add(new Bills(2, 1));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(7);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(1, 100));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(100);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(15, 100));
        expectedResult3.add(new Bills(4, 10));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(1540);
        assertEquals(expectedResult3, actualResult3);

        HashSet<Bills> expectedResult4 = new HashSet<>();
        expectedResult4.add(new Bills(25, 100));
        HashSet<Bills> actualResult4 = CashWithdrawal.withdraw(2500);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    public void multipleWithdraw4() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(1, 5));
        expectedResult1.add(new Bills(2, 1));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(7);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(1, 100));
        expectedResult2.add(new Bills(1, 50));
        expectedResult2.add(new Bills(1, 1));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(151);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(14, 100));
        expectedResult3.add(new Bills(1, 50));
        expectedResult3.add(new Bills(2, 10));
        expectedResult3.add(new Bills(1, 5));
        expectedResult3.add(new Bills(2, 1));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(1477);
        assertEquals(expectedResult3, actualResult3);

        HashSet<Bills> expectedResult4 = new HashSet<>();
        expectedResult4.add(new Bills(2, 10));
        expectedResult4.add(new Bills(1, 5));
        expectedResult4.add(new Bills(4, 1));
        HashSet<Bills> actualResult4 = CashWithdrawal.withdraw(29);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    public void multipleWithdraw5() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(2, 1));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(2);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(1, 100));
        expectedResult2.add(new Bills(1, 50));
        expectedResult2.add(new Bills(1, 1));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(151);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(14, 100));
        expectedResult3.add(new Bills(1, 50));
        expectedResult3.add(new Bills(2, 10));
        expectedResult3.add(new Bills(1, 5));
        expectedResult3.add(new Bills(2, 1));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(1477);
        assertEquals(expectedResult3, actualResult3);

        HashSet<Bills> expectedResult4 = new HashSet<>();
        expectedResult4.add(new Bills(35, 100));
        expectedResult4.add(new Bills(2, 10));
        expectedResult4.add(new Bills(1, 5));
        expectedResult4.add(new Bills(4, 1));
        HashSet<Bills> actualResult4 = CashWithdrawal.withdraw(3529);
        assertEquals(expectedResult4, actualResult4);

        assertNull(CashWithdrawal.withdraw(4000));
    }

    @Test
    public void multipleWithdraw6() {
        HashSet<Bills> expectedResult1 = new HashSet<>();
        expectedResult1.add(new Bills(49, 100));
        HashSet<Bills> actualResult1 = CashWithdrawal.withdraw(4900);
        assertEquals(expectedResult1, actualResult1);

        HashSet<Bills> expectedResult2 = new HashSet<>();
        expectedResult2.add(new Bills(1, 100));
        expectedResult2.add(new Bills(4, 10));
        expectedResult2.add(new Bills(1, 5));
        expectedResult2.add(new Bills(4, 1));
        HashSet<Bills> actualResult2 = CashWithdrawal.withdraw(149);
        assertEquals(expectedResult2, actualResult2);

        HashSet<Bills> expectedResult3 = new HashSet<>();
        expectedResult3.add(new Bills(50, 50));
        expectedResult3.add(new Bills(3, 10));
        expectedResult3.add(new Bills(3, 1));
        HashSet<Bills> actualResult3 = CashWithdrawal.withdraw(2533);
        assertEquals(expectedResult3, actualResult3);

        HashSet<Bills> expectedResult4 = new HashSet<>();
        expectedResult4.add(new Bills(93, 10));
        expectedResult4.add(new Bills(14, 5));
        HashSet<Bills> actualResult4 = CashWithdrawal.withdraw(1000);
        assertEquals(expectedResult4, actualResult4);
    }

    @Test
    public void multipleWithdraw7() {
        HashSet<Bills> expectedResult = new HashSet<>();
        expectedResult.add(new Bills(100, 1));
        expectedResult.add(new Bills(100, 5));
        expectedResult.add(new Bills(100, 10));
        expectedResult.add(new Bills(50, 50));
        expectedResult.add(new Bills(50, 100));
        HashSet<Bills> actualResult = CashWithdrawal.withdraw(9100);
        assertEquals(expectedResult, actualResult);

        assertNull(CashWithdrawal.withdraw(7));
    }


}
