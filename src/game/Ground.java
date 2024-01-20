package game;

import cordinate.Vector2;

public interface Ground {
    public boolean isHasBlockAt(Vector2 position); // check if a block in ground or not
    public void addBlockAt(Vector2 position);
    public void clearRowThatIsFull();
    public boolean isReachHeightLimit();
    public void draw();
    public void clear();
}
