package algorithms.maze3D;

import java.util.Objects;


public class Position3D {

    private int DepthIndex;
    private int RowIndex;
    private int ColumnIndex;

    /**
     * A constructor
     * @param depthIndex
     * @param rowIndex
     * @param columnIndex
     */
    public Position3D(int depthIndex,int rowIndex , int columnIndex) {
        this.DepthIndex = depthIndex;
        this.RowIndex = rowIndex;
        this.ColumnIndex = columnIndex;
    }

    /**
     * A constructor
     * @param position3D
     */
    public Position3D(Position3D position3D) {
        this.DepthIndex = position3D.getDepthIndex();
        this.RowIndex = position3D.getRowIndex();
        this.ColumnIndex = position3D.getColumnIndex();
    }

    /**
     * @return the position3D's depth
     */
    public int getDepthIndex() {
        return DepthIndex;
    }

    /**
     * @return the position3D's row
     */
    public int getRowIndex() {
        return RowIndex;
    }

    /**
     * @return the position3D's column
     */
    public int getColumnIndex() {
        return ColumnIndex;
    }

    public void setDepthIndex(int depthIndex) {
        DepthIndex = depthIndex;
    }

    public void setRowIndex(int rowIndex) {
        RowIndex = rowIndex;
    }

    public void setColumnIndex(int columnIndex) {
        ColumnIndex = columnIndex;
    }

    /**
     * @param obj is an object that should be Position3D to compare the position3D
     * @return true if obj and the position are equals anf false if not
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Position3D)
        {
            Position3D pobj = (Position3D)obj;
            if(this.getDepthIndex() == pobj.DepthIndex && this.getRowIndex() == pobj.RowIndex && this.getColumnIndex() == pobj.ColumnIndex)
                return true;
        }
        return false;
    }

    /**
     * @return the position3D's hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(DepthIndex, RowIndex, ColumnIndex);
    }

    /**
     * @return the position3D as a string
     */
    @Override
    public String toString() {
        return "{" +
                DepthIndex +
                "," + RowIndex +
                "," + ColumnIndex +
                '}';
    }
}

