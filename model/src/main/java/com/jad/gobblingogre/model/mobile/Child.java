package com.jad.gobblingogre.model.mobile;

import com.jad.gobblingogre.model.Sprite;
import com.jad.gobblingogre.model.mobile.behaviormove.RandomChildMove;

import java.awt.*;

public class Child extends AbstractMobile {
    Child(final Point position) {
        super(position,
              new RandomChildMove(),
              MobileType.CHILD,
              new Sprite('☺', new char[][]{
                      {' ', ' ', ' ', '■', ' ', ' '},
                      {' ', ' ', '╾', '▒', '╼', ' '},
                      {' ', ' ', '┛', ' ', '┗', ' '}
              }));
    }
}
