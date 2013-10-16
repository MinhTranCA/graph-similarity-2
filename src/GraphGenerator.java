import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

// Graph is being represented using Adjacency List representation 
/* author @prathyush	
*  for the Research work on Outlier graph detection in set of Graphs 	
*/
public class GraphGenerator {
	
	static TreeMap <String, ArrayList <Integer> > graph= new TreeMap< String, ArrayList < Integer > >();
	public static void main(String [] args)
	{
		GraphGenerator object=new GraphGenerator();
		object.generateGraph();
		System.out.println(graph);
	}
	
	public TreeMap<String, ArrayList<Integer>> generateGraph()
	{
		int noOfVertices=0;
		Scanner scanner = new Scanner( System.in );
		System.out.println("enter number of vertices in the graph : ");
		noOfVertices=scanner.nextInt();
		int i=1;
		while(i<=noOfVertices)
		{
			ArrayList< Integer > links= new ArrayList< Integer>();
			System.out.println("enter the no of incident edges of vertex "+i+": ");
			int incidentEdges=scanner.nextInt();
			int j=0;
			System.out.println("enter the vertices adjacent to vertex "+i+" in numeric order : ");
			while(j<incidentEdges)
			{
				links.add(scanner.nextInt());
				j++;
			}
			System.out.println(links);
			String id=i+"";
			graph.put(id,links);
			i++;
		}
		return graph;
	}
	
}
