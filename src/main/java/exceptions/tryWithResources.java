package exceptions;

import java.io.*;
import java.util.Scanner;

public class tryWithResources {
    public static String readFile(String pathToFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            String result;
            while ((result = bufferedReader.readLine()) != null) {
                stringBuilder.append(result).append("\n");
            }
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Не удалось найти файл");
        } catch (IOException exception) {
            throw new RuntimeException("Нам капец. Конец связи.");
        }
        return String.valueOf(stringBuilder);
    }

    public static void writeInFile(String createFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createFile))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Укажите путь к файлу, из которого нужно копировать данные: ");
            String copyFromFile = scanner.nextLine();

            bufferedWriter.write(readFile(copyFromFile));
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Не удалось записать файл :(");
        } catch (IOException exception) {
            throw new RuntimeException("Хьюстон, у нас проблемы...");
        }
    }
}
