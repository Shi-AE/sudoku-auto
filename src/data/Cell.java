package data;

import java.util.ArrayList;

public class Cell {
    private final int x;
    private final int y;
    private ArrayList<Integer> num = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Integer> getNum() {
        return num;
    }

    public void setNum(ArrayList<Integer> num) {
        this.num = num;
    }
}
