package com.jad.gobblingogre.model.mobile.behaviorIsEdible;

import com.jad.gobblingogre.model.mobile.Mobile;

public class isNotEdible implements BehaviorIsEdible {

    @Override
    public boolean isEdible(final Mobile mobile, final Mobile exceptionMobile) {
        return false;
    }
}
