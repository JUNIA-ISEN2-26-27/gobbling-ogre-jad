package com.jad.gobblingogre.model.mobile.behaviorIsEdible;

import com.jad.gobblingogre.model.mobile.Mobile;

public class isEdible implements BehaviorIsEdible {

    @Override
    public boolean isEdible(final Mobile mobile, final Mobile exceptionMobile) {
        return mobile != exceptionMobile;
    }
}
