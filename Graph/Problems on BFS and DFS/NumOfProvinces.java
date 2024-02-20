package com.testing.files;

import java.util.*;

class NumOfProvinces {
	// dfs traversal function
	private static void dfs(int node, int[][] adjLs, int vis[]) {
		vis[node] = 1;
		for (int it = 0; it < adjLs[node].length; it++) {
			if (vis[it] == 0 && adjLs[node][it] == 1) {
				dfs(it, adjLs, vis);
			}
		}
	}

	static int numProvinces(int[][] adj, int V) {
		int[][] adjLs = new int[V][V];

		// to change adjacency matrix to list
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				// self nodes are not considered
				if (adj[i][j] == 1 && i != j) {
					adjLs[i][j] = 1;
					adjLs[j][i] = 1;
				}
			}
		}

		int vis[] = new int[V];
		int cnt = 0;
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				cnt++;
				dfs(i, adjLs, vis);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {

		// adjacency matrix
		int[][] adj = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };

		NumOfProvinces ob = new NumOfProvinces();
		System.out.println(ob.numProvinces(adj, 3));
	}
}
