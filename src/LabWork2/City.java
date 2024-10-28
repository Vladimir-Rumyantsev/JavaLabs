package LabWork2;

public class City {
    private String name;
    private Path[] paths;

    public City(String name) {
        this.name = name;
        this.paths = null;
    }

    public void setPath(Path[] paths) {
        this.paths = paths;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(name + "\n");
        for (Path path : paths) {
            result.append("  ").append(path.toString()).append("\n");
        }
        return result.toString();
    }
}
