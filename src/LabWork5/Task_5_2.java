package LabWork5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task_5_2 {
    public static void main(String[] args) {

        String filePath = "src/LabWork5/file.txt";

        Set<Character> allConsonants = new HashSet<>();
        allConsonants.add('к');
        allConsonants.add('п');
        allConsonants.add('с');
        allConsonants.add('т');
        allConsonants.add('ф');
        allConsonants.add('х');
        allConsonants.add('ц');
        allConsonants.add('ш');

        Set<Character> usedConsonants = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (allConsonants.contains(Character.toLowerCase(c))) {
                        usedConsonants.add(Character.toLowerCase(c));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        allConsonants.removeAll(usedConsonants);

        Set<Character> sortedConsonants = new TreeSet<>(allConsonants);

        System.out.print("Глухие согласные буквы, которые не входят ни в одно слово: ");
        for (char c : sortedConsonants) {
            System.out.print(c + " ");
        }
    }
}
