package agh.cs.lab3;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    Animal duck = new Animal();
    MoveDirection[] duckBackward = new MoveDirection[]{MoveDirection.BACKWARD};
    MoveDirection[] duckRight = new MoveDirection[] {MoveDirection.RIGHT};
    MoveDirection[] duckLeft = new MoveDirection[] {MoveDirection.LEFT};
    MoveDirection[] duckForward = new MoveDirection[] {MoveDirection.FORWARD};
    MoveDirection[] duckMoves = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
    String[] toParse = new String[] {"f", "forward", "b", "backward", "l", "left", "r", "right", "test", "something"};
    OptionsParser parser = new OptionsParser();

    @Test
    public void orientationTest(){
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(duckBackward);
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(duckRight);
        Assert.assertEquals(duck.getOrientation(),MapDirection.EAST);
        duck.move(duckLeft);
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(duckForward);
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(duckMoves);
        Assert.assertEquals(duck.getOrientation(),MapDirection.WEST);
    }

    @Test
    public void positionTest(){
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,2));
        duck.move(duckBackward);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckRight);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckLeft);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckForward);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,2));
        duck.move(duckMoves);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,0));
    }

    @Test
    public void offMapTest(){
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,2));
        duck.move(duckBackward);
        duck.move(duckBackward);
        duck.move(duckBackward);
        duck.move(duckBackward);
        duck.move(duckBackward);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,0));
        duck.move(duckForward);
        duck.move(duckForward);
        duck.move(duckForward);
        duck.move(duckForward);
        duck.move(duckForward);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,4));
    }

    @Test
    public void properParseTest(){
        MoveDirection[] parsed = parser.parse(toParse);
        Assert.assertEquals(parsed[0],MoveDirection.FORWARD);
        Assert.assertEquals(parsed[1],MoveDirection.FORWARD);
        Assert.assertEquals(parsed[2],MoveDirection.BACKWARD);
        Assert.assertEquals(parsed[3],MoveDirection.BACKWARD);
        Assert.assertEquals(parsed[4],MoveDirection.LEFT);
        Assert.assertEquals(parsed[5],MoveDirection.LEFT);
        Assert.assertEquals(parsed[6],MoveDirection.RIGHT);
        Assert.assertEquals(parsed[7],MoveDirection.RIGHT);
        Assert.assertEquals(parsed[8],MoveDirection.ERROR);
        Assert.assertEquals(parsed[9],MoveDirection.ERROR);
    }
}
