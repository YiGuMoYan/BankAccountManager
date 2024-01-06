package top.yigumoyan;

class Account {
    protected double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println(Constant.INSUFFICIENT_FUNDS_MESSAGE);
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}