public class RectangularMap extends AbstractWorldMap{

    private Vector2d lowerLeft;
    private Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);
    }

    public Vector2d getLowerLeft() {
        return lowerLeft;
    }

    public Vector2d getUpperRight() {
        return upperRight;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(lowerLeft) && position.precedes(upperRight) && super.canMoveTo(position));
    }
}
