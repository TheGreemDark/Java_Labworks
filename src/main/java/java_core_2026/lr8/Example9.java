package java_core_2026.lr8;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Example9 {
    private static final String FILE_PATH = "src/main/java/java_core_2026/lr8/playlist.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Меню управления плейлистом ---");
            System.out.println("1. Показать все песни");
            System.out.println("2. Добавить песню");
            System.out.println("3. Поиск (по исполнителю или жанру)");
            System.out.println("4. Удалить песню (по названию)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> printAllSongs();
                    case "2" -> addSong(scanner);
                    case "3" -> searchSongs(scanner);
                    case "4" -> deleteSong(scanner);
                    case "0" -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Неверный ввод!");
                }
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static Document getDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    // 1. ПОКАЗАТЬ ВСЕ ПЕСНИ
    private static void printAllSongs() throws Exception {
        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("song");
        System.out.println("\nСписок песен:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("- " + getTagValue(element, "title") + 
                               " | " + getTagValue(element, "artist") + 
                               " | [" + getTagValue(element, "genre") + "]");
        }
    }

    // 2. ДОБАВИТЬ ПЕСНЮ
    private static void addSong(Scanner scanner) throws Exception {
        System.out.print("Введите название песни: ");
        String title = scanner.nextLine();
        System.out.print("Введите исполнителя: ");
        String artist = scanner.nextLine();
        System.out.print("Введите жанр: ");
        String genre = scanner.nextLine();

        Document doc = getDocument();
        Element root = doc.getDocumentElement();

        Element newSong = doc.createElement("song");

        Element t = doc.createElement("title");
        t.appendChild(doc.createTextNode(title));
        newSong.appendChild(t);

        Element a = doc.createElement("artist");
        a.appendChild(doc.createTextNode(artist));
        newSong.appendChild(a);

        Element g = doc.createElement("genre");
        g.appendChild(doc.createTextNode(genre));
        newSong.appendChild(g);

        root.appendChild(newSong);
        saveDocument(doc);
        System.out.println("Песня успешно добавлена!");
    }

    // 3. ПОИСК (используем Stream API)
    private static void searchSongs(Scanner scanner) throws Exception {
        System.out.print("Введите исполнителя или жанр для поиска: ");
        String query = scanner.nextLine().toLowerCase();

        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("song");

        List<Element> songList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                songList.add((Element) nodeList.item(i));
            }
        }

        List<Element> filteredSongs = songList.stream()
                .filter(element -> {
                    String artist = element.getElementsByTagName("artist").item(0).getTextContent().toLowerCase();
                    String genre = element.getElementsByTagName("genre").item(0).getTextContent().toLowerCase();
                    return artist.contains(query) || genre.contains(query);
                })
                .collect(Collectors.toList());

        if (filteredSongs.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            System.out.println("\nРезультаты поиска:");
            filteredSongs.forEach(e -> System.out.println("- " + getTagValue(e, "title") + 
                               " (" + getTagValue(e, "artist") + ")"));
        }
    }

    // 4. УДАЛЕНИЕ (по названию)
    private static void deleteSong(Scanner scanner) throws Exception {
        System.out.print("Введите название песни для удаления: ");
        String titleToDelete = scanner.nextLine();

        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("song");
        boolean found = false;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element songElement = (Element) nodeList.item(i);
            String title = getTagValue(songElement, "title");

            if (title.equalsIgnoreCase(titleToDelete)) {
                Node parentNode = songElement.getParentNode();
                parentNode.removeChild(songElement);
                found = true;
                break;
            }
        }

        if (found) {
            saveDocument(doc);
            System.out.println("Песня удалена.");
        } else {
            System.out.println("Песня с таким названием не найдена.");
        }
    }

    private static String getTagValue(Element element, String tagName) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list.getLength() > 0) {
            return list.item(0).getTextContent();
        }
        return "";
    }
}


