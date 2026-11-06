package com.jad.gobblingogre.model;

class RectangleForest extends AbstractForest {
    RectangleForest(final int height, final int width, final RealTile[][] tiles) {
        super(height, width, tiles);
    }

    @Override
    protected int wrapX(final int x) {
        if (x < 0) return 0;
        if (x >= this.getWidth()) return this.getWidth() - 1;
        return x;
    }

    @Override
    protected int wrapY(final int y) {
        if (y < 0) return 0;
        if (y >= this.getHeight()) return this.getHeight() - 1;
        return y;
    }
}
