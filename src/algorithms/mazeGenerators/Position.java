package algorithms.mazeGenerators;

public class Position {

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
     * @return return the position as a string
     */
    @Override
    public String toString() {
        return "{" +
                x_pos +
                "," + y_pos +
                '}';
    }
}
