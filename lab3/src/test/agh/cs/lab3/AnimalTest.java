package agh.cs.lab3;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    Animal duck = new Animal();
    MoveDirection[] duckDirectionSouth = new MoveDirection[]{MoveDirection.BACKWARD};
    MoveDirection[] duckDirectionEast = new MoveDirection[] {MoveDirection.RIGHT};
    MoveDirection[] duckDirectionWest = new MoveDirection[] {MoveDirection.LEFT};
    MoveDirection[] duckMoves = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};

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
    }
}
