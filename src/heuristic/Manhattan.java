package heuristic;
import search.Node;

/**
* Calcualtes the manhattan distance of a given node in regards to the goal node.
*
*/
public class Manhattan implements Heuristic{

  public Manhattan(){}

    public int evaluate(Node node){
      int manhattanDist = 0;
      int[][] board = node.getBoard();
      int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};
      for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
          int num = board[i][j];
          if(num !=0){
            //calcualte where the num should be
            int goalRow = (num - 1) / 3;
            int goalCol = (num - 1) % 3;
            //calculate manhattan distance
            int manhattanX = Math.abs(i - goalRow);
            int manhattanY = Math.abs(j - goalCol);
            manhattanDist += manhattanX + manhattanY;
          }
        }
      }
      //return the estimate plus the cost (# of moves) from start to this node.
      return manhattanDist + node.getDepth();
    }
  }
