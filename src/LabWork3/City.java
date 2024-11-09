package LabWork3;

import java.util.LinkedList;

public class City {
    private String name;
    private LinkedList<Path> paths;

    public City(String name) {
        this.name = name;
        this.paths = new LinkedList<>();
    }

    public City(String name, LinkedList<Path> paths) {
        this.name = name;
        this.paths = new LinkedList<>();
        for (Path path : paths) {
            if (!hasPathTo(path.getDestination())) {
                this.paths.add(path);
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(LinkedList<Path> paths) {
        this.paths = new LinkedList<>();
        for (Path path : paths) {
            if (!hasPathTo(path.getDestination())) {
                this.paths.add(path);
            }
        }
    }

    public String getName() {
        return name;
    }

    public LinkedList<Path> getPaths() {
        return new LinkedList<>(paths);
    }

    public boolean hasPathTo(City destination) {
        for (Path path : paths) {
            if (path.getDestination().equals(destination)) {
                return true;
            }
        }
        return false;
    }

    public void addPath(City destination, int cost) {
        if (!hasPathTo(destination)) {
            paths.add(new Path(destination, cost));
        }
    }

    public void removePath(City destination) {
        for (Path path : paths) {
            if (path.getDestination().equals(destination)) {
                paths.remove(path);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Path path : paths) {
            result.append(path).append(", ");
        }
        if (result.length() >= 2) {
            result.delete(result.length() - 2, result.length());
        }

        return name + ": {" + result + "}";
    }
}