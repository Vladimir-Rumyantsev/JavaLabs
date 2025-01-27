package LabWork4;

import java.util.List;

public class Task_2_2 {
    public static void main(String[] args) {

        // Задание 2.2

        Box<Integer> intBox = new Box<>();
        intBox.put(3);

        Box<Double> doubleBox = new Box<>();
        doubleBox.put(5.5);

        Box<Float> floatBox = new Box<>();
        floatBox.put(4.5f);

        List<Box<? extends Number>> boxes = List.of(intBox, doubleBox, floatBox);

        double maxValue = findMaxValue(boxes);
        System.out.println("\nЗадание 2.2:\nMaximum value: " + maxValue);
    }

    public static double findMaxValue(List<Box<? extends Number>> boxes) {
        double maxValue = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> box : boxes) {
            if (!box.isEmpty()) {
                double value = box.get().doubleValue();
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }

        if (maxValue == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("All boxes are empty or the list is empty");
        }

        return maxValue;
    }
}
