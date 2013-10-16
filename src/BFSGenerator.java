import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;


public class BFSGenerator {
	static TreeMap <String, ArrayList <Integer> > graph= new TreeMap< String, ArrayList < Integer > >();
	static TreeMap <String, ArrayList <Integer> > BFSTree= new TreeMap< String, ArrayList < Integer > >();
	static ArrayList< Integer> vertexQueue= new ArrayList< Integer>();
	public static void main(String [] args)
	{
		GraphGenerator object = new GraphGenerator();
		graph=object.generateGraph();
		System.out.println(graph);
		BFSGenerator object1=new BFSGenerator();
		object1.BFSTreeGenerator();
	}

	public void BFSTreeGenerator()
	{
		int noOfVertices= graph.size();
		int [] vertexLevel= new int[noOfVertices+1];
		int i=1;
		while(i<=noOfVertices)
		{
			vertexLevel[i]=1000;
			i++;
		}
		System.out.println(vertexLevel[2]);

		vertexLevel[1]=0;
		vertexQueue.add(1);
		int vertexNo=1;

		while(!vertexQueue.isEmpty())
		{
			ArrayList < Integer > temp = new ArrayList< Integer> ();
			int vertexId=vertexQueue.get(0);
			vertexQueue.remove(0);//remove the first element
			ArrayList < Integer > links = new ArrayList< Integer> ();
			links=graph.get(vertexId+"");
			Iterator< Integer > it= links.iterator();
			int k=0;
			while(it.hasNext())
			{

				int id=it.next();
				k++;
				if(vertexLevel[id]==1000)
				{
					id=vertexNo+k;
					vertexQueue.add(id);
					temp.add(id);
					vertexLevel[id]=0;
				}
				System.out.println("check this "+temp);
			}
			String key=vertexNo+"";
			System.out.println(key+ " key is ");
			BFSTree.put(key, temp);
			System.out.println(BFSTree+" this too ");
			System.out.println(vertexQueue); 	
			vertexNo++;
			System.out.println(vertexNo);

		}

		System.out.println(" Here is the tree ");
		System.out.println("-------------------------");
		System.out.println(BFSTree);

	}

}
