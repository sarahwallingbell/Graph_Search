package heuristic;
import search.Node;

/**
 * Implements the Heuristic interface. Calculates the number of misplaced tiles
 * in a node. A tile is misplaced if it is not in its goal location.
 */
public class Misplaced implements Heuristic{

  public Misplaced(){}

  /**
   * Calculates the number of misplaced tiles and returns a heurstic measurement
   * of the success of the given node.
   *
   * @param node the node to be evaluated
   * @return an integer representing the cost from the start to the given node
   * plus the number of misplaced tiles.
   */
  public int evaluate(Node node){
    int numMisplaced = 0;
    int[][] board = node.getBoard();
    int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        //com
        if(board[i][j] != goal[i][j]){
          numMisplaced++;
        }
      }
    }
    //return the estimate plus the cost (# of moves) from start to this node.
    return numMisplaced + node.getDepth();
  }
}
