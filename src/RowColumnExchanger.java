import java.util.Scanner;


public class RowColumnExchanger {
	static int[][] matrix=new int[10][10];
	static int noOfRows;
	static int noOfColumns;
	public static void main(String [] args)
	{
		RowColumnExchanger matrixObject=new RowColumnExchanger();
		matrixObject.createMatrix();
		matrixObject.displayMatrix();
		matrixObject.getMatrixIsomorph(2,7);
		System.out.println("Final output");
		matrixObject.displayMatrix();
	}

	public void createMatrix()
	{
		Scanner scanner = new Scanner( System.in );
		System.out.println("enter number of rows & columns of the matrix : ");
		noOfRows= scanner.nextInt();
		noOfColumns= scanner.nextInt();
		int i=0;
		while(i<noOfRows)
		{
			System.out.println("enter row "+(i+1)+" : ");
			int j=0;
			while(j<noOfColumns)
			{
				matrix[i][j]=scanner.nextInt();
				j++;
			}
			i++;
		}
	}

	public void displayMatrix()
	{
		int i=0;
		int j=0;
		while(i<noOfRows)
		{
			System.out.print(" | ");
			j=0;
			while(j<noOfColumns)
			{
				System.out.print(matrix[i][j]+" ");
				j++;
			}
			System.out.print(" | \n");
			i++;
		}
	}


	public void getMatrixIsomorph(int node1, int node2)
	{

		int i=0;
		while(i<noOfRows)
		{
			if(i==node1)
			{
				int j=0;
				while(j<noOfColumns)
				{
					int temp=matrix[node1][j]; 				//exchange rows node1 and node2
					matrix[node1][j]=matrix[node2][j];
					matrix[node2][j]=temp;
					j++;
				}
			}
			else if(i!= node2)
			{
				int temp=matrix[i][node1];
				matrix[i][node1]=matrix[i][node2];
				matrix[i][node2]=temp;					//change values for entries in columns node1 and node2 for other rows
			}
			i++;
		}
	}


}
