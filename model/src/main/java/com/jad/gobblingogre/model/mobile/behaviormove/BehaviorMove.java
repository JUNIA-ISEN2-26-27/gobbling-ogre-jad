package com.jad.gobblingogre.model.mobile.behaviormove;

import com.jad.gobblingogre.model.forest.Forest;
import com.jad.gobblingogre.model.mobile.Mobile;
import com.jad.gobblingogre.model.mobile.Mobiles;

public interface BehaviorMove {
    void move(final Mobile mobile, final Forest forest, final Mobiles mobiles);
}
