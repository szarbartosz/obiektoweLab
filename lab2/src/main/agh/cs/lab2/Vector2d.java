package agh.cs.lab2;

import java.util.Vector;

public class Vector2d {

    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return  "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
    }

    public boolean precedes(Vector2d other){
        return(this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        return(this.x >= other.x && this.y >=other.y);
    }

    public Vector2d upperRight(Vector2d other){
        Vector2d newVector = new Vector2d(Math.max(this.x,other.x),Math.max(this.y,other.y));
        return newVector;
    }

    public Vector2d lowerLeft(Vector2d other){
        Vector2d newVector = new Vector2d(Math.min(this.x,other.x),Math.min(this.y,other.y));
        return newVector;
    }

    public Vector2d add(Vector2d other){
        Vector2d newVector = new Vector2d(this.x + other.x,this.y + other.y);
        return newVector;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d newVector = new Vector2d(this.x - other.x,this.y - other.y);
        return newVector;
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        Vector2d otherVector = (Vector2d) other;
        return (otherVector.x == this.x && otherVector.y == this.y);
    }

    public Vector2d opposite(){
        Vector2d newVector = new Vector2d(-this.x,-this.y);
        return newVector;
    }
}
