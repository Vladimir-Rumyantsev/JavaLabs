package LabWork3.ru.rumyantsev.geo;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private City startCity;
    private City endCity;

    public Route(City startCity, City endCity) {
        if (startCity == null || endCity == null) {
            throw new IllegalArgumentException("Start and end cities must not be null");
        }
        this.startCity = startCity;
        this.endCity = endCity;
    }

    public void setStartCity(City startCity) {
        if (startCity == null) {
            throw new IllegalArgumentException("Start city must not be null");
        }
        this.startCity = startCity;
    }

    public void setEndCity(City endCity) {
        if (endCity == null) {
            throw new IllegalArgumentException("End city must not be null");
        }
        this.endCity = endCity;
    }

    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public City[] getRoute() {
        List<City> route = new ArrayList<>();
        if (findRoute(startCity, endCity, route)) {
            return route.toArray(new City[0]);
        } else {
            return new City[0];
        }
    }

    private boolean findRoute(City current, City destination, List<City> route) {
        route.add(current);

        if (current.equals(destination)) {
            return true;
        }

        for (Path path : current.getPaths()) {
            City nextCity = path.getDestination();
            if (!route.contains(nextCity)) {
                if (findRoute(nextCity, destination, route)) {
                    return true;
                }
            }
        }

        route.remove(route.size() - 1);
        return false;
    }

    @Override
    public String toString() {
        City[] route = getRoute();
        if (route.length == 0) {
            return "No route found";
        }

        StringBuilder sb = new StringBuilder();
        for (City city : route) {
            sb.append(city.getName()).append(" -> ");
        }
        sb.delete(sb.length() - 4, sb.length());
        return sb.toString();
    }
}
