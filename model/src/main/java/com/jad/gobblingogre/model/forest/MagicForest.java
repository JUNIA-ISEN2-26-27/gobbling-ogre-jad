package com.jad.gobblingogre.model.forest;

class MagicForest extends AbstractForest {
    MagicForest(final int height, final int width, final RealTile[][] tiles) {
        super(height, width, tiles);
    }

    @Override
    public int wrapX(final int x) {
        return (x + this.getWidth()) % this.getWidth();
    }

    @Override
    public int wrapY(final int y) {
        return (y + this.getHeight()) % this.getHeight();
    }
}
