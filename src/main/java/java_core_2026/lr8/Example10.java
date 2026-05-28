package java_core_2026.lr8;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example10 {
    private static final String URL = "https://habr.com/ru/news/";
    private static final String FILE_NAME = "src/main/java/java_core_2026/lr8/news.json";
    private static final int MAX_RETRIES = 3;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String htmlContent = fetchHtmlWithRetry(URL);

        if (htmlContent != null) {
            System.out.println("HTML успешно получен. Начинаю парсинг новостей...");
            parseAndSaveNews(htmlContent);
        } else {
            System.err.println("Не удалось получить данные после всех попыток. Программа завершена.");
        }
    }

    private static String fetchHtmlWithRetry(String url) {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                System.out.println("Попытка подключения №" + (attempt + 1) + "...");
                Document doc = Jsoup.connect(url)
                        .timeout(5000)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                        .get();
                
                System.out.println("Успешно подключено к " + url);
                return doc.html();
                
            } catch (IOException e) {
                attempt++;
                System.err.println("Ошибка при подключении к " + url + ": " + e.getMessage());
                
                if (attempt < MAX_RETRIES) {
                    System.out.println("Пробую переподключиться через 2 секунды...");
                    try { 
                        Thread.sleep(2000); 
                    } catch (InterruptedException ignored) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.err.println("Достигнуто максимальное количество попыток (" + MAX_RETRIES + ").");
                }
            }
        }
        return null;
    }

    private static void parseAndSaveNews(String html) {
        Document doc = Jsoup.parse(html);
        
        // Ищем блоки новостей с несколькими селекторами
        Elements newsBlocks = doc.select(".news-list .news-item, .news-block, div.news");

        if (newsBlocks.isEmpty()) {
            newsBlocks = doc.select("div.news-item, li.news-item"); 
        }

        if (newsBlocks.isEmpty()) {
            System.out.println("Использую универсальный поиск по тегам...");
            newsBlocks = doc.select("div > a[href*='news']");
        }

        if (newsBlocks.isEmpty()) {
            System.out.println("Новости не найдены. Проверьте селекторы.");
            return;
        }

        // Создаем список для хранения новостей
        StringBuilder newsJson = new StringBuilder();
        newsJson.append("{\n");
        newsJson.append("  \"parseDate\": \"").append(LocalDateTime.now().format(DATE_TIME_FORMATTER)).append("\",\n");
        newsJson.append("  \"source\": \"").append(URL).append("\",\n");
        newsJson.append("  \"news\": [\n");

        int foundCount = 0;
        
        for (Element block : newsBlocks) {
            Element titleElement = block.selectFirst("a, h3, h4, .title");
            String title = (titleElement != null) ? titleElement.text().trim() : "";

            Element dateElement = block.selectFirst(".date, .time, span.date, small");
            String date = (dateElement != null) ? dateElement.text().trim() : "";

            if (!title.isEmpty()) {
                foundCount++;
                
                // Экранирование спецсимволов для JSON
                String safeTitle = escapeJson(title);
                String safeDate = escapeJson(date);

                if (foundCount > 1) {
                    newsJson.append(",\n");
                }
                
                newsJson.append("    {\n");
                newsJson.append("      \"title\": \"").append(safeTitle).append("\",\n");
                newsJson.append("      \"date\": \"").append(safeDate).append("\n");
                newsJson.append("    }");

                System.out.println("Тема: " + title);
                System.out.println("Дата: " + date);
                System.out.println();
            }
        }

        newsJson.append("\n  ]\n");
        newsJson.append("}\n");

        // Создаем директорию если не существует
        File file = new File(FILE_NAME);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        // Записываем в файл
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            out.print(newsJson.toString());
            out.flush();
            
            System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
            System.out.println("Найдено новостей: " + foundCount);
            System.out.println("Данные сохранены в: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String escapeJson(String text) {
        if (text == null) return "";
        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}