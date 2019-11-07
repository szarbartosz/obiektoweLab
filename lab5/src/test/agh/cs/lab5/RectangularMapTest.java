package agh.cs.lab5;

import org.junit.Assert;
import org.junit.Test;

public class RectangularMapTest {

    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);
    IWorldMap map = new RectangularMap(10, 5);
    Animal duck = new Animal(map, new Vector2d(3,4));
    Animal parrot = new Animal(map, new Vector2d(3,4));
    Animal snail = new Animal(map, new Vector2d(11,2));
    Animal turtle = new Animal(map);
    Vector2d vec1 = new Vector2d(2,0);
    Vector2d vec2 = new Vector2d(3,5);
    Vector2d vec3 = new Vector2d(1,1);
    Vector2d vec4 = new Vector2d(3,4);

    @Test
    public void placeTest(){
        Assert.assertTrue(map.place(duck));
        Assert.assertFalse(map.place(parrot));
        Assert.assertFalse(map.place(snail));
    }

    @Test
    public void runTest(){
        map.place(turtle);
        map.place(duck);
        map.run(directions);
        Assert.assertEquals(turtle.getPosition(), vec1);
        Assert.assertEquals(duck.getPosition(), vec2);
    }

    @Test
    public void canMoveToTest(){
        map.place(duck);
        Assert.assertTrue(map.canMoveTo(vec3));
        Assert.assertFalse(map.canMoveTo(vec4));
    }

    @Test
    public void isOccupiedTest(){
        map.place(duck);
        Assert.assertTrue(map.isOccupied(duck.getPosition()));
        Assert.assertFalse(map.isOccupied(vec3));
    }

    @Test
    public void objectAtTest(){
        map.place(duck);
        Assert.assertEquals(map.objectAt(new Vector2d(3,4)), duck);
        Assert.assertNotEquals(map.objectAt(vec3), duck);
    }

}
