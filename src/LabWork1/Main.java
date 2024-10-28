package LabWork1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static Main m = new Main();

    public static void main(String[] args) {

        System.out.println("""

                Добро пожаловать в лабораторную работу №1 по Java, вариант 2 (чётный)
                Работу выполнил Румянцев Владимир""");
        String menu = ("""

                ————————————————————————————————————————————————————————————————

                ———Главное меню———
                
                Доступные действия:
                0. Завершить работу программы
                1. Тема "Методы"
                2. Тема "Условия"
                3. Тема "Циклы"
                4. Тема "Массивы"
                
                Введите число для выбора дальнейшего действия:\s""");
        System.out.print(menu);
        String str = s.next();
        while (true) {
            if (str.equals("0")) {
                System.out.println("\nРабота программы завершена!");
                break;
            } else if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")) {
                m.submenus(Integer.parseInt(str));
                System.out.print(menu);
                str = s.next();
            } else {
                System.out.print("\nПожалуйста, введите число от 0 до 4 для выбора дальнейшего действия: ");
                str = s.next();
            }
        }
    }

    public int sumLastNums (int x) {
        return ((x % 10) + ((x / 10) % 10));
    }

    public boolean isPositive (int x) {
        return (x > 0);
    }

    public boolean isUpperCase (char x) {
        return (('A' <= x) && (x <= 'Z'));
    }

    public boolean isDivisor (int a, int b) {
        return ((a % b == 0) || (b % a == 0));
    }

    public int lastNumSum(int a, int b) {
        return ((a % 10) + (b % 10));
    }

    public double safeDiv (int x, int y) {
        if (y == 0) {
            return 0;
        }
        else {
            return ((double) x / y);
        }
    }

    public String makeDecision (int x, int y) {
        if (x > y) {
            return (x + ">" + y);
        }
        else if (x < y) {
            return (x + "<" + y);
        }
        else {
            return (x + "==" + y);
        }
    }

    public boolean sum3 (int x, int y, int z) {
        return ((x + y == z) || (x + z == y) || (y + z == x));
    }

    public String age (int x) {
        if (((x % 100 >= 11) && (x % 100 <= 14)) || (x % 10 >= 5) || (x % 10 == 0)) {
            return (x + " лет");
        }
        else if (x % 10 == 1) {
            return (x + " год");
        }
        else {
            return (x + " года");
        }
    }

    public void printDays (String x) {
        x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();

        switch (x) {
            case "Понедельник":
                System.out.println(x);
                x = "Вторник";
            case "Вторник":
                System.out.println(x);
                x = "Среда";
            case "Среда":
                System.out.println(x);
                x = "Четверг";
            case "Четверг":
                System.out.println(x);
                x = "Пятница";
            case "Пятница":
                System.out.println(x);
                x = "Суббота";
            case "Суббота":
                System.out.println(x);
                x = "Воскресенье";
            case "Воскресенье":
                System.out.println(x);
                break;
            default:
                System.out.println("Это не день недели");
        }
    }

    public String reverseListNums (int x) {
        StringBuilder returnedString = new StringBuilder();

        while (x >= 0) {
            returnedString.append(" ").append(x);
            x--;
        }

        return returnedString.toString();
    }

    public int pow (int x, int y) {
        int returnedInt = 1;

        for (int i = 0; i < y; i++) {
            returnedInt *= x;
        }

        return returnedInt;
    }

    public boolean equalNum (int x) {
        int y = x % 10;
        x /= 10;

        while (x != 0) {
            if (x % 10 != y) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    public void leftTriangle (int x) {
        for (int i = 1; i <= x; i++) {
            System.out.println("*".repeat(i));
        }
    }

    public void guessGame() {
        int randomNumber = (int) (Math.random() * 10);
        System.out.print("Введите число от 0 до 9: ");
        int userNumber = s.nextInt();
        int score = 1;

        while (randomNumber != userNumber) {
            score += 1;
            System.out.print("Вы не угадали, введите число от 0 до 9: ");
            userNumber = s.nextInt();
        }

        if (((score % 100 >= 11) && (score % 100 <= 14)) || (score % 10 >= 5) || (score % 10 == 0)) {
            System.out.println("Вы угадали!\nВы отгадали число за " + score + " попыток");
        }
        else if (score % 10 == 1) {
            System.out.println("Вы угадали!\nВы отгадали число за " + score + " попытку");
        }
        else {
            System.out.println("Вы угадали!\nВы отгадали число за " + score + " попытки");
        }
    }

    public int findLast (int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int[] add (int[] arr, int x, int pos) {
        int lenArr = arr.length;

        if (pos < 0) {
            pos = 0;
        }
        else if (pos > lenArr) {
            pos = lenArr;
        }

        int[] newArr = new int[lenArr + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        newArr[pos] = x;

        for (int i = pos; i < lenArr; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    public void reverse (int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int key = arr[left];
            arr[left] = arr[right];
            arr[right] = key;
            left++;
            right--;
        }
    }

    public int[] concat (int[] arr1,int[] arr2) {
        int lenArr1 = arr1.length;
        int lenArr2 = arr2.length;
        int[] newArr = new int[lenArr1 + lenArr2];

        for (int i = 0; i < lenArr1; i++) {
            newArr[i] = arr1[i];
        }
        for (int i = 0; i < lenArr2; i++) {
            newArr[i + lenArr1] = arr2[i];
        }
        return newArr;
    }

    public int[] deleteNegative (int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i >= 0) {
                count++;
            }
        }

        int[] newArr = new int[count];

        int j = 0;
        for (int i : arr) {
            if (i >= 0) {
                newArr[j] = i;
                j++;
            }
        }

        return newArr;
    }

    public void submenus (int mode) {
        String menu = "\n————————————————————————————————————————————————————————————————\n\n";
        switch (mode) {
            case 1:
                menu += ("""
                        Тема "Методы"
                        
                        Доступные действия:
                        0. Выход в главное меню
                        2. Задание "Сумма знаков"
                        4. Задание "Есть ли позитив?"
                        6. Задание "Большая буква"
                        8. Задание "Делитель"
                        10. Задание "Многократный вызов"
                        
                        Введите число для выбора дальнейшего действия:\s""");
                break;
            case 2:
                menu += ("""
                        Тема "Условия"
                        
                        Доступные действия:
                        0. Выход в главное меню
                        2. Задание "Безопасное деление"
                        4. Задание "Строка сравнения"
                        6. Задание "Тройная сумма"
                        8. Задание "Возраст"
                        10. Задание "Вывод дней недели"
                        
                        Введите число для выбора дальнейшего действия:\s""");
                break;
            case 3:
                menu += ("""
                        Тема "Циклы"
                        
                        Доступные действия:
                        0. Выход в главное меню
                        2. Задание "Числа наоборот"
                        4. Задание "Степень числа"
                        6. Задание "Одинаковость"
                        8. Задание "Левый треугольник"
                        10. Задание "Угадайка"
                        
                        Введите число для выбора дальнейшего действия:\s""");
                break;
            case 4:
                menu += ("""
                        Тема "Массивы"
                        
                        Доступные действия:
                        0. Выход в главное меню
                        2. Задание "Поиск последнего значения"
                        4. Задание "Добавление в массив"
                        6. Задание "Реверс"
                        8. Задание "Объединение"
                        10. Задание "Удалить негатив"
                        
                        Введите число для выбора дальнейшего действия:\s""");
                break;
        }
        System.out.print(menu);
        String str = s.next();
        int x;
        int y;
        label:
        while (true) {
            switch (str) {
                case "0":
                    System.out.println("\nВыход в главное меню!");
                    break label;
                case "2":
                    switch (mode) {
                        case 1:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Сумма знаков"
                                    
                                    Метод возвращает результат сложения двух последних знаков числа, предполагая, что знаков в числе не менее двух.
                                    Пример:
                                    x=4568
                                    Результат: 14
                                    
                                    Введите число 10 или большее:\s""");
                            x = s.nextInt();
                            while (x < 10) {
                                System.out.print("\nВы ввели однозначное или отрицательное число. " +
                                        "Пожалуйста, введите число 10 или большее: ");
                                x = s.nextInt();
                            }
                            System.out.println("Результат: " + m.sumLastNums(x));
                            break;
                        case 2:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Безопасное деление"
                                    
                                    Метод возвращает деление X на Y, и при этом гарантирует, что не будет выкинута ошибка деления на 0.
                                    При делении на 0 метод возвращает число 0.
                                    
                                    Пример 1:
                                    X=5
                                    Y=0
                                    Результат: 0
                                    
                                    Пример 2:
                                    X=8
                                    Y=2
                                    Результат: 4
                                    
                                    Введите число X:\s""");
                            x = s.nextInt();
                            System.out.print("Введите число Y: ");
                            y = s.nextInt();
                            System.out.println("Результат: " + m.safeDiv(x, y));
                            break;
                        case 3:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Числа наоборот"
                                    
                                    Метод возвращает строку, в которой записаны все числа от X до 0 (включительно).
                                    
                                    Пример:
                                    X=5
                                    
                                    Результат: “5 4 3 2 1 0”
                                    
                                    Введите целое неотрицательное число:\s""");
                            x = s.nextInt();
                            while (x < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                x = s.nextInt();
                            }
                            System.out.println("Результат:" + m.reverseListNums(x));
                            break;
                        case 4:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Поиск последнего значения"
                                    
                                    Метод возвращает индекс последнего вхождения числа X в массив Arr. Если число не входит в массив – возвращается -1.
                                    
                                    Пример:
                                    Arr=[1,2,3,4,2,2,5]
                                    X=2
                                    
                                    Результат: 5
                                                                        
                                    Введите количество объектов в массиве Arr:\s""");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr[i] = s.nextInt();
                            }
                            System.out.print("\nА теперь введите число X: ");
                            System.out.println("Результат: " + m.findLast(arr, s.nextInt()));
                            break;
                    }
                    System.out.print(menu);
                    str = s.next();
                    break;
                case "4":
                    switch (mode) {
                        case 1:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Есть ли позитив?"
                                    
                                    Метод принимает число X и возвращает true, если оно положительное.
                                    
                                    Пример 1:
                                    X=3
                                    Результат: true
                                    
                                    Пример 2:
                                    X=-5
                                    Результат: false
                                    
                                    Введите число:\s""");
                            System.out.println("Результат: " + m.isPositive(s.nextInt()));
                            break;
                        case 2:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Строка сравнения"
                                    
                                    Метод возвращает строку, которая включает два принятых методом числа и корректно выставленный знак операции сравнения (больше, меньше, или равно).
                                    
                                    Пример 1:
                                    X=5
                                    Y=7
                                    Результат: “5<7”
                                    
                                    Пример 2:
                                    X=8
                                    Y=-1
                                    Результат: “8>-1”
                                    
                                    Пример 3:
                                    X=4
                                    Y=4
                                    Результат: “4==4”
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.print("Введите значение Y: ");
                            y = s.nextInt();
                            System.out.println("Результат: " + m.makeDecision(x, y));
                            break;
                        case 3:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Степень числа"
                                    
                                    Метод возвращает результат возведения X в степень Y.
                                    
                                    Пример:
                                    X=2
                                    Y=5
                                    Результат: 32
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.print("Введите значение Y: ");
                            y = s.nextInt();
                            System.out.println("Результат: " + m.pow(x, y));
                            break;
                        case 4:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Добавление в массив"
                                    
                                    Метод возвращает новый массив, который будет содержать все элементы массива Arr, однако в позицию Pos будет вставлено значение X.
                                    
                                    Пример:
                                    Arr=[1,2,3,4,5]
                                    X=9
                                    Pos=3
                                    Результат: [1,2,3,9,4,5]
                                       
                                    Введите количество объектов в массиве Arr:\s""");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr[i] = s.nextInt();
                            }
                            System.out.print("\nА теперь введите число X: ");
                            x = s.nextInt();
                            System.out.print("А теперь введите индекс Pos: ");
                            System.out.println("Результат: " + Arrays.toString(m.add(arr, x, s.nextInt())));
                            break;
                    }
                    System.out.print(menu);
                    str = s.next();
                    break;
                case "6":
                    switch (mode) {
                        case 1:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Большая буква"
                                    
                                    Метод принимает символ X и возвращает true, если это большая буква в диапазоне от ‘A’ до ‘Z’.
                                    
                                    Пример 1:
                                    X=’D’
                                    Результат: true
                                    
                                    Пример 2:
                                    X=’q’
                                    Результат: false
                                    
                                    Введите символ:\s""");
                            String str2 = s.next();
                            while (str2.length() != 1) {
                                System.out.print("\nПожалуйста, введите один символ: ");
                                str2 = s.next();
                            }
                            System.out.println("Результат: " + m.isUpperCase(str2.charAt(0)));
                            break;
                        case 2:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Тройная сумма"
                                    
                                    Метод возвращает true, если два любых числа (из трех принятых) можно сложить так, чтобы получить третье.
                                    
                                    Пример 1:
                                    X=5 Y=7 Z=2
                                    Результат: true
                                    
                                    Пример 2:
                                    X=8 Y=-1 Z=4
                                    Результат: false
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.print("Введите значение Y: ");
                            y = s.nextInt();
                            System.out.print("Введите значение Z: ");
                            System.out.println("Результат: " + m.sum3(x, y, s.nextInt()));
                            break;
                        case 3:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Одинаковость"
                                    
                                    Метод возвращает true, если все знаки числа одинаковы, и false в ином случае.
                                    
                                    Пример 1:
                                    X=1111
                                    Результат: true
                                    
                                    Пример 2:
                                    X=1211
                                    Результат: false
                                    
                                    Введите значение X:\s""");
                            System.out.println("Результат: " + m.equalNum(s.nextInt()));
                            break;
                        case 4:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Реверс"
                                    
                                    Метод изменяет массив Arr. После проведенных изменений массив будет записан задом-наперед.
                                    
                                    Пример:
                                    Arr=[1,2,3,4,5]
                                    
                                    Результат:
                                    Arr=[5,4,3,2,1]
                                    
                                    Введите количество объектов в массиве Arr:\s""");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("Вы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr[i] = s.nextInt();
                            }
                            System.out.println("\nМассив Arr до изменений: " + Arrays.toString(arr));
                            m.reverse(arr);
                            System.out.println("Массив Arr после изменений: " + Arrays.toString(arr));
                            break;
                    }
                    System.out.print(menu);
                    str = s.next();
                    break;
                case "8":
                    switch (mode) {
                        case 1:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Делитель"
                                    
                                    Метод возвращает true, если любое из принятых чисел делит другое нацело.
                                    
                                    Пример 1:
                                    X=3
                                    Y=6
                                    Результат: true
                                    
                                    Пример 2:
                                    X=2
                                    Y=15
                                    Результат: false
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.print("Введите значение Y: ");
                            y = s.nextInt();
                            System.out.println("Результат: " + m.isDivisor(x, y));
                            break;
                        case 2:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Возраст"
                                    
                                    Метод возвращает строку, в которой сначала будет число X, а затем одно из слов: год, года, лет.
                                    
                                    Пример 1:
                                    X=5
                                    Результат: “5 лет”
                                    
                                    Пример 2:
                                    X=31
                                    Результат: “31 год”
                                    
                                    Пример 3:
                                    X=44
                                    Результат: “44 года”
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.println("Результат: " + m.age(x));
                            break;
                        case 3:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Левый треугольник"
                                    
                                    Метод выводит на экран треугольник из символов ‘*’ у которого X символов в высоту, а количество символов в ряду совпадает с номером строки.
                                    
                                    Пример 1:
                                    X=2
                                    Результат:
                                    *
                                    **
                                    
                                    Пример 2:
                                    X=4
                                    Результат:
                                    *
                                    **
                                    ***
                                    ****
                                    
                                    Введите значение X:\s""");
                            x = s.nextInt();
                            System.out.println("Результат:");
                            m.leftTriangle(x);
                            break;
                        case 4:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Объединение"
                                    
                                    Метод возвращает новый массив, в котором сначала идут элементы первого массива (arr1), а затем второго (arr2).
                                    
                                    Пример:
                                    arr1=[1,2,3]
                                    arr2=[7,8,9]
                                    Результат: [1,2,3,7,8,9]
                                    
                                    Введите количество объектов в массиве Arr1:\s""");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr1 = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr1[i] = s.nextInt();
                            }

                            System.out.print("\nВведите количество объектов в массиве Arr2: ");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr2 = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr2[i] = s.nextInt();
                            }
                            System.out.println(
                                    "\nМассив Arr1: " + Arrays.toString(arr1) +
                                    "\nМассив Arr2: " + Arrays.toString(arr2) +
                                    "\nРезультат: " + Arrays.toString(m.concat(arr1, arr2))
                            );
                            break;
                    }
                    System.out.print(menu);
                    str = s.next();
                    break;
                case "10":
                    switch (mode) {
                        case 1:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Многократный вызов"
                                    
                                    Метод считает сумму цифр двух чисел из разряда единиц.
                                    Необходимо последовательно сложить пять чисел и результат вывести на экран.
                                    
                                    Пример:
                                    5+11 это 6
                                    6+123 это 9
                                    9+14 это 13
                                    13+1 это 4
                                    Результат: 4
                                    
                                    Введите первое число:\s""");
                            x = s.nextInt();
                            System.out.print("Введите второе число: ");
                            y = s.nextInt();
                            int rez = m.lastNumSum(x, y);
                            for (int i = 0; i < 3; i++) {
                                System.out.print(x + "+" + y + " это " + rez + "\nВведите следующее число: ");
                                x = rez;
                                y = s.nextInt();
                                rez = m.lastNumSum(x, y);
                            }
                            System.out.print(x + "+" + y + " это " + rez + "\nРезультат: " + rez);
                            break;
                        case 2:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Вывод дней недели"
                                    
                                    Метод выводит на экран название переданного в него дня недели и всех последующих до конца недели.
                                    Если в качестве строки передан не день, то выводится текст “это не день недели”.
                                    
                                    Пример 1:
                                    X=”четверг”
                                    Результат:
                                    Четверг
                                    Пятница
                                    Суббота
                                    Воскресенье
                                    
                                    Пример 2:
                                    X=”чг”
                                    Результат:
                                    Это не день недели
                                    
                                    Введите день недели:\s""");
                            str = s.next();
                            System.out.println("Результат:");
                            m.printDays(str);
                            break;
                        case 3:
                            System.out.println("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Угадайка"
                                    
                                    Метод загадывает случайное число от 0 до 9 (включительно), далее ждёт, пока Вы угадаете его.
                                    После этого будет выведено количество попыток, которое Вам потребовалось, чтобы угадать число.
                                    
                                    Пример:
                                    Введите число от 0 до 9: 5
                                    Вы не угадали, введите число от 0 до 9: 9
                                    Вы угадали!
                                    Вы отгадали число за 2 попытки.
                                    
                                    Компьютер уже загадал число!""");
                            m.guessGame();
                            break;
                        case 4:
                            System.out.print("""

                                    ————————————————————————————————————————————————————————————————

                                    Задание "Удалить негатив"
                                    
                                    Метод возвращает новый массив, в котором записаны все элементы массива Arr кроме отрицательных.
                                    
                                    Пример:
                                    Arr=[1,2,-3,4,-2,2,-5]
                                    Результат: [1,2,4,2]
                                    
                                    Введите количество объектов в массиве Arr:\s""");
                            y = s.nextInt();
                            while (y < 0) {
                                System.out.print("\nВы ввели отрицательное число. " +
                                        "Пожалуйста, введите неотрицательное число: ");
                                y = s.nextInt();
                            }
                            int[] arr = new int[y];
                            for (int i = 0; i < y; i++) {
                                System.out.print("Введите число для индекса " + i + ": ");
                                arr[i] = s.nextInt();
                            }
                            System.out.println("\nМассив Arr до изменений: " + Arrays.toString(arr) +
                                    "\nМассив Arr после изменений: " + Arrays.toString(m.deleteNegative(arr)));
                            break;
                    }
                    System.out.print(menu);
                    str = s.next();
                    break;
                default:
                    System.out.print("\nПожалуйста, введите число для выбора соответствующего доступного действия: ");
                    str = s.next();
                    break;
            }
        }
    }
}
