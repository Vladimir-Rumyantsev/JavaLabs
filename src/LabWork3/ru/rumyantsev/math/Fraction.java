package LabWork3.ru.rumyantsev.math;

public final class Fraction extends Number {
    private final int numerator;
    private final int denominator;

    // Конструктор для создания дроби с указанием числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Конструктор для создания дроби только с указанием числителя
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    // Метод для получения строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод для сложения двух дробей
    public Fraction sum(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для сложения дроби с целым числом
    public Fraction sum(int number) {
        return sum(new Fraction(number));
    }

    // Метод для вычитания двух дробей
    public Fraction minus(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для вычитания дроби с целым числом
    public Fraction minus(int number) {
        return minus(new Fraction(number));
    }

    // Метод для умножения двух дробей
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для умножения дроби на целое число
    public Fraction multiply(int number) {
        return multiply(new Fraction(number));
    }

    // Метод для деления двух дробей
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        return multiply(new Fraction(other.denominator, other.numerator));
    }

    // Метод для деления дроби на целое число
    public Fraction div(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        return div(new Fraction(number));
    }

    // Метод для нахождения наибольшего общего делителя (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Реализация методов, наследуемых от класса Number
    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public byte byteValue() {
        return (byte) (numerator / denominator);
    }

    @Override
    public short shortValue() {
        return (short) (numerator / denominator);
    }

    // Переопределение метода clone
    @Override
    public Fraction clone() {
        return new Fraction(this.numerator, this.denominator);
    }
}
