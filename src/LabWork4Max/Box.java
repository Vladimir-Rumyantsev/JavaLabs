package LabWork4Max;

public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public void setItem(T input) {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка не пуста");
        }
        this.item = input;
    }

    public T getItem() {
        if (isEmpty()) {
            throw new IllegalStateException("В коробке ничего нет");
        }
        T temp = this.item;
        this.item = null;
        return temp;
    }

    public boolean isEmpty() {
        return this.item == null;
    }
}