package LabWork3.ru.rumyantsev.geo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Path path = (Path) obj;
        return cost == path.cost && Objects.equals(destination.getName(), path.destination.getName());
    }

    @Override
    public int hashCode() {
        int result = destination.hashCode();
        result = 31 * result + cost;
        return result;
    }

    @Override
    public String toString() {
        return "(" + destination.getName() + ": " + cost + ")";
    }
}
