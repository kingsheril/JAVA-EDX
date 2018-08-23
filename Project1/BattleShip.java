import java.util.*;

public class Battleshipgame 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		char[][] g=new char[10][10];
		System.out.println("*** WELCOME TO BATTLESHIPS GAME ***");
		
		printmap(g);
		int n=1;
		deploy(n,g);

		printmap(g);
		
		in.close();
	}
	
	public static void deploy(int n,char[][] g)
	{
		Scanner in=new Scanner(System.in);
		int gx,gy;
		for(int i=0;i<5;i++)
		{	
			if(n==1)
			{
				System.out.print("Enter X co-ordinate for Ship "+(i+1)+" : ");
				gx=in.nextInt();
				System.out.print("Enter Y co-ordinate for Ship "+(i+1)+" : ");
				gy=in.nextInt();
			}
			else
			{
				Random x = new Random();
				gx=(x.nextInt(10));
				Random y = new Random();
				gy=(y.nextInt(10));
			}
			if(gx>9||gx<0||gy>9||gy<0)
			{
				i--;
				System.out.println("Enter Correct Location");
				continue;
			}
			else
			{
				if(g[gx][gy]==0)
				{
					if(n==1)
						g[gx][gy]='1';
					else
						g[gx][gy]='2';
				}
				else
				{
					i--;
					System.out.println("Enter Correct Location");
					continue;
				}
			}
		}
		in.close();
	}
	
	public static void printmap(char[][] g)
	{
		System.out.print("    0 1 2 3 4 5 6 7 8 9 \n");
		//System.out.print("   _____________________\n");
		for(int i=0;i<g.length;i++)
		{
			System.out.print(i+" |");
			for(int j=0;j<g[i].length;j++)
			{
				if(g[i][j]!=0)
				{
					System.out.print(" "+g[i][j]);
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.print(" | "+i+"\n");
		}
		System.out.print("    0 1 2 3 4 5 6 7 8 9 \n");
	}
}
