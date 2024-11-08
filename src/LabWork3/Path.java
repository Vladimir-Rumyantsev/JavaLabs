package LabWork3;

public class Path {
    private final City destination;
    private final int cost;

    public Path(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    public City getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        return "(" + destination.getName() + ": " + cost + ")";
    }
}
