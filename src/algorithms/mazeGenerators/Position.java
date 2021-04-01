package algorithms.mazeGenerators;

public class Position {

    private int x_pos;
    private int y_pos;


    /**
     * @param x_pos
     * @param y_pos
     */
    public Position(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
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

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    /**
     * @return the position
     */


    @Override
    public String toString() {
        return "{" +
                x_pos +
                "," + y_pos +
                '}';
    }
}
