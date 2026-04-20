import java.util.*;

class LoanAccount {
    private Date dueDate;
    private double outstandingBalance;

    public Date getDueDate() { return dueDate; }
    public double getOutstandingBalance() { return outstandingBalance; }
}

public class Task1 {
    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: Initialize result list
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Null check for accounts list
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {
            // FIX: Null check for account and dueDate
            if (account != null && account.getDueDate() != null) {
                if (account.getDueDate().before(new Date())) {
                    if (account.getOutstandingBalance() > 0) {
                        result.add(account);
                    }
                }
            }
        }
        return result;
    }
}
