package agh.cs.lab7;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{

    private Map<Vector2d, Grass> tufts = new HashMap<>();
    private MapBoundary mapBoundary;

    public GrassField(int n){
        this.mapBoundary = new MapBoundary();
        this.growTufts(n);
    }

    public GrassField(int n, MapBoundary map){
        this.mapBoundary = map;
        this.growTufts(n);
    }

    private void growTufts(int n) {
        for (int i = 0; i < n; i++) {
            int x, y;
            do {
                x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(n * 10));
                y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(n * 10));
            } while (objectAt(new Vector2d(x, y)) instanceof Grass);
            Vector2d position = new Vector2d(x, y);
            tufts.put(position, new Grass(position));
            mapBoundary.addPosition(position); // line responsible for taking grass into account while computing lowerLeft and upperRight
        }
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        if (super.place(animal)) {
            mapBoundary.addPosition(animal.getPosition());
            animal.addObserver(mapBoundary);
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(tufts.containsKey(position)){
            return true;
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (tufts.containsKey(position)){
            return tufts.get(position);
        }
        return super.objectAt(position);
    }

    public Vector2d getLowerLeft() {
        return mapBoundary.getLowerLeft();
    }

    public Vector2d getUpperRight() {
        return mapBoundary.getUpperRight();
    }

}