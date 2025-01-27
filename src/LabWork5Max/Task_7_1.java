package LabWork5Max;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_7_1 {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1, 2),
                new Point(2, 3),
                new Point(1, 2),
                new Point(3, -4),
                new Point(2, 3),
                new Point(4, 5)
        );

        Polyline polyline = points.stream()
                .distinct() // Убираем дубликаты
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX())) // Сортируем по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Делаем отрицательные Y положительными
                .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new)); // Собираем в Polyline

        System.out.println(polyline);
    }
}
