package com.thoughtworks.marsrover.model.vo;

public class Position implements ValueObject{
    private int x;
    private int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position build(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }
        Position another = (Position) obj;
        return this.x == another.x
            && this.y == another.y;
    }
}
