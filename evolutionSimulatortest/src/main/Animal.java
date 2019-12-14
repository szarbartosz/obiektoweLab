import java.util.EnumMap;
import java.util.Map;

public class Animal implements IMapElement{

    private Vector2d position;
    private Direction orientation;
    private int energy;
    private boolean canMate;
    private String[] DNA;
    private Map<Direction, Double> mapDirectionPreference = new EnumMap<>(Direction.class);


    public Direction getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }

}