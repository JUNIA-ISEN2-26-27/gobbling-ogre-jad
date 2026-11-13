package com.jad.gobblingogre.model.mobile;

import java.awt.*;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction getRandomDirection() {
        return Direction.values()[(int) (Math.random() * Direction.values().length)];
    }

    public Point getNextPosition(final int x, final int y) {
        return this.getNextPosition(new Point(x, y));
    }

    public Point getNextPosition(final Point position) {
        return switch (this) {
            case NORTH -> new Point(position.x, position.y - 1);
            case EAST -> new Point(position.x + 1, position.y);
            case SOUTH -> new Point(position.x, position.y + 1);
            case WEST -> new Point(position.x - 1, position.y);
        };
    }
}
