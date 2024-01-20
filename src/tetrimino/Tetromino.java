package tetrimino;

import tetrimino.Brick;
import tetrimino.Shape;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import cordinate.*;
import game.*;
import tetrimino.*;

public class Tetromino implements Shape {
    List<Brick> state;
    private int currentState;
    private GraphicController graphicController;
    private Color color;
    private Vector2 position;

    @Override
    public void change(String direction) {
        int numberOfState = state.size();
        currentState = getNextStateIndex(direction);
    }

    @Override
    public List<Vector2> getBlocksPosition() {
        Brick currentState = state.get(this.currentState);
        return currentState.getBlocksPosition();
    }

    @Override
    public void draw() {
        Brick currentState = state.get(this.currentState);
        for(Vector2 blockPos : currentState.getBlocksPosition()) {
            Vector2 pixelsToDraw = new Vector2(blockPos.getY(), blockPos.getX());
            graphicController.draw(pixelsToDraw, color);
        }
    }

    @Override
    public Vector2 getCurrentPosition() {
        return position;
    }

    @Override
    public void setNewPosition(Vector2 newPosition) {
        this.position = newPosition;
    }

    @Override
    public List<Vector2> getNextStateBlocksPosition(String direction) {
        Brick nextState = state.get(getNextStateIndex(direction));
        return nextState.getBlocksPosition();
    }

    private int getNextStateIndex(String direction) {
        int numberOfState = state.size();
        int nextState = currentState;
        if(direction.equals("next"))
            nextState += 1;
        else if (direction.equals("prev"))
            nextState -= 1;
        nextState += numberOfState;
        nextState %= numberOfState;
        return nextState;
    }

    public void addState(Brick state) {
        this.state.add(state);
        state.setParent(this);
    }

    @Override
    public void setState(int index) {
        index = Math.abs(index);
        index %= state.size();
        this.currentState = index;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public Tetromino() {
        state = new LinkedList<>();
        currentState = 0;
        graphicController = TetrisGameConfig.getInstance().getGraphicController();

    }


}
