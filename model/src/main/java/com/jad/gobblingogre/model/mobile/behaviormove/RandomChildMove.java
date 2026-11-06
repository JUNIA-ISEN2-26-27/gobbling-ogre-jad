package com.jad.gobblingogre.model.mobile.behaviormove;

import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.Direction;
import com.jad.gobblingogre.model.mobile.Mobile;
import com.jad.gobblingogre.model.mobile.Mobiles;

import java.awt.*;

public class RandomChildMove implements BehaviorMove {
    @Override
    public void move(final Mobile mobile, final Forest forest, final Mobiles mobiles) {
        final Point newPosition = Direction.getRandomDirection().getNextPosition(mobile.getPosition());
        if (forest.isTileWalkable(newPosition) && mobiles.thereNoOneAt(newPosition)) {
            final Point wrappedPosition = new Point(forest.wrapX(newPosition.x), forest.wrapY(newPosition.y));
            mobile.setPosition(wrappedPosition);
        }
    }
}
