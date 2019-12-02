public enum Direction {
    N,
    NE,
    E,
    SE,
    S,
    SW,
    W,
    NW;

    public Direction next(){
        switch(this){
            case N:     return NE;
            case NE:    return E;
            case E:     return SE;
            case SE:    return S;
            case S:     return SW;
            case SW:    return W;
            case W:     return NW;
            case NW:    return N;
        }
        return null;
    }

    public Direction previous(){
        switch(this){
            case N:     return NW;
            case NE:    return N;
            case E:     return NE;
            case SE:    return E;
            case S:     return SE;
            case SW:    return S;
            case W:     return SW;
            case NW:    return W;
        }
        return null;
    }

    public Vector2d toUnitVector(){
        switch(this){
            case N:     return new Vector2d(0,1);
            case NE:    return new Vector2d(1,1);
            case E:     return new Vector2d(1,0);
            case SE:    return new Vector2d(1,-1);
            case S:     return new Vector2d(0,-1);
            case SW:    return new Vector2d(-1,-1);
            case W:     return new Vector2d(-1,0);
            case NW:    return new Vector2d(-1,1);
        }
        return null;
    }

}
