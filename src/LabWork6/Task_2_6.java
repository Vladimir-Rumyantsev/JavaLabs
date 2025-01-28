package LabWork6;

@Cache(value = {"key1", "key2"})
public class Task_2_6 {

    public static void main(String[] args) {
        // Пример использования аннотированного класса
        Task_2_6 example = new Task_2_6();
        System.out.println("Класс Task_2_6 аннотирован @Cache с значениями \"key1\" и \"key2\"");

        // Добавление новых значений в аннотацию @Cache
        addCacheValues("key3", "key4");
    }

    private static void addCacheValues(String... newValues) {
        Cache cacheAnnotation = Task_2_6.class.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            String[] currentValues = cacheAnnotation.value();
            String[] newCacheValues = new String[currentValues.length + newValues.length];
            System.arraycopy(currentValues, 0, newCacheValues, 0, currentValues.length);
            System.arraycopy(newValues, 0, newCacheValues, currentValues.length, newValues.length);

            System.out.println("Новые значения в аннотации @Cache:");
            for (String value : newCacheValues) {
                System.out.println(value);
            }
        }
    }
}
