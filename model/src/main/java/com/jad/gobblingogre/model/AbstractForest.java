package com.jad.gobblingogre.model;

import java.awt.*;

abstract class AbstractForest implements Forest {
    private final int height;
    private final int width;
    private final RealTile[][] tiles;

    AbstractForest(final int height, final int width, final RealTile[][] tiles) {
        this.height = Math.max(height, 10);
        this.width = Math.max(width, 10);
        this.tiles = tiles;
    }

    @Override
    public final int getHeight() {
        return this.height;
    }

    @Override
    public final int getWidth() {
        return this.width;
    }

    @Override
    public final Dimension getDimension() {
        return new Dimension(this.width, this.height);
    }

    @Override
    public final Tile getTile(final Point position) {
        final int x = this.wrapX(position.x);
        final int y = this.wrapY(position.y);
        return this.tiles[y][x];
    }

    @Override
    public final Tile[][] getTiles(final Point start, final Point end) {
        final Tile[][] result = new Tile[end.y - start.y + 1][end.x - start.x + 1];
        for (int row = start.y; row <= end.y; row++) {
            for (int column = start.x; column <= end.x; column++) {
                result[row - start.y][column - start.x] = this.getTile(new Point(column, row));
            }
        }
        return result;
    }

    protected abstract int wrapX(final int x);

    protected abstract int wrapY(final int y);
}
