package agh.cs.lab7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MapBoundaryTest {
    MapBoundary mapBoundary = new MapBoundary();
    GrassField grassField = new GrassField(0, mapBoundary);

    @Test
    public void getLowerLeft() {
        mapBoundary.addPosition(new Vector2d(2, 2));
        mapBoundary.addPosition(new Vector2d(2, 5));
        mapBoundary.addPosition(new Vector2d(-2, 2));
        assertEquals(new Vector2d(-2, 2), mapBoundary.getLowerLeft());
        mapBoundary.addPosition(new Vector2d(-5, 2));
        assertNotEquals(new Vector2d(-2, 2), mapBoundary.getLowerLeft());
        assertEquals(new Vector2d(-5, 2), mapBoundary.getLowerLeft());
        mapBoundary.removePosition(new Vector2d(-5, 2));
        assertNotEquals(new Vector2d(-5, 2), mapBoundary.getLowerLeft());
        assertEquals(new Vector2d(-2, 2), mapBoundary.getLowerLeft());
    }

    @Test
    public void getUpperRight() {
        mapBoundary.addPosition(new Vector2d(0, 0));
        mapBoundary.addPosition(new Vector2d(-1, 1));
        mapBoundary.addPosition(new Vector2d(0, 2));
        assertEquals(new Vector2d(0, 2), mapBoundary.getUpperRight());
        mapBoundary.addPosition(new Vector2d(10, -3));
        assertNotEquals(new Vector2d(0, 2), mapBoundary.getUpperRight());
        assertEquals(new Vector2d(10, 2), mapBoundary.getUpperRight());
        mapBoundary.removePosition(new Vector2d(10, -3));
        assertNotEquals(new Vector2d(10, 2), mapBoundary.getUpperRight());
        assertEquals(new Vector2d(0, 2), mapBoundary.getUpperRight());
    }

    @Test
    public void addingAnimalsTest() {
        Animal animal1 = new Animal(grassField, new Vector2d(2, 2));
        grassField.place(animal1);
        assertEquals(new Vector2d(2, 2), mapBoundary.getUpperRight());
        assertEquals(new Vector2d(2, 2), mapBoundary.getLowerLeft());
        Animal animal2 = new Animal(grassField, new Vector2d(-2, 0));
        grassField.place(animal2);
        assertEquals(new Vector2d(2, 2), mapBoundary.getUpperRight());
        assertEquals(new Vector2d(-2, 0), mapBoundary.getLowerLeft());
    }

    @Test
    public void movingAnimalsTest() {
        Animal animal1 = new Animal(grassField, new Vector2d(2, 2));
        grassField.place(animal1);
        grassField.run(new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD});
        assertEquals(new Vector2d(3, 4), mapBoundary.getUpperRight());
        Animal animal2 = new Animal(grassField, new Vector2d(0, 0));
        grassField.place(animal2);
        assertEquals(new Vector2d(3, 4), mapBoundary.getUpperRight());
        assertEquals(new Vector2d(0, 0), mapBoundary.getLowerLeft());
        grassField.run(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD});
        assertEquals(new Vector2d(0, -2), mapBoundary.getLowerLeft());
    }
}
