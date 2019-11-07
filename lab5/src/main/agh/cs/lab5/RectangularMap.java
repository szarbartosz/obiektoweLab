package agh.cs.lab5;

public class RectangularMap extends AbstractWorldMap implements IWorldMap{

    private Vector2d lowerLeft;
    private Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);
    }

    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(lowerLeft) && position.precedes(upperRight) && super.canMoveTo(position));
    }
}
