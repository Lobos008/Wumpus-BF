package wumpus_best_first;

import java.util.ArrayList;

public class Agent {

    private int x_cuurent, y_current;
    private ArrayList solution;
    private int attack;

    public Agent(int x_cuurent, int y_current) {
        this.x_cuurent = x_cuurent;
        this.y_current = y_current;
        this.solution = new ArrayList<Movement>();
        this.attack = 1;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    

    public int getX_cuurent() {
        return x_cuurent;
    }

    public void setX_cuurent(int x_cuurent) {
        this.x_cuurent = x_cuurent;
    }

    public int getY_current() {
        return y_current;
    }

    public void setY_current(int y_current) {
        this.y_current = y_current;
    }

    public ArrayList getSolution() {
        return solution;
    }

    public void setSolution(ArrayList solution) {
        this.solution = solution;
    }

    public void addMovement(int x, int y) {
        this.solution.add(new Movement(x, y));
    }

}
