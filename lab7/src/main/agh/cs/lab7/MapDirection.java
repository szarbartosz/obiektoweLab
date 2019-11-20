package agh.cs.lab7;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        switch(this){
            case NORTH:
                return "polnoc";
            case SOUTH:
                return "poludnie";
            case EAST:
                return "wschod";
            case WEST:
                return "zachod";
        }
        return null;
    }

    public MapDirection next(){
        switch(this){
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        return null;
    }

    public MapDirection previous(){
        switch(this){
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        return null;
    }

    public Vector2d toUnitVector(){
        switch(this){
            case NORTH:
                Vector2d v1 = new Vector2d(0,1);
                return v1;
            case SOUTH:
                Vector2d v2 = new Vector2d(0,-1);
                return v2;
            case EAST:
                Vector2d v3 = new Vector2d(1,0);
                return v3;
            case WEST:
                Vector2d v4 = new Vector2d(-1,0);
                return v4;
        }
        return null;
    }

}
