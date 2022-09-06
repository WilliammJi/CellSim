package Simulation;

import Util.Calculator;

import java.util.ArrayList;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{

    public ImmuneCell(int x, int y){
        super(3, x, y, 4);
    }

    @Override
    public void interactNeighbours(ArrayList<Cell> cellList){
        ArrayList<Cell> ImmuneAdjCells = new ArrayList<Cell>();

        for(Cell c : cellList){
            if((c.getX() - this.getX() >= -1) || (c.getX() - this.getX() <= 1)){
                if((c.getY() - this.getY() >= -1) || (c.getY() - this.getY() <= 1)){
                    ImmuneAdjCells.add(c);
                }
            }
        }

        for(Cell c : ImmuneAdjCells){
            if(c.getID() == 3) {
                cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()), new DeadCell(c.getX(), c.getY()));
            }
        }
    }
}