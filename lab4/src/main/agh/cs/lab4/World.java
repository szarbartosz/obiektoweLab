package agh.cs.lab4;

public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        ((RectangularMap) map).mapToString();
    }

}

/*
cd IdeaProjects\lab4\src\main
javac agh\cs\lab4\*.java
java agh.cs.lab4.World
 */