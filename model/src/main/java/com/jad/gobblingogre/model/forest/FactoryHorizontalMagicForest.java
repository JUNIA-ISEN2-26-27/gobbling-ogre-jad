package com.jad.gobblingogre.model.forest;

public class FactoryHorizontalMagicForest implements FactoryForest {
    @Override
    public Forest create(int width, int height, int density) {
        int correctDensity = Math.clamp(density, 0, 100);
        final RealTile[][] tiles = new RealTile[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if ((row == 0 || row == height - 1)) {
                    tiles[row][column] = RealTile.getRandomNotWalkableTile();
                } else {
                    tiles[row][column] = RealTile.getRandomTile(correctDensity);
                }
            }
        }

        return new HorizontalMagicForest(height, width, tiles);
    }
}
