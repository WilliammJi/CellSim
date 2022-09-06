package Simulation;


import Util.Calculator;

import java.util.ArrayList;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 */

public class TissueCell extends Cell{

    public TissueCell(int strength, int x, int y, int id){
        super(0, x, y, 1);
    }

    private Calculator calcTissue = new Calculator(100, 100);

    @Override
    public void interactNeighbours(ArrayList<Cell> cellList){
        ArrayList<Cell> TissueAdjCells = new ArrayList<Cell>();
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

                    //if(c.getID() == 1) {
                      //  double rngTissue = Math.random() * 100;
                        //if (rngTissue < 70.0) {
                          //  cellList.set(calcTissue.indexFromCoord(c.getX(), c.getY()),
                            //        new TissueCell(0, c.getX(), c.getY(), 1));
                        //}
                    //}

                //}
            //}
        //}

        for (Cell c : AdjCells){
            if(c.getID() == 0){
                double rngTissue = Math.random()*100;
                if(rngTissue < 70.0){
                    cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
                            new TissueCell(0, c.getX(), c.getY(), 1));
                }
            }
        }
    }
}
