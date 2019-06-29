package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		Graph g = null;
	    try (BufferedReader br = new BufferedReader(new FileReader(args[0]));)
	    {
	        g = new Graph(br);
        } catch(FileNotFoundException e){
	        System.out.println(e);
        } catch(IOException e) {
	        System.out.println(e);
        }
	    g.show();
	    DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
	    for (int i : dfs.getEdgeTo())
	    	System.out.println(i);

	    System.out.println(dfs.visitedVertices());

	}

}
