package LabWork5Max;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Task_5_7 {
    public static void main(String[] args) {
        String filePath = "src/LabWork5Max/file.txt"; // Укажите путь к вашему файлу

        Set<Character> uniqueLetters = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        uniqueLetters.add(Character.toLowerCase(c));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Количество различных букв в тексте: " + uniqueLetters.size());
    }
}
