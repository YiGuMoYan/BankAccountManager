package top.yigumoyan;

class CheckingAccount extends Account {
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println(Constant.CHECKING_INSUFFICIENT_FUNDS_MESSAGE);
            return false;
        }
    }
}