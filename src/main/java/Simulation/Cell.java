package Simulation;


import Util.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The default, boring cell.
 */

public class Cell {
    protected Calculator CellCalc = new Calculator(100, 100);
    protected int strength;
    private int x;
    private int y;
    protected int id;

    private HashMap<String, Integer> ConcMap = new HashMap<String, Integer>();

    private HashSet<String> SignalSet = new HashSet<String>();

    protected ArrayList<Cell> AdjCells = new ArrayList<Cell>();

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        if (strength > 0) {
            this.strength = strength;
        } else {
            this.strength = 0;
        }
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }

    public Cell(int strength, int x, int y, int id) {
        this.strength = getStrength();
        this.x = getX();
        this.y = getY();
        this.id = getID();
        setStrength(strength);
        setX(x);
        setY(y);
        setID(id);
    }

    public Cell() {
        this(0, 0, 0, 0);
    }

    //private void ReactAdj(ArrayList<String> AdjCells){
    //if(AdjCells.size() >= 6){
    //
    //}
    //}

    public void interactNeighbours(ArrayList<Cell> cellList){
        for (Cell c : cellList){
            if((c.getX() - this.getX() >= -1) || (c.getX() - this.getX() <= 1)) {
                if((c.getY() - this.getY() >= -1) || (c.getY() - this.getY() <= 1)) {
                    AdjCells.add(c);
                }
            }
        }
    }

}