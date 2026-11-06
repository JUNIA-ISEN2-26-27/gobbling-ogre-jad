package com.jad.gobblingogre.model;

import java.awt.*;

public interface Forest {
    int getHeight();

    int getWidth();

    Dimension getDimension();

    Tile getTile(Point position);

    Tile[][] getTiles(final Point start, Point end);
}
