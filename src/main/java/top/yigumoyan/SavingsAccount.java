package top.yigumoyan;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02;

    @Override
    public void deposit(double amount) {
        if (amount > Constant.MAX_DEPOSIT_AMOUNT) {
            System.out.println(Constant.CONTACT_MANAGER_MESSAGE);
        } else {
            balance += amount;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println(Constant.SAVINGS_INSUFFICIENT_FUNDS_MESSAGE);
            return false;
        }
    }

    public void applyInterest() {
        balance += balance * INTEREST_RATE;
    }
}