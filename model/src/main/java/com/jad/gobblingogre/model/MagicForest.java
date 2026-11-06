package com.jad.gobblingogre.model;

class MagicForest extends AbstractForest {
    MagicForest(final int height, final int width, final RealTile[][] tiles) {
        super(height, width, tiles);
    }

    @Override
    protected int wrapX(final int x) {
        return (x + this.getWidth()) % this.getWidth();
    }

    @Override
    protected int wrapY(final int y) {
        return (y + this.getHeight()) % this.getHeight();
    }
}
