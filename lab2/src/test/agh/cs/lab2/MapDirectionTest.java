package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static agh.cs.lab2.MapDirection.SOUTH;
import static agh.cs.lab2.MapDirection.WEST;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        Assert.assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        Assert.assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        Assert.assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        Assert.assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);
    }

    @Test
    public void previousTest(){
        Assert.assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        Assert.assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        Assert.assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);
        Assert.assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);
    }
}
