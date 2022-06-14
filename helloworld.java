import java.util.Arrays;
import java.util.Scanner;
 
class NQueens
{
    static boolean isSafe(char mat[][],int r,int c)
    {
        for(int i=0; i<r; i++)
        {
            if (mat[i][c]=='Q') 
            {
                return false;
            }
        }
 
        for(int i=r,j=c; i>=0 && j>=0; i--,j--)
        {
            if (mat[i][j]=='Q') 
            {
                return false;
            }
        }
 
        for(int i=r,j=c; i>=0 && j<mat.length; i--,j++)
        {
            if (mat[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }
 
    static void printSolution(char mat[][])
    {
    	for(int i=0;i<mat.length;i++)
    	{
    		for(int j=0;j<mat[i].length;j++)
    		{
    			System.out.print(mat[i][j]+" ");
    		}System.out.println();
    	}
        System.out.println();
    }
 
    static void nqueen(char mat[][],int r)
    {
        if (r==mat.length)
        {
            printSolution(mat);
            return;
        }https://github.com/joshna54/java-programs.git
        for (int i=0; i<mat.length; i++)
        {
            if (isSafe(mat,r,i))
            {
                mat[r][i]='Q';
                nqueen(mat,r+1);
                mat[r][i]='–';
            }
        }
    }
 
    public static void main(String[] args)
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Queens:");
        n=sc.nextInt();
        char mat[][] = new char[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(mat[i],'–');
        }
        nqueen(mat,0);
    }
}
