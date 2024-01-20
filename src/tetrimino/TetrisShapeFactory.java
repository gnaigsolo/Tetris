package tetrimino;

import tetrimino.Brick;
import tetrimino.BrickFactory;

import java.util.List;
import java.awt.Color;
import java.util.Random;
import cordinate.*;
import game.*;
import tetrimino.*;

public class TetrisShapeFactory implements ShapeFactory {
    private BrickFactory brickFactory;
    private static String[] shapeTypes;
    private static Color[] shapeColors;
    private static int numberOfColor;
    private static int numberOfShape;
    static {
        shapeTypes = new String[]{"I", "J", "L", "O", "Z", "T", "S"};
        shapeColors = new Color[]{new Color(241, 196, 15), new Color(230, 126, 34), new Color(231, 76, 60), new Color(22, 160, 133), new Color(22, 160, 133), new Color(41, 128, 185), new Color(142, 68, 173)};
        numberOfShape = 7;
        numberOfColor = 7;
    }
    @Override
    public Shape getShape() {
        String type = getRandomShape();
        Color color = getRandomColor();
        Shape shape = getShape(type, color);
        Random random = new Random();
        shape.setState(random.nextInt());
        return shape;
    }

    public Shape getShape(String type, Color color) {
        // tạo ra shape
        Shape shape = new Tetromino();
        shape.setColor(color);
        // lấy các tertrimino tương ứng
        // add Tetrimino
        List<Brick> bricks = brickFactory.getBricks(type);
        for(var brick : bricks)
            shape.addState(brick);
        return shape;
    }

    private Color getRandomColor() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt() % numberOfColor;
        index = Math.abs(index);
        return shapeColors[index];
    }

    private String getRandomShape() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt() % numberOfShape;
        index = Math.abs(index);
        return shapeTypes[index];
    }

    public TetrisShapeFactory() {
        // Khoi tao tetrimino.BrickFactory
        brickFactory = new TetrisBrickFactory();
    }


}
