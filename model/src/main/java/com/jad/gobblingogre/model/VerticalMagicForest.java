package com.jad.gobblingogre.model;

class VerticalMagicForest extends AbstractForest {
    VerticalMagicForest(final int height, final int width, final Tile[][] tiles) {
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
        return (y + this.getHeight()) % this.getHeight();
    }
}
