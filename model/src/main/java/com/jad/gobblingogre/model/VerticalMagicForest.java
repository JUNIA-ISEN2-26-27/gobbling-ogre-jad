package com.jad.gobblingogre.model;

class VerticalMagicForest extends AbstractForest {
    VerticalMagicForest(final int height, final int width, final RealTile[][] tiles) {
        super(height, width, tiles);
    }
    @Override
    protected int wrapX(final int x) {
        return (x + this.getWidth()) % this.getWidth();
    }

    @Override
    protected int wrapY(final int y) {
        if (y < 0) return 0;
        if (y >= this.getHeight()) return this.getHeight() - 1;
        return y;
    }

}
