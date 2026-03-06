package java_core_2026.lr2;

public class Example7 {
public static void main(String[] args) {
    // Создание банковских счетов
    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount();
        
    System.out.println("Банковская система\n");
        
    // Создание счетов
    account1.createAccount("ACC001", 1000.0);
    account2.createAccount("ACC002", 500.50);
    System.out.println();
        
    // Информация о счетах
    System.out.println("Информация о счетах");
    account1.printInfo();
    account2.printInfo();
    System.out.println();
        
    // Транзакции по первому счету
    System.out.println("Транзакции по счету ACC001");
    account1.deposit(250.0);
    account1.withdraw(150.0);
    account1.deposit(300.75);
    account1.withdraw(2000.0); // Ошибка - недостаточно средств
    System.out.println();
        
    // Транзакции по второму счету
    System.out.println("Транзакции по счету ACC002");
    account2.deposit(100.0);
    account2.withdraw(300.0);
    System.out.println();
        
    // Финальная информация
    System.out.println("Итоговая информация");
    account1.printInfo();
    account2.printInfo();
        
    // Работа через интерфейс
    System.out.println("\nРабота через интерфейс");
    BankAccountOperations[] accounts = {account1, account2};
    double totalBalance = 0;
    for (BankAccountOperations acc : accounts) {
        acc.printInfo();
        totalBalance += acc.getBalance();
    }
    System.out.printf("Общий баланс всех счетов: %.2f\n", totalBalance);
    }
}