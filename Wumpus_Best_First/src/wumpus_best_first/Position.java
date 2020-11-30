package wumpus_best_first;

public class Position {

    private int x, y;
    private String tipo;

    public Position(int x, int y, String tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
