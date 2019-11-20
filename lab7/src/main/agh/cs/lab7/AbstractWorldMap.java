package agh.cs.lab7;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{

    protected Map<Vector2d, Animal> occupiedPositions = new HashMap<>();
    protected List<Animal> animals = new ArrayList<>();
    MapVisualizer mapVisualizer = new MapVisualizer(this);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = occupiedPositions.get(oldPosition);
        occupiedPositions.remove(oldPosition);
        occupiedPositions.put(newPosition, animal);
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for(MoveDirection direction : directions) {
            Animal tmpAnimal = animals.get(i % animals.size());
            Vector2d hashKey = tmpAnimal.getPosition();
            occupiedPositions.remove(hashKey);
            tmpAnimal.move(direction);
            occupiedPositions.put(tmpAnimal.getPosition(), tmpAnimal);
            i++;
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            occupiedPositions.put(animal.getPosition(),animal);
            return true;
        }
        else throw new IllegalArgumentException( "\"" + animal.getPosition().toString() + "\" " + "is occupied");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return occupiedPositions.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (occupiedPositions.containsKey(position)){
            return occupiedPositions.get(position);
        }
        return null;
    }

    abstract public Vector2d getLowerLeft();
    abstract public Vector2d getUpperRight();

    @Override
    public String toString() {
        return this.mapVisualizer.draw(getLowerLeft(), getUpperRight());
    }
}