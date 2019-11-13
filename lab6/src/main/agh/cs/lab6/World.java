package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            map.place(new Animal(map));
            map.place(new Animal(map,new Vector2d(3,4)));
            map.place(new Animal(map,new Vector2d(6,4)));
            map.run(directions);
            System.out.println(map.toString());


            List<HayStack> stacks = new ArrayList();
            stacks.add(new HayStack(new Vector2d(0,0)));
            stacks.add(new HayStack(new Vector2d(9,6)));
            stacks.add(new HayStack(new Vector2d(3,2)));
            stacks.add(new HayStack(new Vector2d(7,1)));
            stacks.add(new HayStack(new Vector2d(4,5)));
            IWorldMap mapStack = new UnboundedMap(stacks);
            mapStack.place(new Animal(mapStack));
            mapStack.place(new Animal(mapStack,new Vector2d(3,4)));
            mapStack.place(new Animal(mapStack,new Vector2d(7,3)));
            mapStack.run(directions);
            System.out.println(mapStack.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
    }

}

/*
cd IdeaProjects\lab5\src\main
javac agh\cs\lab6\*.java
java agh.cs.lab6.World
 */