package java_core_2026.lr8;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example11 {
    private static final String FILE_PATH = "src/main/java/java_core_2026/lr8/songs.json";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Меню плейлиста");
            System.out.println("1. Показать все песни");
            System.out.println("2. Добавить песню");
            System.out.println("3. Поиск по исполнителю");
            System.out.println("4. Удалить песню по названию");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");

            String input = scanner.nextLine();
            if (input.equals("5")) break;

            switch (input) {
                case "1":
                    printAllSongs();
                    break;
                case "2":
                    addSong(scanner);
                    break;
                case "3":
                    searchByArtist(scanner);
                    break;
                case "4":
                    deleteSong(scanner);
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }

    private static void printAllSongs() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONArray songs = (JSONArray) parser.parse(reader);

            if (songs.isEmpty()) {
                System.out.println("Список песен пуст.");
                return;
            }

            for (Object obj : songs) {
                JSONObject song = (JSONObject) obj;
                System.out.println("Название: " + song.get("title") + 
                                   " | Артист: " + song.get("artist") + 
                                   " | Год: " + song.get("year"));
            }
        } catch (Exception e) {
            System.out.println("Список пуст или файл не найден.");
        }
    }

    private static void addSong(Scanner scanner) {
        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("Введите артиста: ");
        String artist = scanner.nextLine();
        System.out.print("Введите год: ");
        String year = scanner.nextLine();

        JSONArray songs = new JSONArray();
        JSONParser parser = new JSONParser();
        
        try (FileReader reader = new FileReader(FILE_PATH)) {
            songs = (JSONArray) parser.parse(reader);
        } catch (Exception e) { }

        JSONObject newSong = new JSONObject();
        newSong.put("title", title);
        newSong.put("artist", artist);
        newSong.put("year", year);

        songs.add(newSong);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(songs.toJSONString());
            System.out.println("Успешно сохранено!");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    private static void searchByArtist(Scanner scanner) {
        System.out.print("Введите имя исполнителя для поиска: ");
        String artistQuery = scanner.nextLine().toLowerCase();
        
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONArray songs = (JSONArray) parser.parse(reader);
            boolean found = false;

            for (Object obj : songs) {
                JSONObject song = (JSONObject) obj;
                String artist = song.get("artist").toString().toLowerCase();
                
                if (artist.contains(artistQuery)) {
                    System.out.println("Найдено -> Название: " + song.get("title") + 
                                       " | Артист: " + song.get("artist") + 
                                       " | Год: " + song.get("year"));
                    found = true;
                }
            }
            if (!found) System.out.println("Исполнитель не найден.");
        } catch (Exception e) {
            System.out.println("Ошибка при поиске.");
        }
    }

    private static void deleteSong(Scanner scanner) {
        System.out.print("Введите название песни для удаления: ");
        String titleToDelete = scanner.nextLine();

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONArray songs = (JSONArray) parser.parse(reader);
            boolean removed = false;

            for (int i = 0; i < songs.size(); i++) {
                JSONObject song = (JSONObject) songs.get(i);
                if (song.get("title").toString().equalsIgnoreCase(titleToDelete)) {
                    songs.remove(i);
                    removed = true;
                    break; 
                }
            }

            if (removed) {
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    writer.write(songs.toJSONString());
                    System.out.println("Песня удалена успешно.");
                } catch (IOException e) {
                    System.out.println("Ошибка при сохранении изменений.");
                }
            } else {
                System.out.println("Песня с таким названием не найдена.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении.");
        }
    }
}

