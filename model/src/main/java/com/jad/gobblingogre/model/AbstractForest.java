package com.jad.gobblingogre.model;

import java.awt.*;

abstract class AbstractForest implements Forest {
    private final int height;
    private final int width;
    private final Tile[][] tiles;

    AbstractForest(final int height, final int width, final Tile[][] tiles) {
        this.height = Math.max(height, 10);
        this.width = Math.max(width, 10);
        this.tiles = tiles;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public Tile getTile(final Point position) {
        final int x = this.wrapX(position.x);
        final int y = this.wrapY(position.y);
        return this.tiles[position.y][position.x];
    }

    protected abstract int wrapX(final int x);

    protected abstract int wrapY(final int y);
}
