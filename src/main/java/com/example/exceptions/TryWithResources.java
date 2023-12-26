package com.example.exceptions;

import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        String sourceFile = "src/main/resources/exceptions/source.txt";
        writeInFile("Создался новый файл. Пуффф... Магия)))");

        String file = readFile(sourceFile);
        System.out.println(file);
    }

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

    public static void writeInFile(String text) {
        String destinationFile = "src/main/resources/exceptions/destination.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            bufferedWriter.write(text);
        } catch (IOException exception) {
            throw new RuntimeException("Хьюстон, у нас проблемы...");
        }
    }
}
