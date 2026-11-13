package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.behaviorDie.BehaviorDie;
import com.jad.gobblingogre.model.mobile.behaviorDie.NoDie;
import com.jad.gobblingogre.model.mobile.behaviorIsEdible.BehaviorIsEdible;
import com.jad.gobblingogre.model.mobile.behaviorIsEdible.isNotEdible;
import com.jad.gobblingogre.model.mobile.behaviormove.BehaviorMove;

import java.awt.*;

abstract class AbstractMobile implements Mobile {
    private final MobileType type;
    private final int turnNumber;
    private BehaviorMove behaviorMove;
    private BehaviorDie behaviorDie;
    private BehaviorIsEdible behaviorIsEdible = new isNotEdible();
    private Sprite sprite;
    private Point position;
    AbstractMobile(final Point position,
                   final BehaviorMove behaviorMove,
                   final MobileType type,
                   final Sprite sprite,
                   final int turnNumber) {
        this.position = position;
        this.behaviorMove = behaviorMove;
        this.type = type;
        this.sprite = sprite;
        this.turnNumber = turnNumber;
        this.behaviorDie = new NoDie();
    }

    @Override
    public void setBehaviorIsEdible(final BehaviorIsEdible behaviorIsEdible) {
        this.behaviorIsEdible = behaviorIsEdible;
    }

    @Override
    public void setBehaviorMove(final BehaviorMove behaviorMove) {
        this.behaviorMove = behaviorMove;
    }

    @Override
    public void setBehaviorDie(final BehaviorDie behaviorDie) {
        this.behaviorDie = behaviorDie;
    }

    @Override
    public void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public final Point getPosition() {
        return this.position;
    }

    @Override
    public final void setPosition(final Point position) {
        this.position = position;
    }

    @Override
    public final MobileType getType() {
        return this.type;
    }

    @Override
    public final void move(final Forest forest, final Mobiles mobiles) {
        this.behaviorMove.move(this, forest, mobiles);
    }

    @Override
    public final int getTurnNumber() {
        return this.turnNumber;
    }

    @Override
    public void die() {
        this.behaviorDie.die(this);
    }

    @Override
    public int getX() {
        return this.position.x;
    }

    @Override
    public int getY() {
        return this.position.y;
    }

    @Override
    public boolean isEdible(final Mobile exceptedMobile) {
        return this.behaviorIsEdible.isEdible(this, exceptedMobile);
    }

    @Override
    public final boolean isWalkable() {
        return false;
    }

    @Override
    public final char[][] getSpriteArray() {
        return this.sprite.array();
    }

    @Override
    public final char getSpriteCharacter() {
        return this.sprite.character();
    }
}
