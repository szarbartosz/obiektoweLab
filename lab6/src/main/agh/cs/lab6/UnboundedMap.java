package agh.cs.lab6;

import java.util.Collection;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap {

    private List<HayStack> stacks;

    public UnboundedMap(List stacks){
        this.stacks = stacks;
    }

    @Override
    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Collection<Animal> temporaryAnimals = animals.values();
        Animal[] superAnimals = temporaryAnimals.toArray(new Animal[temporaryAnimals.size()]);
        for(Animal animal : superAnimals){
            lowerLeft = animal.getPosition().lowerLeft(lowerLeft);
            upperRight = animal.getPosition().upperRight(upperRight);
        }
        for(HayStack stack : stacks){
            lowerLeft = stack.getPosition().lowerLeft(lowerLeft);
            upperRight = stack.getPosition().upperRight(upperRight);
        }
        return map.draw(lowerLeft, upperRight);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(HayStack stack : stacks){
            if(position.equals(stack.getPosition())) return true;
        }
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(HayStack stack : stacks){
            if(position.equals(stack.getPosition())) return stack;
        }
        return super.objectAt(position);
    }
}