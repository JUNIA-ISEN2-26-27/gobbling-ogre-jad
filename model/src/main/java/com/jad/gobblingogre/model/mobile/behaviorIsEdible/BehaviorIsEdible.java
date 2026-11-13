package com.jad.gobblingogre.model.mobile.behaviorIsEdible;

import com.jad.gobblingogre.model.mobile.Mobile;

public interface BehaviorIsEdible {
    boolean isEdible(final Mobile mobile, final Mobile exceptionMobile);
}
