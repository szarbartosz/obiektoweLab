package agh.cs.lab7;

public class World {

    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            map.run(directions);
            System.out.println(map.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap tuftsMap = new GrassField(10);
        tuftsMap.place(new Animal(tuftsMap));
        Animal duck = new Animal(tuftsMap, new Vector2d(-0,-0));
        tuftsMap.place(duck);
        Animal snail = new Animal(tuftsMap, new Vector2d(7,7));
        tuftsMap.place(snail);
        tuftsMap.run(directions);
        System.out.println(tuftsMap.toString());

        MoveDirection[] direct = new OptionsParser().parse(args);
        GrassField field = new GrassField(10);
        Animal dog = new Animal(field, new Vector2d(-2,-2));
        Animal cat = new Animal(field, new Vector2d(6,6));
        field.place(new Animal(field));
        field.place(dog);
        field.place(cat);
        field.run(direct);
        System.out.println(field.toString());
    }

}

/*
cd IdeaProjects\lab7\src\main
javac agh\cs\lab7\*.java
java agh.cs.lab7.World
 */