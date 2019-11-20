package agh.cs.lab7;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class RectangularMapTest {
    private IWorldMap map = new RectangularMap(10, 5);

    @Test
    public void run() {
        Animal duck = new Animal(map);
        Animal snail = new Animal(map, new Vector2d(3, 4));
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "r", "r", "b"});
        map.place(duck);
        map.place(snail);
        assertEquals(duck, map.objectAt(duck.getPosition()));
        assertEquals(snail, map.objectAt(snail.getPosition()));
        map.run(directions);

        assertEquals(new Vector2d(2, 3), duck.getPosition());
        assertEquals(new Vector2d(2, 4), snail.getPosition());

        directions = new OptionsParser().parse(new String[]{"b", "b", "b"});

        map.run(directions);
        assertEquals(new Vector2d(0, 3), duck.getPosition());
        assertEquals(new Vector2d(1, 4), snail.getPosition());

        directions = new OptionsParser().parse(new String[]{"b", "r", "l"});

        map.run(directions);
        assertEquals(new Vector2d(0, 3), duck.getPosition());
        assertEquals(new Vector2d(1, 4), snail.getPosition());

        directions = new OptionsParser().parse(new String[]{"f", "f", "f", "f", "f", "f", "f", "f", "f", "f"});

        map.run(directions);
        assertEquals(new Vector2d(0, 5), duck.getPosition());
        assertEquals(new Vector2d(1, 0), snail.getPosition());

        assertTrue(map.isOccupied(duck.getPosition()));
        assertTrue(map.isOccupied(snail.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(9, 7)));
    }

    @Test
    public void place() {
        Animal duck = new Animal(map, new Vector2d(0, 0));
        Animal snail = new Animal(map, new Vector2d(1, 1));
        assertTrue(map.place(duck));
        assertTrue(map.place(snail));
    }

    @Test
    public void canMoveTo() {
        Animal duck = new Animal(map, new Vector2d(2, 3));
        map.place(duck);
        assertFalse(map.canMoveTo(new Vector2d(-4, -4)));
        assertFalse(map.canMoveTo(duck.getPosition()));
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
    }

    @Test
    public void isOccupied() {
        Animal duck = new Animal(map, new Vector2d(0, 0));
        map.place(duck);
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
        assertTrue(map.isOccupied(duck.getPosition()));
    }

    @Test
    public void objectAt() {
        Animal duck = new Animal(map, new Vector2d(1, 0));
        Animal snail = new Animal(map, new Vector2d(2, 5));
        map.place(duck);
        map.place(snail);
        assertEquals(duck, map.objectAt(new Vector2d(1, 0)));
        assertNotEquals(snail, map.objectAt(duck.getPosition()));
    }
}
