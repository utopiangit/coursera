package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
//		IGraph g = null;
		Digraph g = null;
	    try (BufferedReader br = new BufferedReader(new FileReader(args[0]));)
	    {
//	        g = new Graph(br);
	    	g = new Digraph(br);
        } catch(FileNotFoundException e){
	        System.out.println(e);
        } catch(IOException e) {
	        System.out.println(e);
        }

//	    DepthFirstPaths path = new DepthFirstPaths(g, 0);
//	    System.out.println(path.visitedVertices());

//	    BreadthFirstPaths path = new BreadthFirstPaths(g, 0);
//	    System.out.println(path.pathTo(3));

	    DepthFirstOrder order = new DepthFirstOrder(g);
	    System.out.println(order.reversePost());


	}

}
