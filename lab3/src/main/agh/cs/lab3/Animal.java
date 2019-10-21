package agh.cs.lab3;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return ("posiiton: (" + String.valueOf(this.position.x) + "," + String.valueOf(this.position.y) + ")" + "   "
                + "orientation: " + this.orientation);
    }

    public void move(MoveDirection[] directions){
        for(MoveDirection direction : directions){
            switch(direction){
                case RIGHT:
                    this.orientation = MapDirection.EAST;
                    System.out.println(this.toString());
                    break;
                case LEFT:
                    this.orientation = MapDirection.WEST;
                    System.out.println(this.toString());
                    break;
                case FORWARD:
                    this.orientation = MapDirection.NORTH;
                    if(this.position.y != 4) {
                        this.position = this.position.add(new Vector2d(0, 1));
                        System.out.println(this.toString());
                    }
                    else{
                        System.out.println("wstrzymano przed wyjsciem poza mape");
                    }
                    break;
                case BACKWARD:
                    this.orientation = MapDirection.SOUTH;
                    if(this.position.y != 0){
                        this.position = this.position.add(new Vector2d(0,-1));
                        System.out.println(this.toString());;
                    }
                    else{
                        System.out.println("wstrzymano przed wyjsciem poza mape");
                    }
                    break;
                default:
                    System.out.println("nie rozpoznano argumentu");
            }
        }
    }
}
