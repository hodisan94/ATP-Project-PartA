package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze myMaze = new Maze(rows, cols);
        myMaze.setMyMaze(1);
        myMaze.setMazeBlockZero(myMaze.getStartPosition().getRowIndex(), myMaze.getStartPosition().getColumnIndex());
        Position current_place =new Position(myMaze.getStartPosition().getRowIndex(),myMaze.getStartPosition().getColumnIndex());
        //List<Position> positionList = new ArrayList<>();
        boolean finised = false;
        while (!finised) {
            if (current_place.getRowIndex() > myMaze.getGoalPosition().getRowIndex())
            {
                current_place.setX_pos(((current_place.getRowIndex())-1));
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if(current_place.getRowIndex() < myMaze.getGoalPosition().getRowIndex())
            {
                current_place.setX_pos(current_place.getRowIndex()+1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if (current_place.getColumnIndex()> myMaze.getGoalPosition().getColumnIndex())
            {
                current_place.setY_pos(current_place.getColumnIndex()-1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            if (current_place.getColumnIndex() <  myMaze.getGoalPosition().getColumnIndex())
            {
                current_place.setY_pos(current_place.getColumnIndex()+1);
                myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            }
            //myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());

            if (current_place.getRowIndex() == myMaze.getGoalPosition().getRowIndex() && current_place.getColumnIndex() == myMaze.getGoalPosition().getColumnIndex()) {
                finised = true;
            }

/*            List<Position> positionList = new ArrayList<>();
            for (int i = current_place.getColumnIndex() - 1; i <= current_place.getColumnIndex() + 1; i++) {
                if (myMaze.in_bound(current_place.getRowIndex(), i)) {
                     if (myMaze.getCellValue(current_place.getRowIndex(),i) != 0){
                    if (myMaze.getStartPosition().getRowIndex() == current_place.getRowIndex() && myMaze.getStartPosition().getColumnIndex() == i)
                        continue;
                    positionList.add((new Position(current_place.getRowIndex(), i)));
                    }
                }
            }
            for (int j = current_place.getRowIndex() - 1; j <= current_place.getRowIndex() + 1; j++) {

                if (myMaze.in_bound(j, current_place.getColumnIndex())) {
                      if(myMaze.getCellValue(j,current_place.getColumnIndex()) != 0 ) {
                    if (myMaze.getStartPosition().getColumnIndex() == current_place.getColumnIndex() && myMaze.getStartPosition().getRowIndex() == j)
                        continue;
                    positionList.add(new Position(j, current_place.getColumnIndex()));
                     }
                }
            }
            Random rd = new Random();
            System.out.println(positionList.size());

            int next_step = rd.nextInt(positionList.size());
            current_place = positionList.get(next_step);
            myMaze.setMazeBlockZero(current_place.getRowIndex(), current_place.getColumnIndex());
            if (current_place.getRowIndex() == myMaze.getGoalPosition().getRowIndex() && current_place.getColumnIndex() == myMaze.getGoalPosition().getColumnIndex()) {
                finised = true;
            }*/
        }




/*            for (int j = current_place.getRowIndex() -1 ; j <= current_place.getRowIndex() +1; j++){
                if (myMaze.in_bound(i,j)){
        }
                    positionList.add(new Position(i,j));
                }
            }*/
            //List<Position> positionList = new ArrayList<>();

        int arr[] = {0,1};
        for (int i = 0; i < myMaze.getMyMaze().length ; i++) {
            for (int j = 0 ; j < myMaze.getMyMaze()[0].length ; j++){
                Random rd = new Random();
                int rdNum = rd.nextInt(arr.length);
                if (myMaze.getMyMaze()[i][j] !=0)
                {
                    myMaze.getMyMaze()[i][j] = rdNum;

                }

            }

        }
            myMaze.printMaze();

            return myMaze;
        }
    }


