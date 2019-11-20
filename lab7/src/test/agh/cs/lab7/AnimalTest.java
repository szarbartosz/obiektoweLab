package agh.cs.lab7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private Animal duck = new Animal(new RectangularMap(4, 4));
    private OptionsParser parser = new OptionsParser();

    @Test
    public void orientationTest() {
        assertEquals(duck.getOrientation(), MapDirection.NORTH);
        duck.move(MoveDirection.RIGHT);
        assertEquals(duck.getOrientation(), MapDirection.EAST);
        duck.move(MoveDirection.RIGHT);
        assertEquals(duck.getOrientation(), MapDirection.SOUTH);
        duck.move(MoveDirection.RIGHT);
        assertEquals(duck.getOrientation(), MapDirection.WEST);
        duck.move(MoveDirection.LEFT);
        assertEquals(duck.getOrientation(), MapDirection.SOUTH);
    }

    @Test
    public void moveAnimalTest() {
        Assert.assertEquals("N", duck.toString());
        duck.move(MoveDirection.RIGHT);
        duck.move(MoveDirection.RIGHT);
        duck.move(MoveDirection.FORWARD);
        duck.move(MoveDirection.FORWARD);
        Assert.assertEquals("S", duck.toString());
        duck.move(MoveDirection.RIGHT);
        duck.move(MoveDirection.BACKWARD);
        duck.move(MoveDirection.BACKWARD);
        duck.move(MoveDirection.BACKWARD);
        assertEquals("W", duck.toString());
        Assert.assertNotEquals("S", duck.toString());
    }

    @Test
    public void properParseTest() {
        String[] directions = new String[]{"l", "b", "r", "r", "f"};
        MoveDirection[] properDirections = new MoveDirection[]{
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD
        };

        Assert.assertArrayEquals(parser.parse(directions), properDirections);
    }

    @Test
    public void moveAnimalProperParseTest() {
        String[] args = new String[]{"left", "r", "b", "forward", "forward"};
        MoveDirection[] directions = parser.parse(args);
        for (MoveDirection direction : directions) {
            duck.move(direction);
        }
        Assert.assertNotEquals("E", duck.toString());
        Assert.assertEquals("N", duck.toString());
    }
}
