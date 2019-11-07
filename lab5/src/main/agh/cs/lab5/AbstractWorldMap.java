package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        else return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for(MoveDirection direction : directions) {
            animals.get(i % animals.size()).move(direction);
            i++;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(position.equals(animal.getPosition())) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        return null;
    }
}
