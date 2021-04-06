package algorithms.maze3D;

import java.util.Objects;


public class Position3D {

    private int DepthIndex;
    private int RowIndex;
    private int ColumnIndex;

    public Position3D(int depthIndex,int rowIndex , int columnIndex)
    {
        this.DepthIndex = depthIndex;
        this.RowIndex = rowIndex;
        this.ColumnIndex = columnIndex;
    }

    public Position3D(Position3D position3D)
    {
        this.DepthIndex = position3D.getDepthIndex();
        this.RowIndex = position3D.getRowIndex();
        this.ColumnIndex = position3D.getColumnIndex();
    }

    public int getDepthIndex() {
        return DepthIndex;
    }

    public int getRowIndex() {
        return RowIndex;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Position3D)
        {
            Position3D pobj = (Position3D)obj;
            if(this.getDepthIndex() == pobj.DepthIndex && this.getRowIndex() == pobj.getRowIndex() && this.getColumnIndex() == pobj.getColumnIndex())
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DepthIndex, RowIndex, ColumnIndex);
    }

    @Override
    public String toString() {
        return "{" +
                DepthIndex +
                "," + RowIndex +
                "," + ColumnIndex +
                '}';
    }
}

