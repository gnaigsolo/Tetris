package tetrimino;

import java.awt.*;
import java.awt.event.KeyListener;
import cordinate.*;
import game.*;
import tetrimino.*;


public class Tetris2DGraphic implements GraphicController {
    private PixelMap2D pixelMap2D;
    private GameConfig gameConfig;
    public Tetris2DGraphic() {
        gameConfig = TetrisGameConfig.getInstance();
        int cellWidth = gameConfig.getCellWidth();
        int cellHeight = gameConfig.getCellHeight();
        int width = gameConfig.getNumberOfColumn();
        int height = gameConfig.getNumberOfRow();
        pixelMap2D = new PixelMap2D(new Vector2(width, height), new Vector2(cellWidth, cellHeight));
    }
    @Override
    public void render() {
        pixelMap2D.push();
    }

    @Override
    public void draw(Vector2 positionCellToDraw, Color colorToDraw) {
        int x = positionCellToDraw.getX();
        int y = positionCellToDraw.getY();
        pixelMap2D.drawPixel(new Vector2(y,x), colorToDraw);

    }

    @Override
    public void addKeyListener(KeyListener keyListener) {
        pixelMap2D.addKeyListener(keyListener);
    }

    public static void main(String[] args) throws InterruptedException {
        Tetris2DGraphic tetris2DGraphic = new Tetris2DGraphic();
        Thread.sleep(1000);
        tetris2DGraphic.draw(new Vector2(5, 5), Color.RED);
        tetris2DGraphic.render();

    }


}
