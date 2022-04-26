package util;
import java.util.Stack;
import search.Node;

/**
* Implements OrderedCollection interface
*
*/
public class Stack implements OrderedCollection{
  private Stack<Node> stack;

  /**
   * Constructs and empty stack.
   */
  public Stack(){
    stack = new Stack<Node>();
  }

  /**
   * Adds the node to the stack.
   * @param u The node to be added
   */
   @Override
  public void push(Node u){
      stack.push(u);
  }

  /**
   * Removes the head node from the stack.
   *
   * @return The head node in the ordered collection
   */
   @Override
  public Node pop(){
    return stack.pop();
  }

  /**
   * Returns true if the stack is empty, false otherwise
   * @return True if the stack is empty, false otherwise
   */
  public boolean isEmpty(){
    return stack.empty();
  }
}
