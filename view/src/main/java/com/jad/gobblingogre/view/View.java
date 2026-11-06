package com.jad.gobblingogre.view;

import com.jad.gobblingogre.controller.IController;
import com.jad.gobblingogre.model.IModel;

public class View implements IView {
    private final IModel model;
    private IController controller;

    public View(final IModel model) {
        this.model = model;
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }
}
