import java.util.*;

public class BattleShipgame
{
    public static void main(String[] args) 
    {
    	Scanner inp=new Scanner(System.in);
        char[][] g=new char[10][10];        
        System.out.println("*** WELCOME TO BATTLESHIPS GAME ***");
        System.out.print("Enter Player Name  ");
        String s=inp.nextLine();
        
        System.out.println("Deploy your 5 ships");
        printmap(g);
        deploy(1,g);
        System.out.println(s+"!  Your Ships were Deployed");
        System.out.println("Computer is Deploying ships\nShip 1 DEPLOYED\nShip 2 DEPLOYED\nShip 3 DEPLOYED\nShip 4 DEPLOYED\nShip 5 DEPLOYED");
        System.out.println("All Ships were Deployed\nLet the BATTLE begin");
        
        deploy(2,g);
        printmap(g);
        int ps=5,cs=5;
        int cx=0,cy=0;
        for(int i=1;i<100;i++)
        {
            if(i%2==1)
            {
                System.out.print(s+"'s Turn");
                System.out.print("\nEnter X Co-ordinate : ");
                
                cx=inp.nextInt();
                inp.nextLine();
                System.out.print("Enter Y Co-ordinate : ");
                cy=inp.nextInt();
                
                if(cx>9||cx<0||cy>9||cy<0||g[cx][cy]=='-'||g[cx][cy]=='x'||g[cx][cy]=='!')
                {
                    i--;
                    System.out.println("\nEnter Valid Co-Cordinates");
                    continue;
                }
            }
            else
            {
                System.out.print("\nComputer's Turn");
                Random x = new Random();
                cx=(x.nextInt(10));
                Random y = new Random();
                cy=(y.nextInt(10));
                if(cx>9||cx<0||cy>9||cy<0||g[cx][cy]=='-'||g[cx][cy]=='x'||g[cx][cy]=='!')
                {
                    i--;
                     continue;
                }
            }
            if(g[cx][cy]==i%2+49)
            {
                g[cx][cy]=((i%2==1)?'!':'x');
                if(i%2==1)
                {
                    System.out.println("\nBoom! You sunk the ship!");
                    cs--;
                }
                else
                {
                    System.out.println("\nThe Computer sunk one of your ships!");
                    ps--;
                }
            }
            else if(i%2==1&&g[cx][cy]=='1'||i%2==0&&g[cx][cy]=='2')
            {
                g[cx][cy]=((i%2==1)?'x':'!');
                if(i%2==1)
                {
                    System.out.println("\nOh no, you sunk your own ship :(");
                    ps--;
                }
                else
                {
                    System.out.println("\nThe Computer sunk one of its own ships");
                    cs--;
                }
            }
            else
            {
                if(i%2==1)
                    {
                	System.out.println("\nSorry, you missed");
                	g[cx][cy]='-';
                    }
                else
                    System.out.println("\nComputer missed");
                
            }
            if(cs==0||ps==0)
                break;
            if(i%2==0)
            	printmap(g);
        }
        printmap(g);        
        if(cs==0)
            System.out.println("\nHell Yeah!!!  "+s+" Won\nWinner Winner Chicken Dinner");
        else
            System.out.println("\nOOPS!! You Lose"); 
        inp.close();
    }   
    public static void deploy(int n,char[][] g)
    {
        Scanner in=new Scanner(System.in);
        int gx,gy;
        for(int i=0;i<5;i++)
        {   
            if(n==1)
            {
                System.out.print("\nEnter X co-ordinate for Ship "+(i+1)+" : ");
                gx=in.nextInt();
                //Random x = new Random();
                //gx=(x.nextInt(10));
                
                System.out.print("Enter Y co-ordinate for Ship "+(i+1)+" : ");
                gy=in.nextInt();
                //Random y = new Random();
                //gy=(y.nextInt(10));
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
                System.out.println("\nEnter Correct Location");
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
                    if(n==1)
                    System.out.println("\nEnter Correct Location");
                    continue;
                }
            }
        }
        //in.close();
    }
    public static void printmap(char[][] g)
    {
        System.out.print("\n    0 1 2 3 4 5 6 7 8 9 \n");
        System.out.print("   _____________________\n");
        for(int i=0;i<g.length;i++)
        {
            System.out.print(i+" |");
            for(int j=0;j<g[i].length;j++)
            {
                if(g[i][j]!=0 && g[i][j]!='2')
                {
                    System.out.print(" "+g[i][j]);
                }
//                if(g[i][j]!=0 ) //Visible Enemy Ships	
//                {
//                    System.out.print(" "+g[i][j]);
//                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.print(" | "+i+"\n");
        }
        System.out.print("   ---------------------\n");
        System.out.print("    0 1 2 3 4 5 6 7 8 9 \n");
    }
}
