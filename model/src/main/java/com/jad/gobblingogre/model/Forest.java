package com.jad.gobblingogre.model;

import java.awt.*;

public interface Forest {
    int getHeight();

    int getWidth();

    Tile getTile(Point position);
}
