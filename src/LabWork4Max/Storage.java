package LabWork4Max;

public class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValueOrDefault(T defaultValue) {
        return (value != null) ? value : defaultValue;
    }
}
