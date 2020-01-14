package com.thoughtworks.marsrover;

public class MarsRover {
    private Position position;
    private Direction direction;

    public MarsRover(int x, int y, String direction) {
        this.position = Position.build(x, y);
        this.direction = Direction.build(direction);
    }

    public MarsRover execute(String cmd) {
        Position position = this.getPosition();
        if (!"M".equals(cmd)) {
            this.direction = direction.next(cmd);
            return this;
        }
        if ("N".equals(this.getDirection())) {
            this.position = Position.build(position.getX(), position.getY() + 1);
        }
        if ("W".equals(this.getDirection())) {
            this.position = Position.build(position.getX() - 1, position.getY());
        }
        if ("N".equals(this.getDirection())) {
            this.position = Position.build(position.getX(), position.getY() + 1);
        }
        if ("E".equals(this.getDirection())) {
            this.position = Position.build(position.getX() + 1, position.getY());
        }

        return this;
    }

    public Position getPosition() {
        return position;
    }

    public String getDirection() {
        return direction.getValue();
    }


}
