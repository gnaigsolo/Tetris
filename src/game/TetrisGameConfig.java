package game;

import tetrimino.ShapeFactory;
import tetrimino.Tetris2DGraphic;
import tetrimino.TetrisShapeFactory;

import java.awt.*;
import cordinate.*;
import game.*;
import tetrimino.*;


public class TetrisGameConfig implements GameConfig {

    private static TetrisGameConfig instance;
    private int numberOfLineToLevelUp;
    private int startDelayTime;
    private int numberOfRow;
    private int numberOfColumn;
    private int cellWidth;
    private int cellHeight;
    private ShapeFactory shapeFactory;
    private GraphicController graphicController;
    private Color groundColor;
    private Color backgroundColor;
    private int breakLine;
    private int difficult;
    private TetrisGameConfig() {
        numberOfRow = 20;
        numberOfColumn = 10;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        cellWidth = size.height/35;
        cellHeight = size.height/35;
        groundColor = new Color(44, 62, 80);
        backgroundColor = new Color(223, 230, 233);
        difficult = 1;
        startDelayTime = 300;
        numberOfLineToLevelUp = 10;
    }

    public static TetrisGameConfig getInstance() {
        if(instance == null)
            instance = new TetrisGameConfig();
        return instance;
    }


    @Override
    public int getNumberOfRow() {
        return numberOfRow;
    }

    @Override
    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    @Override
    public Color getGroundColor() {
        return groundColor;
    }

    @Override
    public int getCellWidth() {
        return cellWidth;
    }

    @Override
    public int getCellHeight() {
        return cellHeight;
    }

    @Override
    public GraphicController getGraphicController() {
        if(graphicController == null)
            graphicController = new Tetris2DGraphic();
        return graphicController;
    }

    @Override
    public ShapeFactory getShapeFactory() {
        if(shapeFactory == null)
            shapeFactory = new TetrisShapeFactory();
        return shapeFactory;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public int getDelayTime() {
        return startDelayTime/((difficult + 1)/2) + 30;
    }

    @Override
    public void addBreakLine() {
        this.breakLine++;
        if(breakLine == numberOfLineToLevelUp) {
            breakLine = 0;
            levelUp();
        }
    }

    @Override
    public void levelUp() {
        difficult++;
    }

    @Override
    public void restart() {
        breakLine = 0;
        difficult = 1;
    }

    public static void main(String[] args) {
        TetrisGameConfig tetrisGameConfig = TetrisGameConfig.getInstance();
        tetrisGameConfig.getGraphicController();

    }




}
