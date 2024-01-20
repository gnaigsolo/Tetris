package tetrimino;

import tetrimino.Block;
import tetrimino.Brick;
import tetrimino.Shape;

import java.util.LinkedList;
import java.util.List;
import cordinate.*;
import game.*;
import tetrimino.*;

public class TetrominoBrick implements Brick {
    private List<Block> blocks;
    private Shape parent;
    @Override
    public List<Vector2> getBlocksPosition() {
        // Duyet qua cac khoi
        // Tinh toa do tuyet doi = toa do cha + toa do khoi
        List<Vector2> blocksPosition = new LinkedList<>();
        for(var block: blocks) {
            Vector2 position = block.getPosition();
            int absX = position.getX() + parent.getCurrentPosition().getX();
            int absY = position.getY() + parent.getCurrentPosition().getY();
            Vector2 absPostion = new Vector2(absX, absY);
            blocksPosition.add(absPostion);
        }
        return blocksPosition;
    }

    @Override
    public void setParent(Shape shape) {
        this.parent = shape;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }
    public TetrominoBrick() {
        blocks = new LinkedList<>();
    }
}
