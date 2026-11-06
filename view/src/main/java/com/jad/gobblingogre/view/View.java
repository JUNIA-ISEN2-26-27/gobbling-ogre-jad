package com.jad.gobblingogre.view;

import com.jad.gobblingogre.controller.IController;
import com.jad.gobblingogre.model.Board;
import com.jad.gobblingogre.model.IModel;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;

public class View implements IView {
    private final IModel model;
    private IController controller;
    private TextWindow textWindow;

    public View(final IModel model) {
        this.model = model;
        TextWindowSettings textWindowSettings = new TextWindowSettings();
        textWindowSettings.setTitle("XenoJava");
        textWindowSettings.setScreenHeight(50);
        textWindowSettings.setScreenWidth(100);
        textWindowSettings.setFontSize(12f);
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void display() {
        final Board board = this.model.getBoard(new Point(0, 0), new Point(100, 20));
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < board.getHeight(); row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                stringBuilder.append(board.tiles()[row][column].getSpriteCharacter());
            }
            stringBuilder.append("\n");
        }
        this.textWindow.display(stringBuilder.toString());
    }
}
