class Bank {
    private long[] balance;
    private int length;

    public Bank(long[] balance) {
        this.balance = balance;
        this.length = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 <= 0 || account1 > length || account2 <= 0 || account2 > length)
            return false;
        if (balance[account1 - 1] < money)
            return false;
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > length)
            return false;
        balance[account - 1] += money;
        return true; 
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > length)
            return false;
        if (balance[account - 1] < money)
            return false;
        balance[account - 1] -= money;
        return true;
    }
}
