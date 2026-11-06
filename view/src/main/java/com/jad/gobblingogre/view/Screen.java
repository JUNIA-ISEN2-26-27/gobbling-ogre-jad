package com.jad.gobblingogre.view;

import java.awt.*;

public record Screen(Dimension dimension, char[][] tiles) {
    public int getHeight() {
        return this.dimension.height;
    }

    public int getWidth() {
        return this.dimension.width;
    }
}
