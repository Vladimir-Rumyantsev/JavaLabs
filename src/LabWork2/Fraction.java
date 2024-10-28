package LabWork2;

public class Fraction {
    private int numerator;
    private int denominator;

    // Конструктор для создания дроби с указанием числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Конструктор для создания дроби только с указанием числителя
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    // Метод для получения строкового представления дроби
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

    // Метод для сокращения дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
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
}