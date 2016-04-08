package basicgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class that implements a directed graph. The graph may have self-loops,
 * parallel edges. Vertices are labeled by integers 0 .. n-1 and may also have
 * String labels. The edges of the graph are not labeled. Representation of
 * edges via an adjacency matrix.
 *
 * @author UCSD MOOC development team and YOU
 *
 */
public class GraphAdjMatrix extends Graph {

	private final int defaultNumVertices = 5;
	private int[][] adjMatrix;

	/** Create a new empty Graph */
	public GraphAdjMatrix() {
		adjMatrix = new int[defaultNumVertices][defaultNumVertices];
	}

	/**
	 * Implement the abstract method for adding a vertex. If need to increase
	 * dimensions of matrix, double them to amortize cost.
	 */
	public void implementAddVertex() {
		int v = getNumVertices();
		if (v >= adjMatrix.length) {
			int[][] newAdjMatrix = new int[v * 2][v * 2];
			for (int i = 0; i < adjMatrix.length; i++) {
				for (int j = 0; j < adjMatrix.length; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			adjMatrix = newAdjMatrix;
		}
		for (int i = 0; i < adjMatrix[v].length; i++) {
			adjMatrix[v][i] = 0;
		}
	}

	/**
	 * Implement the abstract method for adding an edge. Allows for multiple
	 * edges between two points: the entry at row v, column w stores the number
	 * of such edges.
	 *
	 * @param v
	 *            the index of the start point for the edge.
	 * @param w
	 *            the index of the end point for the edge.
	 */
	public void implementAddEdge(int v, int w) {
		adjMatrix[v][w] += 1;
	}

	/**
	 * Implement the abstract method for finding all out-neighbors of a vertex.
	 * If there are multiple edges between the vertex and one of its
	 * out-neighbors, this neighbor appears once in the list for each of these
	 * edges.
	 *
	 * @param v
	 *            the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
	public List<Integer> getNeighbors(int v) {
		List<Integer> neighbors = new ArrayList<Integer>();
		for (int i = 0; i < getNumVertices(); i++) {
			for (int j = 0; j < adjMatrix[v][i]; j++) {
				neighbors.add(i);
			}
		}
		return neighbors;
	}

	/**
	 * Implement the abstract method for finding all in-neighbors of a vertex.
	 * If there are multiple edges from another vertex to this one, the neighbor
	 * appears once in the list for each of these edges.
	 *
	 * @param v
	 *            the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */
	public List<Integer> getInNeighbors(int v) {
		List<Integer> inNeighbors = new ArrayList<Integer>();
		for (int i = 0; i < getNumVertices(); i++) {
			for (int j = 0; j < adjMatrix[i][v]; j++) {
				inNeighbors.add(i);
			}
		}
		return inNeighbors;
	}

	// For learners to implement
	/**
	 * Implement the abstract method for finding all vertices reachable by two
	 * hops from v. Use matrix multiplication to record length 2 paths.
	 *
	 * @param v
	 *            the index of vertex.
	 * @return List<Integer> a list of indices of vertices.
	 */

	//private int[][] neighbour2Matrix;
	//neighbour2Matrix=new int[adjMatrix.length][adjMAtrix[0].length];

	//int[][] ar;
	//=new int[adjMatrix.length][adjMatrix[0].length];



	public List<Integer> getDistance2(int v) {
		List<Integer> neighbours2 = new ArrayList<>();
		//if(ar==null)
		//	ar=matrixMultiply(adjMatrix,adjMatrix);

		/*synchronized (this) {
			if (neighbour2Matrix == null)
				neighbour2Matrix = matrixMultiply(adjMatrix, adjMatrix);

			//if (v >= neighbour2Matrix.length)
				if (v < adjMatrix.length)
					neighbour2Matrix = matrixMultiply(adjMatrix, adjMatrix);
				else
					return neighbours2;
		}

		for (int i = 0; i < neighbour2Matrix.length; i++)
			for (int j = 0; j < neighbour2Matrix[v][i]; j++)
				neighbours2.add(i);

		return neighbours2;*/

		//ar=matrixMultiply(adjMatrix,adjMatrix);

		/*for(int i=0;i<ar.length;i++)
			for(int j=0;j<ar.length;j++)
				for(int k=0;k<ar[i][j];k++)
					if(ar[i][j]>0)
						neighbours2.add(i);
*/
		for (int i = 0; i < getNumVertices(); i++)
			for (int j = 0; j < adjMatrix[v][i]; j++)
				neighbours2.addAll(getNeighbors(i));

		return neighbours2;
	}

	/*private static int[][] matrixMultiply(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b.length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b.length; j++)
				for (int k = 0; k < b.length; k++)
					c[i][j] += a[i][k] * b[k][j];

		return c;
	}*/

	/**
	 * Generate string representation of adjacency matrix
	 *
	 * @return the String
	 */
	public String adjacencyString() {
		int dim = adjMatrix.length;
		String s = "Adjacency matrix";
		s += " (size " + dim + "x" + dim + " = " + dim * dim + " integers):";
		for (int i = 0; i < dim; i++) {
			s += "\n\t" + i + ": ";
			for (int j = 0; j < adjMatrix[i].length; j++) {
				s += adjMatrix[i][j] + ", ";
			}
		}
		return s;
	}

}