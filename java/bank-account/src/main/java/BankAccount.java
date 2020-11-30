class BankAccount {
    private boolean isOpen = false;
    private int balance = 0;
    
    public void open() {
        isOpen = true;
    }
    
    public void close() {
        isOpen = false;
    }
    
    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        throwExceptionIfClosed();
        if(amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        balance += amount;
    }
    
    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        throwExceptionIfClosed();
        if(amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if(balance == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
            // Withdrawing from an empty account is supposed to always fail. While the
            // check below would handle it fine, this must be checked separately and
            // even if balance == amount in case 0 should be withdrawn.
            // Depositing/Withdrawing 0 should probably fail too, but that's not in
            // the spec so there's no reason to do it.
        }
        if(balance < amount) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
        balance -= amount;
    }
    
    public int getBalance() throws BankAccountActionInvalidException {
        throwExceptionIfClosed();
        return balance;
    }
    
    private void throwExceptionIfClosed() throws BankAccountActionInvalidException {
        if(!isOpen) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }
}