package LabWork5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_7_2 {
    public static void main(String[] args) {

        String filePath = "src/LabWork5/file.txt";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            Map<Integer, List<String>> groupedPeople = lines
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1]),
                            Collectors.mapping(parts -> capitalizeFirstLetter(parts[0].toLowerCase()), Collectors.toList())
                    ));

            System.out.println(groupedPeople);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
