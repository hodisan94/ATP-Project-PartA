package algorithms.mazeGenerators;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {

    private int x_pos;
    private int y_pos;


    /**
     * @param x_pos is x position
     * @param y_pos is y position
     */
    public Position(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public Position(Position position) {
        this.x_pos = position.getRowIndex();
        this.y_pos = position.getColumnIndex();
    }


    /**
     * @return the x position
     */
    public int getRowIndex(){
        return x_pos;
    }

    /**
     * @return the y position
     */
    public int getColumnIndex(){
        return y_pos;
    }

    /**
     * @param x_pos x's value to change for
     */
    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    /**
     * @param y_pos y's value to change for
     */
    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }


    /**
     * @param obj is an object that should be Position to compare the position
     * @return true if obj and the position are equals anf false if not
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Position)
        {
            Position pobj = (Position)obj;

            if(this.getRowIndex() == pobj.getRowIndex() && this.getColumnIndex() == pobj.getColumnIndex())
                return true;

        }
        return false;
    }


    /**
     * @return the position's hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(x_pos, y_pos);
    }

    /**
     * @return the position as a string
     */
    @Override
    public String toString() {
        return "{" +
                x_pos +
                "," + y_pos +
                '}';
    }
}
