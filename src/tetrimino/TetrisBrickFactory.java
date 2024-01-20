package tetrimino;

import tetrimino.Brick;
import tetrimino.BrickFactory;

import java.util.LinkedList;
import java.util.List;
import cordinate.*;
import game.*;
import tetrimino.*;

public class TetrisBrickFactory implements BrickFactory {
    @Override
    public List<Brick> getBricks(String type) {
        if(type.equals("I"))
            return getI();
        if(type.equals("J"))
            return getJ();
        if(type.equals("L"))
            return getL();
        if(type.equals("O"))
            return getO();
        if(type.equals("Z"))
            return getZ();
        if(type.equals("T"))
            return getT();
        if(type.equals("S"))
            return getS();
        return null;
    }

    List<Brick> getO() {
        List<Brick> o = new LinkedList<>(List.of(getO0()));
        return o;
    }


    List<Brick> getI() {
        List<Brick> i = new LinkedList<>(List.of(getI0(), getI1()));
        return i;
    }

    List<Brick> getJ() {
        List<Brick> j = new LinkedList<>(List.of(getJ0(), getJ1(), getJ2(), getJ3()));
        return j;
    }

    List<Brick> getL() {
        List<Brick> l = new LinkedList<>(List.of(getL0(), getL1(), getL2(), getL3()));
        return l;
    }

    List<Brick> getS() {
        List<Brick> s = new LinkedList<>(List.of(getS0(), getS1()));
        return s;
    }

    List<Brick> getZ() {
        List<Brick> z = new LinkedList<>(List.of(getZ0(), getZ1()));
        return z;
    }

    List<Brick> getT() {
        List<Brick> t = new LinkedList<>(List.of(getT0(),getT1(), getT2(), getT3()));
        return t;
    }



    private Brick getO0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        return brick;
    }

    private Brick getI0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(0, 2));
        brick.addBlock(new TetrominoBlock(0, 3));
        return brick;
    }

    private Brick getI1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(2, 0));
        brick.addBlock(new TetrominoBlock(3, 0));
        return brick;
    }

    private Brick getS0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(2, 1));
        return brick;
    }

    private Brick getS1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(0, 2));
        return brick;
    }

    private Brick getZ0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(2, 0));
        return brick;
    }

    private Brick getZ1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(1, 2));
        return brick;
    }

    private Brick getJ0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(2, 1));
        brick.addBlock(new TetrominoBlock(2, 0));
        return brick;
    }

    private Brick getJ1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(1, 2));
        return brick;
    }

    private Brick getJ2() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(2, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        return brick;
    }

    private Brick getJ3() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(0, 2));
        brick.addBlock(new TetrominoBlock(1, 2));
        return brick;
    }

    private Brick getL0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(2, 1));
        return brick;
    }

    private Brick getL1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(1, 2));
        brick.addBlock(new TetrominoBlock(0, 2));
        return brick;
    }

    private Brick getL2() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(2, 0));
        brick.addBlock(new TetrominoBlock(2, 1));
        return brick;
    }

    private Brick getL3() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(0, 2));
        return brick;
    }

    private Brick getT0() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(2, 1));
        return brick;
    }

    private Brick getT1() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(1, 2));
        return brick;
    }

    private Brick getT2() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(1, 0));
        brick.addBlock(new TetrominoBlock(2, 0));
        brick.addBlock(new TetrominoBlock(1, 1));
        return brick;
    }

    private Brick getT3() {
        Brick brick = new TetrominoBrick();
        brick.addBlock(new TetrominoBlock(0, 0));
        brick.addBlock(new TetrominoBlock(0, 1));
        brick.addBlock(new TetrominoBlock(0, 2));
        brick.addBlock(new TetrominoBlock(1, 1));
        return brick;
    }




}
