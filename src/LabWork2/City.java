package LabWork2;

public class City {
    private final String name;
    private Path[] paths;

    public City(String name) {
        this.name = name;
        this.paths = null;
    }

    public City(String name, Path[] paths) {
        this.name = name;
        this.paths = paths;
    }

    public void setPath(Path[] paths) {
        this.paths = paths;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(name + ": {");
        for (Path path : paths) {
            result.append(path.toString() + ", ");
        }
        if (result.length() >= 2) {
            result.delete(result.length() - 2, result.length());
        }

        return result.append("}").toString();
    }
}
