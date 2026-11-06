package com.jad.gobblingogre.model;

public interface Tile {
    public final static int SPRITE_HEIGHT = 3;
    public final static int SPRITE_WIDTH = 6;

    char[][] getSpriteArray();

    char getSpriteCharacter();
}
