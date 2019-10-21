package agh.cs.lab3;

public class World {

    public static void main(String[] args) {

        Animal cat = new Animal();
        System.out.println("pozycja poczatkowa: " + cat.toString());

        OptionsParser parser = new OptionsParser();
        MoveDirection[] parsed = parser.parse(args);
        cat.move(parsed);
        System.out.println("pozycja ostateczna : " + cat.toString());
    }

}

/*
cd IdeaProjects\lab3\src\main
javac agh\cs\lab3\*.java
java agh.cs.lab3.World
 */