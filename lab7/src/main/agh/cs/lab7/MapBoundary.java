package agh.cs.lab7;

import java.util.Comparator;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver{
    private TreeSet<Vector2d> xTreeSet = new TreeSet<>(Comparator.comparingInt(o -> o.x));
    private TreeSet<Vector2d> yTreeSet = new TreeSet<>(Comparator.comparingInt(o -> o.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xTreeSet.remove(oldPosition);
        yTreeSet.remove(oldPosition);
        xTreeSet.add(newPosition);
        yTreeSet.add(newPosition);
    }

    public void addPosition(Vector2d position) {
        xTreeSet.add(position);
        yTreeSet.add(position);
    }

    public void removePosition(Vector2d position) {
        xTreeSet.remove(position);
        yTreeSet.remove(position);
    }

    public Vector2d getLowerLeft() {
        return xTreeSet.first().lowerLeft(yTreeSet.first());
    }

    public Vector2d getUpperRight() {

        return xTreeSet.last().upperRight(yTreeSet.last());
    }
}
