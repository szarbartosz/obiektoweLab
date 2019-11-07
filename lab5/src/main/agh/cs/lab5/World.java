package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.place(new Animal(map,new Vector2d(6,4)));
        map.run(directions);
        System.out.println(map.toString());

        List<HayStack> stacks = new ArrayList();
        stacks.add(new HayStack(new Vector2d(-4,-4)));
        stacks.add(new HayStack(new Vector2d(7,7)));
        stacks.add(new HayStack(new Vector2d(3,6)));
        stacks.add(new HayStack(new Vector2d(2,0)));
        stacks.add(new HayStack(new Vector2d(4,3)));
        IWorldMap mapStack = new UnboundedMap(stacks);
        mapStack.place(new Animal(mapStack));
        mapStack.place(new Animal(mapStack,new Vector2d(3,4)));
        mapStack.place(new Animal(map,new Vector2d(6,4)));
        mapStack.place(new Animal(map,new Vector2d(12,4)));
        mapStack.run(directions);
        System.out.println(mapStack.toString());
    }

}

/*
cd IdeaProjects\lab5\src\main
javac agh\cs\lab5\*.java
java agh.cs.lab5.World
 */