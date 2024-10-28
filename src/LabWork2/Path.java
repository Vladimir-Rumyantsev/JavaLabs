package LabWork2;

public class Path {
    private final City destination;
    private final int cost;

    public Path(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public String toString() {
        return "(" + destination.getName() + ": " + cost + ")";
    }
}
