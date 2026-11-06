package com.jad.gobblingogre.model.forest;

class HorizontalMagicForest extends AbstractForest {
    HorizontalMagicForest(final int height, final int width, final RealTile[][] tiles) {
        super(height, width, tiles);
    }

    @Override
    public int wrapX(final int x) {
        return (x + this.getWidth()) % this.getWidth();
    }

    @Override
    public int wrapY(final int y) {
        if (y < 0) return 0;
        if (y >= this.getHeight()) return this.getHeight() - 1;
        return y;
    }

}
