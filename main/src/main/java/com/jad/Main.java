package com.jad;

import com.jad.gobblingogre.controller.Controller;
import com.jad.gobblingogre.controller.IController;
import com.jad.gobblingogre.model.IModel;
import com.jad.gobblingogre.model.Model;
import com.jad.gobblingogre.view.IView;
import com.jad.gobblingogre.view.View;

public enum Main {
    ;

    public static void main(String[] args) {
        IModel model = new Model();
        IView view = new View(model);
        IController controller = new Controller(model, view);
        controller.proceed();
    }
}