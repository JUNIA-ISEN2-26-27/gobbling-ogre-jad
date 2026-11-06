package com.jad.gobblingogre.model;

enum RealTile implements Tile {
    EMPTY(true, new Sprite(' ', new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' '}
    })),
    OAK(false, new Sprite('O', new char[][]{
            {' ', '╭', '─', '─', '╮', ' '},
            {'╭', '╯', ' ', ' ', '╰', '╮'},
            {'╰', '─', '╮', '╭', '─', '╯'}
    })),
    ACACIA(false, new Sprite('A', new char[][]{
            {'╭', '─', '─', '─', '─', '╮'},
            {'│', ' ', ' ', ' ', ' ', '│'},
            {'╰', '╯', '╮', '╭', '╰', '╯'}
    })),
    FIR(false, new Sprite('F', new char[][]{
            {' ', ' ', '╱', '╲', ' ', ' '},
            {' ', '╱', '╱', '╲', '╲', ' '},
            {'╱', '╱', '╮', '╭', '╲', '╲'}
    }));

    private final boolean walkable;
    private final Sprite sprite;

    RealTile(final boolean walkable, final Sprite sprite) {
        this.walkable = walkable;
        this.sprite = sprite;
    }

    public static RealTile getRandomTile(final int walkableChance) {
        final RealTile[] tiles = RealTile.values();
        final int randomIndex = (int) (Math.random() * 100);
        if (randomIndex >= walkableChance) {
            return RealTile.EMPTY;
        }
        final int randomTileIndex = (int) (Math.random() * (tiles.length - 1)) + 1;
        return tiles[randomTileIndex];
    }

    public static RealTile getRandomNotWalkableTile() {
        return RealTile.OAK;
    }

    public final boolean isWalkable() {
        return this.walkable;
    }

    public final Sprite getSprite() {
        return this.sprite;
    }

    @Override
    public final char[][] getSpriteArray() {
        return this.sprite.array();
    }

    @Override
    public final char getSpriteCharacter() {
        return this.sprite.character();
    }
}
