package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.Tile;
import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.behaviorDie.BehaviorDie;
import com.jad.gobblingogre.model.mobile.behaviorIsEdible.BehaviorIsEdible;
import com.jad.gobblingogre.model.mobile.behaviormove.BehaviorMove;

import java.awt.*;

public interface Mobile extends Tile {
    void setBehaviorIsEdible(BehaviorIsEdible behaviorIsEdible);

    void setBehaviorMove(BehaviorMove behaviorMove);

    void setBehaviorDie(BehaviorDie behaviorDie);

    void setSprite(Sprite sprite);

    Point getPosition();

    void setPosition(Point position);

    MobileType getType();

    void move(final Forest forest, final Mobiles mobiles);

    int getTurnNumber();

    void die();

    int getX();

    int getY();

    boolean isEdible(Mobile mobile);
}
