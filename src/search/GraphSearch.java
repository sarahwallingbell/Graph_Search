package search;

import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.Set;

import util.*;
import heuristic.*;
import search.Node;

/**
* Implements the GraphSearch algorithm
*
*/
public class GraphSearch {

	/**
	* This method takes in a puzzle and returns the solution in the form of a string of directions (U, D, L, R)
	* The directions specify the movements of the blank tile.
	*
	* @param puzzle
	* 		A starting puzzle configuration
	* @return
	* 		A string representing the directions for solving the puzzle or null if the puzzle is unsolvable
	*/
	public String solvePuzzle(int[][] puzzle) {
		Node initialState = new Node(puzzle);

/****** BFS *****/
		// MyQueue q = new MyQueue();
		// return graphSearch(initialState, q);

/****** DFS *****/
		 // MyStack s = new MyStack();
		 // return graphSearch(initialState, s);

/****** A* Manhattan *****/
		 // Manhattan manhattan = new Manhattan();
		 // System.out.println("Manhattan val: " + manhattan.evaluate(initialState));
		 // PriorityQueue pq = new PriorityQueue(manhattan);
		 // return graphSearch(initialState, pq);

/****** A* Misplaced *****/
		Misplaced misplaced= new Misplaced();
		System.out.println("Misplaced val: " + misplaced.evaluate(initialState));
		PriorityQueue pq = new PriorityQueue(misplaced);
		return graphSearch(initialState, pq);

	}


	/**
	* Implements the GraphSearch algorithm
	*
	* @param initialState
	* 		The initial starting state
	* @param frontier
	* 		An ordered collection of nodes used to keep track of unexpanded nodes
	* @return
	* 		A string representing the directions for solving the puzzle or null if the puzzle is unsolvable
	*/
	private static String graphSearch(Node initialState, OrderedCollection frontier){
		Set<Node> explored = new HashSet<Node>();
		frontier.push(initialState);

		while(!frontier.isEmpty()){
			Node u = frontier.pop();

			if(u.isGoal()){
				System.out.println("Number of nodes generated: " + explored.size());
				return constructPath(initialState, u);
			}
			explored.add(u);
			Node[] successors = u.getSuccessors();
			for (int i = 0; i < 4; i++){
				if (successors[i] != null && !explored.contains(successors[i])){
					frontier.push(successors[i]);
				}
			}
		}
		return null;
	}


	/**
	* Reconstructs path taken to input node from start.
	*
	@param s
	*		The start node, aka the ending point for path reconstruction
	* @param u
	*		The end node, aka the starting point for path reconstruction
	* @return
	*		A string representing the directions for solving the puzzle
	*/
	private static String constructPath(Node s, Node u){
		Node c = u; //c is the current node as we traverse to node s
		String path = "";
		while (!c.equals(s)){
			path = c.getAction() + path;
			c = c.getParent();
		}
		return path.toString();
	}

}
