package tetrimino;


import cordinate.*;
import game.*;
import tetrimino.*;

public class TetrominoBlock implements Block {
    private Vector2 position;
    @Override
    public Vector2 getPosition() {
        return position;
    }

    public TetrominoBlock(int x, int y) {
        this.position = new Vector2(x, y);
    }


}
