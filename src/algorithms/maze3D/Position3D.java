package algorithms.maze3D;

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
}

