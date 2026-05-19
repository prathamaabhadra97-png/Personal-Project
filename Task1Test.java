import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Task1Test {

    @Test
    public void testOverdueLoans() {
        Task1 service = new Task1();

        // Create sample accounts
        LoanAccount overdueWithBalance = new LoanAccount();
        overdueWithBalance.setDueDate(new Date(System.currentTimeMillis() - 86400000)); // yesterday
        overdueWithBalance.setOutstandingBalance(100.0);
        overdueWithBalance.setAccountId("A1");

        LoanAccount overdueZeroBalance = new LoanAccount();
        overdueZeroBalance.setDueDate(new Date(System.currentTimeMillis() - 86400000)); // yesterday
        overdueZeroBalance.setOutstandingBalance(0.0);
        overdueZeroBalance.setAccountId("A2");

        LoanAccount futureDue = new LoanAccount();
        futureDue.setDueDate(new Date(System.currentTimeMillis() + 86400000)); // tomorrow
        futureDue.setOutstandingBalance(200.0);
        futureDue.setAccountId("A3");

        LoanAccount nullDueDate = new LoanAccount();
        nullDueDate.setDueDate(null); // restructured account
        nullDueDate.setOutstandingBalance(300.0);
        nullDueDate.setAccountId("A4");

        List<LoanAccount> accounts = Arrays.asList(overdueWithBalance, overdueZeroBalance, futureDue, nullDueDate);

        List<LoanAccount> result = service.getOverdueLoans(accounts);

        // Assertions
        assertEquals(1, result.size()); // Only overdueWithBalance should be included
        assertEquals("A1", result.get(0).getAccountId());
    }
}