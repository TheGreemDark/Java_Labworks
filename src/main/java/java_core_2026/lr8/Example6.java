package java_core_2026.lr8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Example6 {
     public static void main(String[] args) {
        // Ссылка на страницу
        String url = "http://fat.urfu.ru/index.html";

        try {
            // 1. Подключаемся к сайту
            Document doc = Jsoup.connect(url).get();

            // 2. Ищем блоки новостей. 
            // На этом сайте новости часто лежат в блоках с классом 'news' или внутри списка.
            // Селектор '.news-item' или просто поиск всех ссылок в новостном блоке.
            // Для универсальности возьмем структуру, где есть заголовок и дата.
            Elements newsBlocks = doc.select(".news-list .news-item, .news-block, div.news");

            // Если селектор выше ничего не нашел (структура может меняться), 
            // попробуем более широкий поиск по ссылкам в новостном разделе
            if (newsBlocks.isEmpty()) {
                newsBlocks = doc.select("div.news-item, li.news-item"); 
            }

            // Если и это не сработало, используем "запасной" вариант: ищем заголовки внутри контента
            if (newsBlocks.isEmpty()) {
                System.out.println("Использую универсальный поиск по тегам...");
                newsBlocks = doc.select("div > a[href*='news']"); // Ищем ссылки, содержащие 'news'
            }

            if (newsBlocks.isEmpty()) {
                System.out.println("Новости не найдены. Проверьте селекторы.");
                return;
            }

            System.out.println("=== СПИСОК НОВОСТЕЙ ===\n");

            for (Element block : newsBlocks) {
                // 3. Извлекаем тему (обычно это текст внутри ссылки или заголовка)
                // Ищем внутри блока тег <a> или заголовок
                Element titleElement = block.selectFirst("a, h3, h4, .title");
                String title = (titleElement != null) ? titleElement.text().trim() : "Тема не найдена";

                // 4. Извлекаем дату
                // Ищем элемент, содержащий дату (обычно класс 'date' или 'time')
                Element dateElement = block.selectFirst(".date, .time, span.date, small");
                String date = (dateElement != null) ? dateElement.text().trim() : "Дата не найдена";

                // Выводим результат, если тема не пустая
                if (!title.isEmpty() && !title.equals("Тема не найдена")) {
                    System.out.println("Тема: " + title);
                    System.out.println("Дата: " + date);
                    System.out.println("------------------------------------");
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при подключении к сайту: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
