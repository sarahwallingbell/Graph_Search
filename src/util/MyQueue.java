package util;
import java.util.LinkedList;
import search.Node;

/**
* Implements OrderedCollection interface
*
*/
public class MyQueue implements OrderedCollection{
  private LinkedList<Node> queue;

  /**
   * Constructs and empty queue.
   */
  public MyQueue(){
    queue = new LinkedList<Node>();
  }

  	/**
  	 * If node isn't in queue, adds the node to the end of the queue.
  	 * @param u The node to be added
  	 */
  	public void push(Node u){
      queue.add(u);
    }

  	/**
  	 * Removes the head node from the queue.
  	 *
  	 * @return The head node in the ordered collection
  	 */
  	public Node pop(){
      return queue.removeFirst();
    }

  	/**
  	 * Returns true if the queue is empty, false otherwise
  	 * @return True if the queue is empty, false otherwise
  	 */
     @Override
  	public boolean isEmpty(){
      return queue.isEmpty();
    }
  }
