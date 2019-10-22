package agh.cs.lab3;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    Vector2d minVector = new Vector2d(0,0);
    Vector2d maxVector = new Vector2d(4,4);
    Vector2d tmp = null;

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
                    this.orientation = (this.orientation.next());
                    System.out.println(this.toString());
                    break;
                case LEFT:
                    this.orientation = (this.orientation.previous());
                    System.out.println(this.toString());
                    break;
                case FORWARD:
                    tmp = this.position.add(this.orientation.toUnitVector());
                    if(tmp.follows(minVector) && tmp.precedes(maxVector)) {
                        this.position = tmp;
                        System.out.println(this.toString());
                    }
                    else{
                        System.out.println("wstrzymano przed wyjsciem poza mape");
                    }
                    break;
                case BACKWARD:
                    tmp = this.position.subtract(this.orientation.toUnitVector());
                    if(tmp.follows(minVector) && tmp.precedes(maxVector)){
                        this.position = tmp;
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
