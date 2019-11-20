package agh.cs.lab7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GrassFieldTest {
    private List<Grass> tufts = new ArrayList<>();
    private IWorldMap map = new GrassField(4);

    @Test
    public void canMoveToTest() {
        Animal duck = new Animal(map, new Vector2d(-4, -5));
        map.place(duck);
        assertFalse(map.canMoveTo(new Vector2d(-4, -5)));
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
    }

    @Test
    public void placeTest() {
        Animal duck = new Animal(map, new Vector2d(-4, -5));
        assertTrue(map.place(duck));
    }

    @Test
    public void runTest() {
        Animal duck = new Animal(map);
        Animal snail = new Animal(map, new Vector2d(3, 4));
        map.place(duck);
        map.place(snail);
        tufts.add(new Grass(new Vector2d(-4, -4)));
        tufts.add(new Grass(new Vector2d(7, 7)));
        tufts.add(new Grass(new Vector2d(3, 6)));
        tufts.add(new Grass(new Vector2d(2, 0)));
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l"});
        map.run(directions);
        assertEquals(new Vector2d(2, 3), duck.getPosition());
        assertEquals(new Vector2d(3, 3), snail.getPosition());
        directions = new OptionsParser().parse(new String[]{"f", "f", "r", "r"});
        map.run(directions);
        assertEquals(new Vector2d(2, 3), duck.getPosition());
        assertEquals(new Vector2d(3, 3), snail.getPosition());
        directions = new OptionsParser().parse(new String[]{"f", "f", "f", "f"});
        map.run(directions);
        assertEquals(new Vector2d(2, 1), duck.getPosition());
        assertEquals(new Vector2d(3, 5), snail.getPosition());
        directions = new OptionsParser().parse(new String[]{"f", "f", "f", "f"});
        map.run(directions);
        assertEquals(new Vector2d(2, -1), duck.getPosition());
        assertNotEquals(new Vector2d(2, 1), duck.getPosition());
        assertEquals(new Vector2d(3, 7), snail.getPosition());
        assertNotEquals(new Vector2d(3, 5), snail.getPosition());

    }

    @Test
    public void isOccupiedTest() {
        Animal duck = new Animal(map, new Vector2d(0, 0));
        map.place(duck);
        assertFalse(map.isOccupied(new Vector2d(1, 1)));
        assertTrue(map.isOccupied(duck.getPosition()));
    }

    @Test
    public void objectAtTest() {
        Animal duck = new Animal(map, new Vector2d(-4, -5));
        map.place(duck);
        Grass hs = new Grass(new Vector2d(-4, -4));
        tufts.add(hs);
        assertEquals(duck, map.objectAt(new Vector2d(-4, -5)));
        assertNotEquals(hs, map.objectAt(duck.getPosition()));
    }
}
