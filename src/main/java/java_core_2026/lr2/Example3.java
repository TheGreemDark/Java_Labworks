package java_core_2026.lr2;
import java.util.Scanner;
public class Example3 {
    public static String getEncryptString(String encryptString, int shift) {

        // преобразуем переданную в метод строку в символьный массив
        char[] arrayChar = encryptString.toCharArray();
        // создаем массив с типом данных Long, размер массива равен размеру символьного массива
        long[] arrayInt = new long[arrayChar.length];
        // создаем символьный массив в который будем записывать преобразованные символы
        char[] arrayCharNew = new char[arrayChar.length];
        // в цикле перебираем все символы из которых состоит переданная нами строка, прибавляем к ним число, ключ (сдвиг)
        for (int i = 0; i < arrayChar.length; i++) {
            // прибавляем к символу с индексом i сдвиг
            arrayInt[i] = arrayChar[i] + shift;
            // преобразовываем число в символ char и записываем на нужное место в новый массив
            arrayCharNew[i] = (char) arrayInt[i];
        }
        encryptString = new String(arrayCharNew); // преобразовываем новый массив символов в строку

        return encryptString; // возвращаем строку в метод из которого был вызван текущий метод
    }
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        
        // Сообщение для ввода текста
        System.out.println("Введите текст для шифрования");
        String text = id.nextLine();
        
        // Сообщение для ввода ключа
        System.out.println("Введите ключ");
        int key = Integer.parseInt(id.nextLine());
        
        // Шифрование и вывод результата
        String encrypted = getEncryptString(text, key);
        System.out.println("Текст после преобразования: " + encrypted);
        
        // Цикл для обратного преобразования
        while (true) {
            System.out.print("Выполнить обратное преобразование? (y/n): ");
            String choice = id.nextLine().trim().toLowerCase();
            
            if (choice.equals("y")) {
                String decrypted = getEncryptString(encrypted, -key);
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            } else if (choice.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
        
        id.close();
    }
}