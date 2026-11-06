package com.jad.gobblingogre.view;

import com.jad.gobblingogre.controller.IController;
import com.jad.gobblingogre.model.Board;
import com.jad.gobblingogre.model.IModel;
import com.jad.gobblingogre.model.Tile;
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
        textWindowSettings.setScreenHeight(110);
        textWindowSettings.setScreenWidth(450);
        textWindowSettings.setFontSize(6f);
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void display() {
        final Board board = this.model.getBoard(new Point(-5, -5), new Point(50, 30));
        final Screen screen = View.boardToScreen(board);
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < screen.getHeight(); row++) {
            for (int column = 0; column < screen.getWidth(); column++) {
                stringBuilder.append(screen.tiles()[row][column]);
            }
            stringBuilder.append("\n");
        }
        this.textWindow.display(stringBuilder.toString());
    }

    private static Screen boardToScreen(final Board board) {
        final char[][] pixel = new char[(board.getHeight() + 1) * Tile.SPRITE_HEIGHT][(board.getWidth() + 1) * Tile.SPRITE_WIDTH];
        for (int row = 0; row < board.getHeight(); row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                final Tile tile = board.tiles()[row][column];
                final char[][] spriteArray = tile.getSpriteArray();
                for (int spriteRow = 0; spriteRow < Tile.SPRITE_HEIGHT; spriteRow++) {
                    for (int spriteColumn = 0; spriteColumn < Tile.SPRITE_WIDTH; spriteColumn++) {
                        pixel[row * Tile.SPRITE_HEIGHT + spriteRow][column * Tile.SPRITE_WIDTH + spriteColumn] =
                                spriteArray[spriteRow][spriteColumn];
                    }
                }
            }
        }
        return new Screen(new Dimension(board.getWidth() * Tile.SPRITE_WIDTH, board.getHeight() * Tile.SPRITE_HEIGHT),
                          pixel);
    }
}
