package agh.cs.lab5;

public class Animal{

    private MapDirection orientation;
    private Vector2d position;
    Vector2d tmp = null;
    private IWorldMap map;

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
    }

    public MapDirection getOrientation() {

        return this.orientation;
    }

    public Vector2d getPosition() {

        return this.position;
    }

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
                tmp = this.position.add(this.orientation.toUnitVector());
                if(this.map.canMoveTo(tmp)) {
                    this.position = tmp;
                    System.out.println(this.toString());
                }
                else{
                    if(this.map.isOccupied(tmp)) System.out.println("position occupied!");
                    else System.out.println("protected from falling off the cliff!");
                }
                break;
            case BACKWARD:
                tmp = this.position.subtract(this.orientation.toUnitVector());
                if(this.map.canMoveTo(tmp)){
                    this.position = tmp;
                    System.out.println(this.toString());
                }
                else{
                    if(this.map.isOccupied(tmp)) System.out.println("position occupied!");
                    else System.out.println("protected from falling off the cliff!");
                }
                break;
            default:
                System.out.println("unknown argument");
        }
    }
}
