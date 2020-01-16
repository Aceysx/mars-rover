package com.thoughtworks.marsrover;

public class MarsRover {
    private Location location;
    private boolean isBackward;

    public MarsRover(int x, int y, String direction) {
        this.location = Location.build(x, y, direction);
    }

    public MarsRover execute(String cmd) {
        if (cmd.equals("H")) {
            this.forward();
            return this;
        }
        if (cmd.equals("B")) {
            this.backward();
            return this;
        }
        Command command = Command.build(cmd);
        this.updateLocation(command.execute(location));
        return this;
    }

    private void backward() {
        this.isBackward = true;
    }

    private void forward() {
        this.isBackward = false;
    }

    public Position getPosition() {
        return location.getPosition();
    }

    public String getDirection() {
        return location.getDirection().toString();
    }

    private void updateLocation(Location location) {
        this.location = location;
    }

    public boolean isBackward() {
        return isBackward;
    }
}
