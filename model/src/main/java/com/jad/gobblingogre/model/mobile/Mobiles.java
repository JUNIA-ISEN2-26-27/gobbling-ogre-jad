package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.forest.Forest;

import java.awt.*;
import java.util.ArrayList;

public class Mobiles extends ArrayList<Mobile> {
    private final Forest forest;

    public Mobiles(final Forest forest) {
        this.forest = forest;
    }

    public final void createMobile(final MobileType mobileType, final int nbMobiles) {
        for (int i = 0; i < nbMobiles; i++) {
            this.createMobile(mobileType);
        }
    }

    public final void createMobile(final MobileType mobileType) {
        Point randomPosition;
        do {
            randomPosition = new Point((int) (Math.random() * this.forest.getWidth()),
                                       (int) (Math.random() * this.forest.getHeight()));
        } while (!this.forest.isTileWalkable(randomPosition) || !this.thereNoOneAt(randomPosition));
        this.add(new Child(randomPosition));
    }

    public boolean thereNoOneAt(final Point newPosition) {
        for (final Mobile mobile : this) {
            if (mobile.getPosition().equals(newPosition)) return false;
        }
        return true;
    }

    public Mobile getMobileAt(final Point position) {
        for (final Mobile mobile : this) {
            if (mobile.getPosition().equals(position)) return mobile;
        }
        return null;
    }
}
