package LabWork5;

public class Line {
    private final Point start;
    private final Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
