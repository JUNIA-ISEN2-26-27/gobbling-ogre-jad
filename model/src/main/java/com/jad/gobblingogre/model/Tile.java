package com.jad.gobblingogre.model;

enum Tile {
    EMPTY(true, new Sprite(' ', new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' '}
    })),
    OAK(false, new Sprite('O', new char[][]{
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O'},
            {'O', 'O', 'O', 'O', 'O', 'O'}
    })),
    ACACIA(false, new Sprite('A', new char[][]{
            {'A', 'A', 'A', 'A', 'A', 'A'},
            {'A', 'A', 'A', 'A', 'A', 'A'},
            {'A', 'A', 'A', 'A', 'A', 'A'}
    })),
    FIR(false, new Sprite('F', new char[][]{
            {'F', 'F', 'F', 'F', 'F', 'F'},
            {'F', 'F', 'F', 'F', 'F', 'F'},
            {'F', 'F', 'F', 'F', 'F', 'F'}
    }));

    private final boolean walkable;
    private final Sprite sprite;

    Tile(final boolean walkable, final Sprite sprite) {
        this.walkable = walkable;
        this.sprite = sprite;
    }

    public static Tile getRandomTile(final int walkableChance) {
        final Tile[] tiles = Tile.values();
        final int randomIndex = (int) (Math.random() * 100);
        if (randomIndex < walkableChance) {
            return Tile.EMPTY;
        }
        final int randomTileIndex = (int) (Math.random() * (tiles.length - 1)) + 1;
        return tiles[randomTileIndex];
    }

    public static Tile getRandomNotWalkableTile() {
        final Tile[] tiles = Tile.values();
        final int randomTileIndex = (int) (Math.random() * (tiles.length - 1)) + 1;
        return tiles[randomTileIndex];
    }

    public final boolean isWalkable() {
        return this.walkable;
    }

    public final Sprite getSprite() {
        return this.sprite;
    }

    public final char[][] getSpriteArray() {
        return this.sprite.array();
    }

    public final char getSpriteCharacter() {
        return this.sprite.character();
    }
}
