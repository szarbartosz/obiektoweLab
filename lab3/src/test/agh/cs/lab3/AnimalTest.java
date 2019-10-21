package agh.cs.lab3;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    Animal duck = new Animal();
    MoveDirection[] duckDirectionSouth = new MoveDirection[]{MoveDirection.BACKWARD};
    MoveDirection[] duckDirectionEast = new MoveDirection[] {MoveDirection.RIGHT};
    MoveDirection[] duckDirectionWest = new MoveDirection[] {MoveDirection.LEFT};
    MoveDirection[] duckDirectionNorth = new MoveDirection[] {MoveDirection.FORWARD};
    MoveDirection[] duckMoves = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
    String[] toParse = new String[] {"f", "forward", "b", "backward", "l", "left", "r", "right", "test", "something"};
    OptionsParser parser = new OptionsParser();

    @Test
    public void orientationTest(){
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(duckDirectionSouth);
        Assert.assertEquals(duck.getOrientation(),MapDirection.SOUTH);
        duck.move(duckDirectionEast);
        Assert.assertEquals(duck.getOrientation(),MapDirection.EAST);
        duck.move(duckDirectionWest);
        Assert.assertEquals(duck.getOrientation(),MapDirection.WEST);
        duck.move(duckMoves);
        Assert.assertEquals(duck.getOrientation(),MapDirection.WEST);
        duck.move(duckDirectionNorth);
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
    }

    @Test
    public void positionTest(){
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,2));
        duck.move(duckDirectionSouth);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckDirectionEast);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckDirectionWest);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
        duck.move(duckMoves);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,0));
        duck.move(duckDirectionNorth);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,1));
    }

    @Test
    public void offMapTest(){
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,2));
        duck.move(duckDirectionSouth);
        duck.move(duckDirectionSouth);
        duck.move(duckDirectionSouth);
        duck.move(duckDirectionSouth);
        duck.move(duckDirectionSouth);
        Assert.assertEquals(duck.getPosition(),new Vector2d(2,0));
        duck.move(duckDirectionNorth);
        duck.move(duckDirectionNorth);
        duck.move(duckDirectionNorth);
        duck.move(duckDirectionNorth);
        duck.move(duckDirectionNorth);
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
