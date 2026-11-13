package com.jad.gobblingogre.model.forest;

import com.jad.gobblingogre.model.Tile;

import java.awt.*;

public interface Forest {
    int getHeight();

    int getWidth();

    Dimension getDimension();

    Tile getTile(Point position);

    Tile[][] getTiles(final Point start, Point end);

    boolean isTileWalkable(Point newPosition);

    int wrapX(int x);

    int wrapY(int y);

    Point wrapPosition(Point nextPosition);

}
