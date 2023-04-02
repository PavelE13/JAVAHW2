package JAVAHW2;

import java.io.*;
import java.net.URL;

public class zad4 {

    public static String download(String url, String localFilename) {
        try {
            URL fileUrl = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileUrl.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(localFilename));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String change(String name, String fileContent) {
        return fileContent.replaceAll("%s", name);
    }

    public static void read(String localFilename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(localFilename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOnLocal(String fileName, String fileContent) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean removeFromLocale(String fileName) {
        File file = new File(fileName);
        return file.delete();
    }

    public static void main(String[] args) {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String localFilename = "example.txt";
        String name = "John Doe";

        // По указанной строке URL скачивает файл и возвращает строковое содержимое файла
        String fileContent = download(fileUrl, localFilename);

        // Изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
        fileContent = change(name, fileContent);

        // Сохраняет файл локально
        saveOnLocal(localFilename, fileContent);

        // Читает сохраненный файл и выводит содержимое в логгер
        read(localFilename);

        // Удаляет сохраненный файл
        removeFromLocale(localFilename);
    }
    
}
