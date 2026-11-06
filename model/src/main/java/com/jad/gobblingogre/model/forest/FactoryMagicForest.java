package com.jad.gobblingogre.model.forest;

public class FactoryMagicForest implements FactoryForest {
    @Override
    public Forest create(int width, int height, int density) {
        int correctDensity = Math.clamp(density, 0, 100);
        final RealTile[][] tiles = new RealTile[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                tiles[row][column] = RealTile.getRandomTile(correctDensity);
            }
        }


        return new MagicForest(height, width, tiles);
    }
}
