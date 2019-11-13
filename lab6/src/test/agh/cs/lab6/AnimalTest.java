package agh.cs.lab6;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    Animal duck = new Animal();
    String[] toParse = new String[] {"f", "forward", "b", "backward", "l", "left", "r", "right", "test", "something"};
    OptionsParser parser = new OptionsParser();

    @Test
    public void orientationTest(){
        Assert.assertEquals(duck.getOrientation(),MapDirection.NORTH);
        duck.move(MoveDirection.RIGHT);
        Assert.assertEquals(duck.getOrientation(),MapDirection.EAST);
        duck.move(MoveDirection.RIGHT);
        Assert.assertEquals(duck.getOrientation(),MapDirection.SOUTH);
        duck.move(MoveDirection.RIGHT);
        Assert.assertEquals(duck.getOrientation(),MapDirection.WEST);
        duck.move(MoveDirection.LEFT);
        Assert.assertEquals(duck.getOrientation(),MapDirection.SOUTH);
    }

    @Test
    public void properParseTest(){
        try {
            MoveDirection[] parsed = parser.parse(toParse);
            Assert.assertEquals(parsed[0], MoveDirection.FORWARD);
            Assert.assertEquals(parsed[1], MoveDirection.FORWARD);
            Assert.assertEquals(parsed[2], MoveDirection.BACKWARD);
            Assert.assertEquals(parsed[3], MoveDirection.BACKWARD);
            Assert.assertEquals(parsed[4], MoveDirection.LEFT);
            Assert.assertEquals(parsed[5], MoveDirection.LEFT);
            Assert.assertEquals(parsed[6], MoveDirection.RIGHT);
            Assert.assertEquals(parsed[7], MoveDirection.RIGHT);
            Assert.assertEquals(parsed[8], MoveDirection.ERROR);
            Assert.assertEquals(parsed[9], MoveDirection.ERROR);
        }catch (IllegalArgumentException ex){
            Assert.assertTrue(ex.getMessage().equals("\"" + toParse[8] + "\" " + "is not legal move specification"));
        }
    }
}
