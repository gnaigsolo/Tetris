package game;

import cordinate.Vector2;

import javax.swing.*;
import java.awt.*;

public class PixelMap2D extends JFrame {
    private Color[][] colorMap;

    private boolean isVisible;
    private Vector2 _cellsize;
    private Vector2 _mapSize;



    public PixelMap2D(Vector2 _mapSize, Vector2 _cellsize) {
        this._mapSize = _mapSize;
        this._cellsize = _cellsize;
        init();
        this.isVisible = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(_mapSize.getX() * _cellsize.getX() + 12, _mapSize.getY() * _cellsize.getY() + 36);
        setResizable(false);
        setTitle("Tetris");
        setVisible(true);

    }

    synchronized public void drawPixel(Vector2 point, Color c) {
        int x = point.getX();
        int y = point.getY();
        y = this._mapSize.getY() - y - 1;
        if (x >= 0 && x < _mapSize.getX() && y >= 0 && y < _mapSize.getY()) {
            colorMap[x][y] = c;
        }
    }

    void init() {
        colorMap = new Color[_mapSize.getX()][];
        for(int i = 0; i < _mapSize.getX(); ++i) {
            colorMap[i] = new Color[_mapSize.getY()];
            for(int j = 0; j < _mapSize.getY(); ++j) {
                colorMap[i][j] = Color.BLACK;
            }
        }
    }


    synchronized public void push() {
        repaint();
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
        super.setVisible(isVisible);
    }


    synchronized public void paint(Graphics g) {

        if (isVisible) {


            for (int i = 0; i < _mapSize.getX(); i++) {
                for (int j = 0; j < _mapSize.getY(); j++) {
                    int x = i * _cellsize.getX() + 5;
                    int y = j * _cellsize.getY() + 29;

                    g.setColor(colorMap[i][j]);
                    g.fillRect(x, y, _cellsize.getX(), _cellsize.getY());
                }
            }


//            g.setColor(Color.BLACK);
//            for (int i = 1; i < _mapSize.getX(); i++) {
//                int x = i * _cellsize.getX();
//                g.drawLine(x, 0, x, getHeight());
//            }
//            for (int i = 1; i < _mapSize.getY(); i++) {
//                int y = i * _cellsize.getY();
//                g.drawLine(0, y, getWidth(), y);
//            }
        }
        reset();
    }

    public void drawRectangle(Vector2 start, Vector2 end) {

    }

    synchronized void reset() {
        for(int i = 0; i < _mapSize.getX(); ++i) {
            for(int j = 0; j < _mapSize.getY(); ++j) {
                drawPixel(new Vector2(i,j), TetrisGameConfig.getInstance().getBackgroundColor());
            }
        }
    }

    public static void main(String[] args) {
        PixelMap2D pixelMap2D = new PixelMap2D(new Vector2(10,20), new Vector2(30,30));
        pixelMap2D.drawPixel(new Vector2(5,5), Color.YELLOW);
        pixelMap2D.drawPixel(new Vector2(3,3), Color.BLUE);

    }
}
