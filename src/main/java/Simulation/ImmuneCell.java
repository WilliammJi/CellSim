package Simulation;

import Util.Calculator;

import java.util.ArrayList;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{

    public ImmuneCell(int strength, int x, int y, int id){
        super(3, x, y, 4);
    }

    private Calculator calcImmune = new Calculator(100, 100);

    @Override
    public void interactNeighbours(ArrayList<Cell> cellList){
        ArrayList<Cell> ImmuneAdjCells = new ArrayList<Cell>();
        AdjCells = new ArrayList<Cell>();

        for (Cell c : cellList){
            if((c.getX() - this.getX() >= -1) && (c.getX() - this.getX() <= 1)) {
                if((c.getY() - this.getY() >= -1) && (c.getY() - this.getY() <= 1)) {
                    AdjCells.add(c);
                }
            }
        }

        //for (Cell c : cellList){
          //  if((c.getX() - this.getX() >= -1) || (c.getX() - this.getX() <= 1)){
            //    if((c.getY() - this.getY() >= -1) || (c.getY() - this.getY() <= 1)){
              //      AdjCells.add(c);

                    //if(c.getID() == 3) {
                      //  cellList.set(calcImmune.indexFromCoord(c.getX(), c.getY()),
                        //        new DeadCell(0, c.getX(), c.getY(), 0));
                    //}
                //}
            //}
        //}

        for (Cell c : AdjCells){
            if(c.getID() == 3) {
                cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
                        new DeadCell(0, c.getX(), c.getY(), 0));
            }
        }
    }
}