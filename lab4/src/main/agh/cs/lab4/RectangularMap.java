package agh.cs.lab4;

import java.util.List;
import java.util.ArrayList;

public class RectangularMap implements IWorldMap{

    private Vector2d lowerLeft;
    private Vector2d upperRight;
    List<Animal> animals = new ArrayList();

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);
    }

    public void mapToString(){
        MapVisualizer map = new MapVisualizer(this);
        System.out.println(map.draw(lowerLeft, upperRight));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position));
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
            animals.get(i).move(direction);
            i++;
            if (i == animals.size()) i = 0;
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
