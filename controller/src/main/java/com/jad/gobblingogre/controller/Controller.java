package com.jad.gobblingogre.controller;

import com.jad.gobblingogre.model.IModel;
import com.jad.gobblingogre.view.IView;

public class Controller implements IController {
    private final IModel model;
    private final IView view;

    public Controller(final IModel model, final IView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }


    @Override
    public void proceed() {
        this.view.display();
    }
}
