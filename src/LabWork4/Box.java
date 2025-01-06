package LabWork4;

public class Box<T> {
    private T content;

    // Метод для размещения объекта в коробку
    public void put(T item) {
        if (content != null) {
            throw new IllegalStateException("Box is already occupied");
        }
        content = item;
    }

    // Метод для извлечения объекта из коробки
    public T take() {
        T item = content;
        content = null;
        return item;
    }

    // Метод для проверки на заполненность
    public boolean isEmpty() {
        return content == null;
    }

    // Метод для получения значения без извлечения
    public T get() {
        return content;
    }
}
