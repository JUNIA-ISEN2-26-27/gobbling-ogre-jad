package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Tile;
import com.jad.gobblingogre.model.forest.Forest;

import java.awt.*;

public interface Mobile extends Tile {
    Point getPosition();

    void setPosition(Point position);

    MobileType getType();

    void move(final Forest forest, final Mobiles mobiles);
}
