package agh.cs.lab6;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{

    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            return true;
        }
        else throw new IllegalArgumentException( "\"" + animal.getPosition().toString() + "\" " + "is occupied");
    }

    @Override
    public void run(MoveDirection[] directions) {
        List<Animal> tmpAnimals = new LinkedList<>(animals.values());
        int i = 0;
        Vector2d positionBefore = null;
        Vector2d positionAfter = null;
        for(MoveDirection direction : directions) {
            Animal tmpAnimal = tmpAnimals.get(i % animals.size());
            positionBefore = tmpAnimal.getPosition();
            tmpAnimal.move(direction);
            positionAfter = tmpAnimal.getPosition();
            if(positionBefore != positionAfter){
                animals.remove(positionBefore);
                animals.put(positionAfter, tmpAnimal);
            }
            i++;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        }
        return null;
    }
}