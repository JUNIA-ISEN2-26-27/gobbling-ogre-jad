package com.jad.gobblingogre.model.mobile.behaviorDie;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.mobile.Mobile;
import com.jad.gobblingogre.model.mobile.behaviorIsEdible.isNotEdible;
import com.jad.gobblingogre.model.mobile.behaviormove.NoMove;

public class ChildDie implements BehaviorDie {

    @Override
    public void die(final Mobile mobile) {
        mobile.setBehaviorMove(new NoMove());
        mobile.setBehaviorIsEdible(new isNotEdible());
        mobile.setSprite(new Sprite('╦', new char[][]{
                {' ', ' ', '▟', '█', '▙', ' '},
                {' ', '▟', 'R', 'I', 'P', '▙'},
                {' ', '█', '█', '█', '█', '█'}
        }));
    }
}
