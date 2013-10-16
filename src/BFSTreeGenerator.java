import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

// class for a tree

public class BFSTreeGenerator {
	static TreeMap <String, ArrayList <Integer> > graph= new TreeMap< String, ArrayList < Integer > >();
	static HashMap < Integer, Integer> mapping = new HashMap < Integer, Integer>();
	// Designed Data Structure
	ArrayList<  HashMap <Integer, Integer>> bfsTree = new ArrayList<HashMap <Integer, Integer>>();
	ArrayList<  HashMap <Integer, Integer>> finalbfsTree = new ArrayList< HashMap <Integer, Integer>> ();
	public static void main(String [] args) throws IOException
	{
		GraphCreator creator= new GraphCreator();
		graph=creator.CreateGraph(args[0]);
		System.out.println("Input Graph: \n"+graph);
		BFSTreeGenerator bfsgenerator=new BFSTreeGenerator();
		bfsgenerator.bfsTreeCreator(Integer.parseInt(args[1]));
		bfsgenerator.renameVertices();
	}

	public void renameVertices()
	{
		int noOfLevels= bfsTree.size();
		int i=0;
		while(i<noOfLevels)
		{
			HashMap<Integer, Integer> temp= bfsTree.get(i);
			Iterator< Integer > it = temp.keySet().iterator();
			HashMap<Integer, Integer> temp2= new HashMap < Integer, Integer>();
			while(it.hasNext())
			{
				int t1= it.next();
				int t2= temp.get(t1);
				t1= mapping.get(t1);
				if(!(t2==-1))
					t2= mapping.get(t2);
				temp2.put(t1, t2);
			}
			finalbfsTree.add(temp2);
			i++;
		}
		System.out.println("Renamed BFS Tree : \n"+finalbfsTree);
	}
	
	public void bfsTreeCreator(int ver)
	{
		int noOfVertices = graph.size();
		int [] visited = new int [noOfVertices+1];
		visited[ver]=0; //mark vertex 1 as visited
		int i=1;
		//marks others as unvisited
		while(i<= noOfVertices)
		{
			if(i!=ver)
				visited[i]=1000;
			i++;
		}
		//create vertex Queue
		ArrayList < Integer> vertexQueue = new ArrayList< Integer>();
		vertexQueue.add(ver);
		// loop until there are no unvisited vertices

		int vertexNo=1;
		mapping.put(ver, vertexNo);
		HashMap <Integer, Integer> temp= new HashMap < Integer, Integer>();
		temp.put(ver, -1);
		bfsTree.add(temp);
		while(!vertexQueue.isEmpty())
		{
			int vertex= vertexQueue.get(0);
			vertexQueue.remove(0);
			ArrayList <Integer > links = graph.get(vertex+"");
			Iterator<Integer> it= links.iterator();
			HashMap <Integer, Integer> temp2= new HashMap <Integer, Integer>();
			while(it.hasNext())
			{
				int child= it.next();
				if(visited[child]==1000)
				{
					vertexNo++;
					visited[child]=0;
					vertexQueue.add(child);
					mapping.put(child, vertexNo);	
					temp2.put(child, vertex);
				}
			}
			if(!temp2.isEmpty())
				bfsTree.add(temp2);
		}
		System.out.println("Output BFS Tree: \n"+bfsTree);
	}


}


