package search;
import java.util.Arrays;

/**
* Implements NodeIfc interface
*
*/
public class Node implements NodeIfc{
  private int[][] state; //the board configuration
  private Node parent;
  private String action; //The action that led from the parent to this node
  private int depth;

  public static final String UP = "U";
	public static final String DOWN = "D";
	public static final String LEFT = "L";
	public static final String RIGHT = "R";
	public static final int[][] GOAL = {{1,2,3}, {4,5,6}, {7,8,0}};

  /**
  * Constructs a Node with the specified board state. Sets the parent and
  * action to null and the depth to 0.
  * @param board the initial board state of this node
  */
  public Node(int[][] board){
    state = board;
    parent = null;
    action = null;
    depth = 0;
  }

  /**
  * Constructs a Node with the specified parent and action, and sets the state
  * equal to the board after the move is made on the parent board. Depth is set
  * to the parent'd depth plus one.
  * @param parent the parent node of this Node
  * @param move the move to be made from the parent board to generate the new state
  */
  public Node(Node parent, String move){
    this.state = makeMove(parent.getBoard(), move); //problem
    this.parent = parent;
    action = move;
    depth = parent.getDepth();
    depth++;
  }


  /**
  * Returns the 4 successors of the current node which correspond to the blank tile being moved
  * up, down, left, or right. If a particular direction is illegal, the corresponding entry in
  * the return array is null.
  *
  * @return An array containing successor nodes or null if an action is illegal
  */
  public Node[] getSuccessors(){
    Node[] successors = new Node[4];
    successors[0] = new Node(this, UP);
    if(successors[0].getBoard() == null){
      successors[0] = null;
    }
    successors[1] = new Node(this, DOWN);
    if(successors[1].getBoard() == null){
      successors[1] = null;
    }
    successors[2] = new Node(this, LEFT);
    if(successors[2].getBoard() == null){
      successors[2] = null;

    }
    successors[3] = new Node(this, RIGHT);
    if(successors[3].getBoard() == null){
      successors[3] = null;
    }
    return successors;
  }

  /**
  * Returns the board corresponding to the state
  * @return  A particular state of the 8-puzzle
  */
  public int[][] getBoard(){
    return state;
  }

  /**
  * Returns the action taken to get to this state
  * @return the action taken to get to this state
  */
  public String getAction(){
    return action;
  }


  /**
  * Returns the board corresponding to the goal configuration
  * @return The goal state
  */
  public int[][] getGoal(){
    return GOAL;
  }

  /**
  * Returns the node's parent node
  * @return The parent node
  */
  public Node getParent(){
    return parent;
  }


  /**
  * Returns the number of moves from the initial start node to the current node
  * @return The number of moves from the initial node to the current node
  */
  public int getDepth(){
    return depth;
  }

  /**
  * Returns true if the state is the goal state and false otherwise
  * @return True if the state is the goal, false otherwise
  */
  public boolean isGoal(){
    int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if (state[i][j] != goal[i][j]){
          return false;
        }
      }
    }
    return true;
  }


  /**
  * Default implementations of these 3 methods are provided by Java's Object class however you will
  * need to override them so that nodes can be compared to one another. The hashcode and equals methods
  * should use the board. That is, two nodes are equal if they have the same board configuration.
  */

  /**
  * Calculates a hashcode based on the node's board.
  * @return an integer unique to the state of the board.
  */
  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(state);
        return result;
    }


  /**
  * Comapres this Node with another Node. Nodes are equal if they have the same
  * board state.
  * @param obj a Node to compare with this one.
  * @return true if the Nodes are equal (have same board state), else false.
  */
  @Override
  public boolean equals(Object obj){
    if(obj instanceof Node){
      Node other = (Node) obj;
      boolean equal = true;
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          if (state[i][j] != other.getBoard()[i][j]){
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }

  /**
  * Returns a string representation of the state of the node.
  * @return a string representation of the board state
  */
  @Override
  public String toString(){
    String ret = "";
    for (int i = 0; i < 3; i++){
      for (int j = 0; j <3; j++){
        ret += state[i][j];
      }
      ret += "\n";
    }
    return ret;
  }


  //MY PRIVATE METHODS:

  /**
  * Returns updated state after the specified move of the blank tile.
  * If move is not possible, returns null.
  *
  * @param move
  *   The direction to move the blank tile
  * @param board
  *   The initial state of the board, to be changed
  * @return the board state after the move, or null if move is illegal
  */
  private int[][] makeMove(int[][] board, String move){
    if(move.equals(UP)){
      //check to see if move is valid
      for(int k = 0; k < 3; k++){
        if(board[0][k] == 0){
          //the blank tile cannot be moved up.
          return null;
        }
      }
      //if move is valid, update the board
      int[][] newBoard = new int[3][3];
      for (int i = 0; i < 3; i++){
        newBoard[i] = board[i].clone();
      }

      boolean swapped = false;
      for(int i = 1; i < 3; i++){
          if(swapped){
            break;
          }
        for(int j = 0; j < 3; j++){
          //when find blank tile, swap with above tile
          if(newBoard[i][j] == 0){
            newBoard[i][j] = newBoard[i-1][j];
            newBoard[i-1][j] = 0;
            swapped = true;
            break;
          }
        }
      }
      swapped = false;
      return newBoard;
    }
    if(move.equals(DOWN)){
      //check to see if move is valid
      for(int k = 0; k < 3; k++){
        if(board[2][k] == 0){
          //the blank tile cannot be moved down.
          return null;
        }
      }
      //if move is valid, update the board
      int[][] newBoard = new int[3][3];
      for (int i = 0; i < 3; i++){
        newBoard[i] = board[i].clone();
      }
      boolean swapped = false;
      for(int i = 0; i < 2; i++){
        if(swapped){
          break;
        }
        for(int j = 0; j < 3; j++){
          //when find blank tile, swap with above tile
          if(newBoard[i][j] == 0){
            newBoard[i][j] = newBoard[i+1][j];
            newBoard[i+1][j] = 0;
            swapped = true;
            break;
          }
        }
      }
      swapped = false;
      return newBoard;
    }
    if(move.equals(LEFT)){
      //check to see if move is valid
      for(int k = 0; k < 3; k++){
        if(board[k][0] == 0){
          //the blank tile cannot be moved left.
          return null;
        }
      }
      boolean swapped = false;
      //if move is valid, update the board
      int[][] newBoard = new int[3][3];
      for (int i = 0; i < 3; i++){
        newBoard[i] = board[i].clone();
      }
      for(int i = 0; i < 3; i++){
        if(swapped){
          break;
        }
        for(int j = 1; j < 3; j++){
          //when find blank tile, swap with above tile
          if(newBoard[i][j] == 0){
            newBoard[i][j] = newBoard[i][j-1];
            newBoard[i][j-1] = 0;
            swapped = true;
            break;
          }
        }
      }
      swapped = false;
      return newBoard;
    }
    if(move.equals(RIGHT)){
      //check to see if move is valid
      for(int k = 0; k < 3; k++){
        if(board[k][2] == 0){
          //the blank tile cannot be moved right.
          return null;
        }
      }
    int[][] newBoard = new int[3][3];
    for (int i = 0; i < 3; i++){
      newBoard[i] = board[i].clone();
    }

      boolean swapped = false;
      //if move is valid, update the board
      for(int i = 0; i < 3; i++){
        if(swapped){
          break;
        }
        for(int j = 0; j < 2; j++){
          //when find blank tile, swap with above tile
          if(newBoard[i][j] == 0){
            newBoard[i][j] = newBoard[i][j+1];
            newBoard[i][j+1] = 0;
            swapped = true;
            break;
          }
        }
      }
      swapped = false;
      return newBoard;
    }
    //else invalid input move
    return board;
  }
}
