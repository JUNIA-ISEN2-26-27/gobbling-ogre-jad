package com.jad.gobblingogre.view;

import com.jad.gobblingogre.controller.IController;

public interface IView {
    void setController(IController controller);

    void display();
}
