package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.mobile.behaviormove.NoMove;

import java.awt.*;

public class Grave extends AbstractMobile {
    Grave(final Point position) {
        super(position,
              new NoMove(),
              MobileType.OGRE,
              new Sprite('╦', new char[][]{
                      {' ', ' ', '▟', '█', '▙', ' '},
                      {' ', '▟', 'R', 'I', 'P', '▙'},
                      {' ', '█', '█', '█', '█', '█'}
              }),
              0);
    }
}
