public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: Initialize result list instead of null
        List<LoanAccount> result = new ArrayList<>();

        for (LoanAccount account : accounts) {
            // FIX: Null check for dueDate to avoid NPE
            if (account.getDueDate() != null && account.getDueDate().before(new Date())) {
                // FIX done by Prathama: Ensure outstandingBalance > 0
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }
        return result;
    }

// LoanAccount fields:
// Date dueDate — may be null for restructured accounts
// double outstandingBalance
// String accountId — always non-null