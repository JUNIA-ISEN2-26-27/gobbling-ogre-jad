package com.jad.gobblingogre.model;

import java.awt.*;

public record Board(Dimension dimension, Tile[][] tiles) {
    public Board(final int width, final int height, final Tile[][] tiles) {
        this(new Dimension(width, height), tiles);
    }

    public final int getWidth() {
        return this.dimension.width;
    }

    public final int getHeight() {
        return this.dimension.height;
    }
}
