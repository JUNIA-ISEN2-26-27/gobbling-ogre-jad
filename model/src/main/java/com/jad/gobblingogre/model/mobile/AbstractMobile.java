package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.behaviormove.BehaviorMove;

import java.awt.*;

abstract class AbstractMobile implements Mobile {
    private final MobileType type;
    private final BehaviorMove behaviorMove;
    private final Sprite sprite;
    private Point position;

    AbstractMobile(final Point position, final BehaviorMove behaviorMove, final MobileType type, final Sprite sprite) {
        this.position = position;
        this.behaviorMove = behaviorMove;
        this.type = type;
        this.sprite = sprite;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(final Point position) {
        this.position = position;
    }

    @Override
    public MobileType getType() {
        return this.type;
    }

    @Override
    public void move(final Forest forest, final Mobiles mobiles) {
        this.behaviorMove.move(this, forest, mobiles);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public char[][] getSpriteArray() {
        return this.sprite.array();
    }

    @Override
    public char getSpriteCharacter() {
        return this.sprite.character();
    }
}
