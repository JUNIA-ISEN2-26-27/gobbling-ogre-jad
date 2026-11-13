package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.mobile.behaviormove.OgreMove;

import java.awt.*;

public class Ogre extends AbstractMobile {
    Ogre(final Point position) {
        super(position,
              new OgreMove(),
              MobileType.OGRE,
              new Sprite('☻', new char[][]{
                      {' ', ' ', '(', ')', ' ', ' '},
                      {' ', '▞', '█', '█', '▚', ' '},
                      {' ', '▟', '▔', '▔', '▙', ' '}
              }),
              1);
    }
}
