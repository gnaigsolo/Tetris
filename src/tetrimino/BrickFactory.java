package tetrimino;

import tetrimino.Brick;

import java.util.List;

public interface BrickFactory {
    List<Brick> getBricks(String type);
}
