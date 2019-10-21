package agh.cs.lab2;

import java.util.Map;

public class World {

    public static void methodsTest(){
        MapDirection[] Directions = new MapDirection[4];
        Directions[0] = MapDirection.NORTH;
        Directions[1] = MapDirection.EAST;
        Directions[2] = MapDirection.SOUTH;
        Directions[3] = MapDirection.WEST;

        for(MapDirection direction : Directions){
            switch(direction){
                case NORTH:
                    System.out.print("NORTH.next() = ");
                    System.out.println(direction.next());
                    System.out.print("NORTH.previous() = ");
                    System.out.println(direction.previous());
                    System.out.print("NORTH.toUnitVector() = ");
                    System.out.println(direction.toUnitVector());

                    break;
                case EAST:
                    System.out.print("EAST.next() = ");
                    System.out.println(direction.next());
                    System.out.print("EAST.previous() = ");
                    System.out.println(direction.previous());
                    System.out.print("EAST.toUnitVector() = ");
                    System.out.println(direction.toUnitVector());
                    break;
                case SOUTH:
                    System.out.print("SOUTH.next() = ");
                    System.out.println(direction.next());
                    System.out.print("SOUTH.previous() = ");
                    System.out.println(direction.previous());
                    System.out.print("SOUTH.toUnitVector() = ");
                    System.out.println(direction.toUnitVector());
                    break;
                case WEST:
                    System.out.print("WEST.next() = ");
                    System.out.println(direction.next());
                    System.out.print("WEST.previous() = ");
                    System.out.println(direction.previous());
                    System.out.print("WEST.toUnitVector() = ");
                    System.out.println(direction.toUnitVector());
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.print("wektor1 = ");
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.print("wektor2 = ");
        System.out.println(position2);
        System.out.print("wektor1 + wektor2 = ");
        System.out.println(position1.add(position2));

        System.out.println();

        methodsTest();
    }
}

/*
cd IdeaProjects\lab2\src\main
javac agh\cs\lab2\*.java
java agh.cs.lab2.World
 */