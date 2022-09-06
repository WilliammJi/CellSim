package Simulation;


import Util.Calculator;

import java.util.ArrayList;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell{
    public CancerCell(int strength, int x, int y, int id){
        super(1, x, y, 3);
    }

    private Calculator calcCancer = new Calculator(100, 100);

    @Override
    public void interactNeighbours(ArrayList<Cell> cellList){
        ArrayList<Cell> CancerAdjCells = new ArrayList<Cell>();
        AdjCells = new ArrayList<Cell>();
        int countTissueAdj = 0;
        int countImmuneAdj = 0;

        for (Cell c : cellList){
            if((c.getX() - this.getX() >= -1) && (c.getX() - this.getX() <= 1)) {
                if((c.getY() - this.getY() >= -1) && (c.getY() - this.getY() <= 1)) {
                    AdjCells.add(c);
                    if(c.getID() == 1) {
                        countTissueAdj++;
                    }
                    if(c.getID() == 4) {
                        countImmuneAdj++;
                    }
                }
            }
        }

//        for (Cell c : cellList){
            //if((c.getX() - this.getX() >= -1) || (c.getX() - this.getX() <= 1)){
              //  if((c.getY() - this.getY() >= -1) || (c.getY() - this.getY() <= 1)){
                    //AdjCells.add(c);

//                    if(c.getID() == 1) {
//                        countTissueAdj++;
//                    }
//                    if(c.getID() == 4) {
//                        countImmuneAdj++;
//                    }

//                    if(c.getID() == 0) {
//                        cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
//                                new CancerCell(1, c.getX(), c.getY(), 3));
//                    }
//                    else if((countTissueAdj > countImmuneAdj) && (c.getID() == 1)){
//                        cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
//                                new DeadCell(0, c.getX(), c.getY(), 0));
//                    }
//                    else if(c.getID() == 4) {
//                        if (c.getStrength() > 0) {
//                            c.setStrength(c.getStrength() - 1);
//                        } else{
//                            cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
//                                    new DeadCell(0, c.getX(), c.getY(), 0));
//                        }
//                    }
               // }
            //}
 //       }

//        for (Cell c : AdjCells){
//            if(c.getID() == 1) {
//                countTissueAdj++;
//            }
//            if(c.getID() == 4) {
//                countImmuneAdj++;
//            }
//        }

        for (Cell c : AdjCells){
            if(c.getID() == 0) {
                cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
                        new CancerCell(1, c.getX(), c.getY(), 3));
            }
            else if((countTissueAdj > countImmuneAdj) && (c.getID() == 1)){
                cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
                        new DeadCell(0, c.getX(), c.getY(), 0));
            }
            else if(c.getID() == 4) {
                if (c.getStrength() > 0) {
                    c.setStrength(c.getStrength() - 1);
                } else{
                    cellList.set(Calculator.indexFromCoord(c.getX(), c.getY()),
                            new DeadCell(0, c.getX(), c.getY(), 0));
                }
            }
        }
    }
}
