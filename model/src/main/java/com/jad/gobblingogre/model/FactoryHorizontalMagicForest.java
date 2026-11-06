package com.jad.gobblingogre.model;

public class FactoryHorizontalMagicForest implements ForestFactory {
    @Override
    public Forest createForest(int width, int height, int density) {
        int correctDensity = Math.clamp(density, 0, 100);
        final Tile[][] tiles = new Tile[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if ((column == 0 || column == width - 1)) {
                    tiles[row][column] = Tile.getRandomNotWalkableTile();
                } else {
                    tiles[row][column] = Tile.getRandomTile(correctDensity);
                }
            }
        }

        return new RectangleForest(height, width, tiles);
    }
}
