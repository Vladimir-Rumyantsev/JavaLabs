package LabWork2;

public class Path {
    private City destination;
    private int cost;

    public Path(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public String toString() {
        return destination.getName() + ": " + cost;
    }
}
