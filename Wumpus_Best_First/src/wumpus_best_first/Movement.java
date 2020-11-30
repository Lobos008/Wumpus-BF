package wumpus_best_first;

public class Movement {

    private int x, y;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Movement{" + "x=" + x + ", y=" + y + '}';
    }

}
