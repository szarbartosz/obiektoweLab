import java.util.HashSet;
import java.util.Set;

public class Animal implements IMapElement{

    private MapDirection orientation;
    private Vector2d position;

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }

}