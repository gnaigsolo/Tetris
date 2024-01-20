package tetrimino;

import tetrimino.Block;

import java.util.List;
import cordinate.*;
import game.*;
import tetrimino.*;


public interface Brick {
    List<Vector2> getBlocksPosition();
    void setParent(Shape shape);
    void addBlock(Block block);
}
