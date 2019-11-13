package agh.cs.lab6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMapTest {

    IWorldMap mapGenerator(){
        List<HayStack> stacks = new ArrayList();
        stacks.add(new HayStack(new Vector2d(-4,-4)));
        stacks.add(new HayStack(new Vector2d(7,7)));
        stacks.add(new HayStack(new Vector2d(3,6)));
        stacks.add(new HayStack(new Vector2d(2,0)));
        stacks.add(new HayStack(new Vector2d(4,3)));
        stacks.add(new HayStack(new Vector2d(8,1)));
        IWorldMap map = new UnboundedMap(stacks);
        return map;
    }

    IWorldMap map = mapGenerator();

    String[] args = {"f", "f", "f", "r", "f", "l", "f", "l", "f", "r", "f", "f", "f", "r", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);
    Animal duck = new Animal(map, new Vector2d(3,4));
    Animal parrot = new Animal(map, new Vector2d(3,4));
    Animal snail = new Animal(map, new Vector2d(11,6));
    Animal bear = new Animal(map, new Vector2d(8,1));
    Animal turtle = new Animal(map);
    Vector2d vec1 = new Vector2d(3,1);
    Vector2d vec2 = new Vector2d(2,6);
    Vector2d vec3 = new Vector2d(8,7);
    Vector2d vec4 = new Vector2d(5,2);
    Vector2d vec5 = new Vector2d(8,1);


    @Test
    public void placeTest(){
        Assert.assertTrue(map.place(duck));
        Assert.assertTrue(map.place(snail));

    }

    @Test
    public void runTest(){
        map.place(turtle);
        map.place(duck);
        map.place(snail);
        map.run(directions);
        Assert.assertEquals(turtle.getPosition(), vec1);
        Assert.assertEquals(duck.getPosition(), vec2);
        Assert.assertEquals(snail.getPosition(), vec3);
    }

    @Test
    public void canMoveToTest(){
        map.place(duck);
        Assert.assertTrue(map.canMoveTo(vec4));
        Assert.assertFalse(map.canMoveTo(vec5));
    }

    @Test
    public void isOccupiedTest(){
        map.place(duck);
        Assert.assertTrue(map.isOccupied(duck.getPosition()));
        Assert.assertFalse(map.isOccupied(vec3));
        Assert.assertTrue(map.isOccupied(vec5));
    }

    @Test
    public void objectAtTest(){
        map.place(duck);
        Assert.assertEquals(map.objectAt(new Vector2d(3,4)), duck);
        Assert.assertNotEquals(map.objectAt(vec3), duck);
        Assert.assertNotEquals(map.objectAt(vec5), duck);
    }
}
