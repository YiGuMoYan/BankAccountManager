package top.yigumoyan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Constant.WELCOME_MESSAGE);

        System.out.print(Constant.ENTER_PIN_MESSAGE);
        String pin = scanner.nextLine();

        if (isValidPin(pin)) {
            Account checkingAccount = new CheckingAccount();
            Account savingsAccount = new SavingsAccount();

            showMenu(checkingAccount, savingsAccount, scanner);
        } else {
            System.out.println(Constant.INVALID_PIN_MESSAGE);
        }
    }

    private static boolean isValidPin(String pin) {
        return pin.length() == Constant.PIN_LENGTH && pin.matches("\\d+");
    }

    private static void showMenu(Account checkingAccount, Account savingsAccount, Scanner scanner) {
        int choice;
        do {
            System.out.println(Constant.MENU_HEADER);
            System.out.println("1. 存款");
            System.out.println("2. 取款");
            System.out.println("3. 查询余额");
            System.out.println("4. 退出");
            System.out.print("请输入您的选择: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositMenu(checkingAccount, savingsAccount, scanner);
                    break;
                case 2:
                    withdrawMenu(checkingAccount, savingsAccount, scanner);
                    break;
                case 3:
                    checkBalanceMenu(checkingAccount, savingsAccount, scanner);
                    break;
                case 4:
                    System.out.println(Constant.EXITING_MESSAGE);
                    break;
                default:
                    System.out.println(Constant.INVALID_CHOICE_MESSAGE);
            }
        } while (choice != 4);
    }

    private static void depositMenu(Account checkingAccount, Account savingsAccount, Scanner scanner) {
        System.out.println(Constant.DEPOSIT_MENU);
        System.out.println("1. 支票账户");
        System.out.println("2. 储蓄账户");
        System.out.print("请选择账户类型: ");

        int accountType = scanner.nextInt();
        System.out.print("请输入存款金额: ");
        double amount = scanner.nextDouble();

        switch (accountType) {
            case 1:
                checkingAccount.deposit(amount);
                break;
            case 2:
                savingsAccount.deposit(amount);
                break;
            default:
                System.out.println(Constant.INVALID_ACCOUNT_TYPE_MESSAGE);
        }
    }

    private static void withdrawMenu(Account checkingAccount, Account savingsAccount, Scanner scanner) {
        System.out.println(Constant.WITHDRAW_MENU);
        System.out.println("1. 支票账户");
        System.out.println("2. 储蓄账户");
        System.out.print("请选择账户类型: ");

        int accountType = scanner.nextInt();
        System.out.print("请输入取款金额: ");
        double amount = scanner.nextDouble();

        switch (accountType) {
            case 1:
                checkingAccount.withdraw(amount);
                break;
            case 2:
                savingsAccount.withdraw(amount);
                break;
            default:
                System.out.println(Constant.INVALID_ACCOUNT_TYPE_MESSAGE);
        }
    }

    private static void checkBalanceMenu(Account checkingAccount, Account savingsAccount, Scanner scanner) {
        System.out.println(Constant.CHECK_BALANCE_MENU);
        System.out.println("1. 支票账户");
        System.out.println("2. 储蓄账户");
        System.out.print("请选择账户类型: ");

        int accountType = scanner.nextInt();

        switch (accountType) {
            case 1:
                System.out.println("支票账户余额: ￥" + checkingAccount.getBalance());
                break;
            case 2:
                System.out.println("储蓄账户余额: ￥" + savingsAccount.getBalance());
                break;
            default:
                System.out.println(Constant.INVALID_ACCOUNT_TYPE_MESSAGE);
        }
    }
}