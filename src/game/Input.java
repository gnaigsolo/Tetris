package game;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Input implements InputController{
    HashMap<Integer, Boolean> keyPress;
    HashMap<Integer, Boolean> keyType;
    HashMap<Integer, Boolean> keyRelease;

    Input() {
        keyPress = new HashMap<>();
        keyType = new HashMap<>();
        keyRelease = new HashMap<>();
    }

    @Override
    public boolean getKeyDown(int keyCode) {
        Boolean res = keyPress.get((Integer) keyCode);
        if(res == null)
            return false;
        return res;
    }

    @Override
    public void resetInput() {
        for(var key : keyPress.keySet() ) {
            keyPress.put(key, false);
        }
        for(var key : keyRelease.keySet() ) {
            keyRelease.put(key, false);
        }
        for(var key : keyType.keySet() ) {
            keyType.put(key, false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyType.put(e.getKeyCode(), true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPress.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyRelease.put(e.getKeyCode(), true);
    }
}
