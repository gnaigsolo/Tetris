package game;

import cordinate.Vector2;

import java.awt.*;
import java.awt.event.KeyListener;

public interface GraphicController {
    public void render();
    public void draw(Vector2 positionCellToDraw, Color colorToDraw);
    public void addKeyListener(KeyListener keyListener);

}
