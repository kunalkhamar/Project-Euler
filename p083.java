import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import algs.graphs.DijkstraSP;
import algs.graphs.DirectedEdge;
import algs.graphs.WeightedDigraph;

public class p083 {

	public static void main(String[] args) throws IOException {
		int N = 80;
		Scanner in = new Scanner(new File("./input-files/p083_matrix.txt"));
		int[][] input = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] line = in.nextLine().trim().split(",");
			for (int j = 0; j < line.length; j++)
				input[i][j] = Integer.parseInt(line[j].trim());
		}
		in.close();

		int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };	// allowed directions
		WeightedDigraph graph = new WeightedDigraph(N * N + 1);
		
		// add 4 edges to each vertex
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < dirs.length; k++) {
					try {
						int ito = i + dirs[k][0];
						int jto = j + dirs[k][1];
						DirectedEdge e = new DirectedEdge(i * N + j, ito * N + jto, input[ito][jto]);
						graph.addEdge(e);
					} catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
		}
		
		// connect source
		int source = N * N;
		DirectedEdge sourceEdge = new DirectedEdge(source, 0, input[0][0]);
		graph.addEdge(sourceEdge);
		
		DijkstraSP dijkstra = new DijkstraSP(graph, source);
		System.out.println(dijkstra.getDistTo(N * N - 1));
	}
}
