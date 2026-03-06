package java_core_2026.lr2;

public class BankAccount implements BankAccountOperations {
    private String accountNumber;
    private double balance;
    private boolean isActive;
    
    // Конструктор по умолчанию
    public BankAccount() {
        this.accountNumber = "Не инициализирован";
        this.balance = 0.0;
        this.isActive = false;
    }
    
    @Override
    public void createAccount(String accountNumber, double initialBalance) {
        if (initialBalance >= 0) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.isActive = true;
            System.out.println("Счет " + accountNumber + " успешно создан с балансом " + initialBalance);
        } else {
            System.out.println("Ошибка: начальный баланс не может быть отрицательным");
        }
    }
    
    @Override
    public boolean deposit(double amount) {
        if (!isActive) {
            System.out.println("Ошибка: счет не активирован");
            return false;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Пополнение счета на " + amount + ". Новый баланс: " + balance);
            return true;
        } else {
            System.out.println("Ошибка: сумма пополнения должна быть положительной");
            return false;
        }
    }
    
    @Override
    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("Ошибка: счет не активирован");
            return false;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снятие со счета на " + amount + ". Новый баланс: " + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств. Баланс: " + balance);
            return false;
        } else {
            System.out.println("Ошибка: сумма снятия должна быть положительной");
            return false;
        }
    }
    
    @Override
    public double getBalance() {
        if (!isActive) {
            return 0.0;
        }
        return balance;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Счет: " + accountNumber + 
                          ", Баланс: " + String.format("%.2f", balance) + 
                          ", Статус: " + (isActive ? "Активен" : "Неактивен"));
    }
}
