package tetrimino;

import tetrimino.Brick;
import cordinate.Vector2;
import java.awt.*;
import java.util.List;

public interface Shape {
    public void change(String direction); // next, prev
    public List<Vector2> getBlocksPosition(); // return blocks position
    public void draw(); // draw shape in to pixels map
    public Vector2 getCurrentPosition(); // get current Position of a shape
    public void setNewPosition(Vector2 newPosition); // set a new position to a shape
    public List<Vector2> getNextStateBlocksPosition(String direction);
    void setColor(Color color);
    void addState(Brick state);
    void setState(int index);

}
