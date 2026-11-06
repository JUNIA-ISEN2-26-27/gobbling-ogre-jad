package com.jad.gobblingogre.model;

import com.jad.gobblingogre.model.forest.AbstractFactoryForest;
import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.forest.ForestType;
import com.jad.gobblingogre.model.mobile.Mobile;
import com.jad.gobblingogre.model.mobile.MobileType;
import com.jad.gobblingogre.model.mobile.Mobiles;

import java.awt.*;

public class Model implements IModel {
    private Forest forest;
    private AbstractFactoryForest factory = new AbstractFactoryForest();
    private Mobiles mobiles;

    public Model() {
        this.forest = this.factory.createForest(ForestType.VERTICAL_MAGIC, 50, 10, 10);
        this.mobiles = new Mobiles(this.forest);
        this.mobiles.createMobile(MobileType.OGRE, 50);
    }


    @Override
    public Board getBoard(final Point start, final Point end) {
        final Tile[][] tiles = this.forest.getTiles(start, end);
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                final Point position = new Point(this.forest.wrapX(start.x + col), this.forest.wrapY(start.y + row));
                final Mobile mobile = this.mobiles.getMobileAt(position);
                if (mobile != null) tiles[row][col] = mobile;
            }
        }
        return new Board(new Dimension(end.x - start.x, end.y - start.y), tiles);
    }

    @Override
    public void moveMobiles() {
        for (Mobile mobile : this.mobiles) {
            mobile.move(this.forest, this.mobiles);
        }
    }
}
