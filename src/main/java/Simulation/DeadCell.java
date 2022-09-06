package Simulation;


/**
 * This cell is dead and does nothing
 */
public class DeadCell extends Cell{
    public DeadCell(int strength, int  x, int y, int id){
        super(0, x, y, 0);
    }
}
