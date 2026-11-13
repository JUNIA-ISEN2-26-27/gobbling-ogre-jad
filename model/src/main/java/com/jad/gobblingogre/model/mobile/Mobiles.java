package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.forest.Forest;

import java.awt.*;
import java.util.ArrayList;

public class Mobiles extends ArrayList<Mobile> {
    private final Forest forest;

    public Mobiles(final Forest forest) {
        this.forest = forest;
    }

    public final void createMobileAtRandomPosition(final MobileType mobileType, final int nbMobiles) {
        for (int i = 0; i < nbMobiles; i++) {
            this.createMobileAtRandomPosition(mobileType);
        }
    }

    public final void createMobileAtRandomPosition(final MobileType mobileType) {
        Point randomPosition;
        do {
            randomPosition = new Point((int) (Math.random() * this.forest.getWidth()),
                                       (int) (Math.random() * this.forest.getHeight()));
        } while (!this.forest.isTileWalkable(randomPosition) || !this.thereNoOneAt(randomPosition));

        this.createMobileAtPosition(mobileType, randomPosition);
    }

    public boolean thereNoOneAt(final Point newPosition) {
        for (final Mobile mobile : this) {
            if (mobile.getPosition().equals(newPosition)) return false;
        }
        return true;
    }

    private boolean createMobileAtPosition(final MobileType mobileType, final Point position) {
        return this.add(switch (mobileType) {
            case CHILD -> new Child(position);
            case OGRE -> new Ogre(position);
            case GRAVE -> new Grave(position);
        });
    }

    public void killMobileAt(final Point position, final Mobile except) {
        this.getMobileAt(position, except).die();
    }

    public Mobile getMobileAt(final Point position, final Mobile except) {
        for (final Mobile mobile : this) {
            if (mobile != except && mobile.getPosition().equals(position)) return mobile;
        }
        return null;
    }

    public Mobile getMobileAt(final Point position) {
        for (final Mobile mobile : this) {
            if (mobile.getPosition().equals(position)) return mobile;
        }
        return null;
    }
}
