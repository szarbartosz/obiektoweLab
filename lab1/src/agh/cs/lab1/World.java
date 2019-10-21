package agh.cs.lab1;

public class World {

    public static void run(Direction[] moves){
        for(Direction move : moves) {
            switch (move) {
                case FORWARD:
                    System.out.println("zwierzak porusza sie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("zwierzak porusza sie do tylu");
                    break;
                case RIGHT:
                    System.out.println("zwierzak skreca w prawo");
                    break;
                case LEFT:
                    System.out.println("zwierzak skreca w lewo");
                    break;
                default:
                    System.out.println("nie rozpoznano argumentu");
            }
        }
    }

    public static Direction[] convert(String[] args){
        Direction[] moves = new Direction[args.length];
        int i = 0;
        for(String argument : args) {
            switch (argument) {
                case "f":
                    moves[i] = Direction.FORWARD;
                    i++;
                    break;
                case "b":
                    moves[i] = Direction.BACKWARD;
                    i++;
                    break;
                case "r":
                    moves[i] = Direction.RIGHT;
                    i++;
                    break;
                case "l":
                    moves[i] = Direction.LEFT;
                    i++;
                    break;
                default:
                    moves[i] = Direction.ERROR;
                    i++;
            }
        }
        return moves;
    }

    public static void main(String[] args){
        System.out.println("start");
        Direction[] moves = new Direction[args.length];
        moves = convert(args);
        run(moves);
        System.out.println("stop");
    }
}


/*
cd IdeaProjects\lab1\src
javac agh\cs\lab1\*.java
java agh.cs.lab1.World f f b r l
 */