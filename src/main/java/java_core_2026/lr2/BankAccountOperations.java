package java_core_2026.lr2;

public interface BankAccountOperations {
    void createAccount(String accountNumber, double initialBalance);
    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    void printInfo();
}
