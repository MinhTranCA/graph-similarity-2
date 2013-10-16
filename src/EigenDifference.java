import java.util.ArrayList;
import java.util.Scanner;


public class EigenDifference {
	static ArrayList<Double> eigenVector1=new ArrayList<Double>();
	static ArrayList<Double> eigenVector2=new ArrayList<Double>();
	public static void main(String [] args)
	{
		EigenDifference object=new EigenDifference();
		object.createEigenVectors();
		object.difference();
	}

	public void createEigenVectors()
	{
		Scanner scanner = new Scanner( System.in );
		System.out.println("Enter number of eigen values in the vectors");
		int vectorLength=scanner.nextInt();

		System.out.println("Enter eigen vector "+1+" : ");
		int j=0;
		while(j<vectorLength)
		{
			eigenVector1.add(scanner.nextDouble());
			j++;
		}

		System.out.println("Enter eigen vector "+2+" : ");
		int k=0;
		while(k<vectorLength)
		{
			eigenVector2.add(scanner.nextDouble());
			k++;
		}

	}
	
	public void difference()
	{
		int i=0;
		Double squareDiffSum=0.0;
		while(i<eigenVector1.size())
		{
			Double valueDiff= eigenVector1.get(i)-eigenVector2.get(i);
			System.out.println(valueDiff);
			Double squareValueDiff=valueDiff*valueDiff;
			squareDiffSum=squareDiffSum+squareValueDiff;
			i++;
		}
		Double finalDifference= Math.sqrt(squareDiffSum);
		System.out.println("The final Difference is "+ finalDifference);
	}
	

}
