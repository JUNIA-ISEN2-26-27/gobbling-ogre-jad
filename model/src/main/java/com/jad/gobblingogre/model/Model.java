package com.jad.gobblingogre.model;

import java.awt.*;

public class Model implements IModel {
    private Forest forest;
    private AbstractFactoryForest factory = new AbstractFactoryForest();

    public Model() {
        this.forest = this.factory.createForest(ForestType.HORIZONTAL_MAGIC, 50, 10, 10);
    }


    @Override
    public Board getBoard(final Point start, final Point end) {
        return new Board(this.forest.getDimension(), this.forest.getTiles(start, end));
    }
}
