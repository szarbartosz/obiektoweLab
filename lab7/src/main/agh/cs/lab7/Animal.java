package agh.cs.lab7;

import java.util.HashSet;
import java.util.Set;

public class Animal implements IMapElement{

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private Set<IPositionChangeObserver> observers = new HashSet<>();
    Vector2d newPosition = null;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        addObserver(map);
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT:
                this.orientation = (this.orientation.next());
                System.out.println(this.toString());
                break;
            case LEFT:
                this.orientation = (this.orientation.previous());
                System.out.println(this.toString());
                break;
            case FORWARD:
                newPosition = this.position.add(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    for(IPositionChangeObserver observer : observers){
                        observer.positionChanged(this.getPosition(),newPosition);
                    }
                    System.out.println(this.toString());
                }
                else{
                    if(this.map.isOccupied(newPosition)) System.out.println("position occupied!");
                    else System.out.println("protected from falling off the cliff!");
                }
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                if(this.map.canMoveTo(newPosition)){
                    this.position = newPosition;
                    for(IPositionChangeObserver observer : observers){
                        observer.positionChanged(this.getPosition(),newPosition);
                    }
                    System.out.println(this.toString());
                }
                else{
                    if(this.map.isOccupied(newPosition)) System.out.println("position occupied!");
                    else System.out.println("protected from falling off the cliff!");
                }
                break;
            default:
                System.out.println("unknown argument");
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    @Override
    public String toString(){
        switch(this.orientation){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            case WEST:
                return "W";
            default:
                return"";
        }
    }
}