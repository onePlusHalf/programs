// A program in Java to: 
// - PRINT DFS of a Graph
// - Find Path between 2 vertices of a Graph
// * There are some shortcomings to this , i'll be addressing them ASAP.

import java.util.*;

class Graph{
	ArrayList<ArrayList<Integer>> adjacencyList;
	Boolean visited[];
	
	Graph(int numberOfVertices) {
		adjacencyList = new ArrayList<ArrayList<Integer>>(numberOfVertices);
		visited = new Boolean[numberOfVertices];
		Arrays.fill(visited, Boolean.FALSE);

		for(int i = 0;i<numberOfVertices;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			adjacencyList.add(list);
		}
	}
	
	void addEdge(int from, int to){
		adjacencyList.get(from).add(to);
	}
	
	void printGraph() {
		adjacencyList.forEach(list -> {
				System.out.print(list);
				//list.forEach(value -> System.out.print(value + " "));
				System.out.println();
			}				
		);
	}
	
	void DFSInorder(int start){
		if(!visited[start]){
			visited[start] = true;
			System.out.print(start + "->");
			
			for(Integer value: adjacencyList.get(start)){
				DFSInorder(value);
			}
		}
	}
	
	Boolean DFSInorderPath(int start, int end, Boolean found){
		if(start == end){
			System.out.print(start + "->");
			return true;
		}
		if(!visited[start]){
			visited[start] = true;
		
			for(Integer value: adjacencyList.get(start)){
				found = DFSInorderPath(value, end , found);

				if(found){
					System.out.print(start + "->");
					return true;
				}
			}
		}
		
		return false;
	}
	
	void getPath(int from, int to) {
		Boolean isPathFound = DFSInorderPath(from, to, false);
		Boolean isReversePathFound = DFSInorderPath(to, from, false);
		
		if(!isPathFound && !isReversePathFound){
			System.out.print("Path NOT Found :( ");
		}
	}
}

public class PathVertices{
	public static void main(String args[]){
		System.out.println("Creating a program to generate path between 2 vertices in a Graph.");
		
		Graph customGraph = new Graph(11);
		
		customGraph.addEdge(0, 1);
		customGraph.addEdge(0, 3);
		customGraph.addEdge(0, 4);
		customGraph.addEdge(1, 5);
		customGraph.addEdge(5, 6);
		customGraph.addEdge(6, 7);
		customGraph.addEdge(6, 8);
		customGraph.addEdge(7, 9);
		customGraph.addEdge(9, 8);
		customGraph.addEdge(8, 10);
		customGraph.addEdge(10, 2);
		
		//customGraph.printGraph();
		
		//customGraph.DFSInorder(0);
		
		//customGraph.getPath(0, 2);
		//customGraph.getPath(7, 1);
		customGraph.getPath(7,3);
	}
}