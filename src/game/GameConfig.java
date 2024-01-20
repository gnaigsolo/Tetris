package game;

import tetrimino.ShapeFactory;

import java.awt.*;

public interface GameConfig {
    int getNumberOfRow();
    int getNumberOfColumn();
    Color getGroundColor();
    int getCellWidth();
    int getCellHeight();
    GraphicController getGraphicController();
    ShapeFactory getShapeFactory();
    Color getBackgroundColor();
    int getDelayTime();
    void addBreakLine();
    void levelUp();
    void restart();
}
