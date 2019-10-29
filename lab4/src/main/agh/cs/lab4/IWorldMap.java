package agh.cs.lab4;

//The interface responsible for interacting with the map of the world.
//Assumes that Vector2d and MoveDirection classes are defined.

public interface IWorldMap {

    boolean canMoveTo(Vector2d position);

    boolean place(Animal animal);

    void run(MoveDirection[] directions);

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);
}
