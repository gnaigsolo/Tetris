package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public interface InputController extends KeyListener {
    boolean getKeyDown(int keyCode);
    void resetInput();
}
