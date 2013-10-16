import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

// Graph is being represented using Adjacency List representation 
/* author @prathyush	
 *  for the Research work on Outlier graph detection in set of Graphs 	
 */

public class GraphCreator {
	static TreeMap <String, ArrayList <Integer> > graph= new TreeMap< String, ArrayList < Integer > >();

	public static void main(String [] args ) throws IOException
	{
		GraphCreator testObject= new GraphCreator();
		System.out.println(testObject.CreateGraph("8by8bipartite.txt"));
	}

	public TreeMap<String, ArrayList<Integer>> CreateGraph(String inputfile) throws IOException
	{
		BufferedReader graphInput= new BufferedReader (new FileReader(inputfile));
		int noOfVertices= Integer.parseInt(graphInput.readLine());
		int i=0;
		while(i<noOfVertices)
		{
			int vertexEdges= Integer.parseInt(graphInput.readLine());
			int j=0;
			ArrayList<Integer> temp= new ArrayList<Integer>();
			while(j<vertexEdges)
			{
				int vertexNo= Integer.parseInt(graphInput.readLine());
				temp.add(vertexNo);
				j++;
			}
			String key=(i+1)+"";
			graph.put(key, temp);
			i++;
		}
		graphInput.close();
		return graph;
	}

}
