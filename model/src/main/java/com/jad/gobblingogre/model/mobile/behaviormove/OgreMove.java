package com.jad.gobblingogre.model.mobile.behaviormove;

import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.Direction;
import com.jad.gobblingogre.model.mobile.Mobile;
import com.jad.gobblingogre.model.mobile.Mobiles;

import java.awt.*;

public class OgreMove implements BehaviorMove {
    @Override
    public void move(final Mobile mobile, final Forest forest, final Mobiles mobiles) {
        final Point newPosition = this.calculeNextPosition(mobile, forest, mobiles);
        if (forest.isTileWalkable(newPosition)) {
            final Point wrappedPosition = new Point(forest.wrapX(newPosition.x), forest.wrapY(newPosition.y));
            if (!mobiles.thereNoOneAt(wrappedPosition)) {
                mobiles.killMobileAt(wrappedPosition, mobile);
            }
            mobile.setPosition(wrappedPosition);
        }
    }

    private Point calculeNextPosition(final Mobile mobile, final Forest forest, final Mobiles mobiles) {
        int nearestChildDistance = Integer.MAX_VALUE;
        Direction nearestChildDirection = null;
        for (Direction direction : Direction.values()) {
            int currentDistance = 0;
            Point newPosition = mobile.getPosition();
            do {
                newPosition = forest.wrapPosition(direction.getNextPosition(newPosition));
                currentDistance++;
            } while (forest.isTileWalkable(newPosition) && mobiles.thereNoOneAt(newPosition));
            if (!mobiles.thereNoOneAt(newPosition)) {
                if (mobiles.getMobileAt(newPosition).isEdible(mobile) && currentDistance < nearestChildDistance) {
                    nearestChildDistance = currentDistance;
                    nearestChildDirection = direction;
                }
            }
        }
        return nearestChildDirection != null
                ? nearestChildDirection.getNextPosition(mobile.getPosition())
                : Direction.getRandomDirection().getNextPosition(mobile.getPosition());
    }
}
