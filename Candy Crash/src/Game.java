import java.io.FileReader;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;


public class Game 
{
    private static int[][] a = new int [8][8];
    private static Random rand = new Random();
    private static Scanner cin = new Scanner(System.in);
    private static Scanner fin ;
    private static int moves,p1_moves,p2_moves,p1_score,p2_score,score,count,x,y;
    private static String dir;
    private static Formatter fp;
    private static int getout;
	public static void main(String[] args) 
	{
		int choice,flag = 0;
		while(true)
		{
			System.out.printf("1.Start a new game\n2.Load an existing game\n3.Exit\nPlease enter a choice:\n");
			try {
				choice = cin.nextInt();
			} catch (Exception e) {
				System.out.println("Wrong choice . please choose among 1 or 2 or 3");
				continue ;
			}
			switch(choice)
			{
			case 1: newGame();
			break;
			case 2:Load_game();
			break;
			
			case 3:flag = 1;
				break;
			default:
				break;
			}
			if(flag == 1)
			{
				break ;
			}
			choice = 3;
		}

	}
	public static void newGame()
	{
		int x,y,x1,y1,up,down,temp;
		String dir;
		for(int i=0; i<8;i++)
		{
			for(int j=0; j<8; j++)
			{
				a[i][j] =1 + rand.nextInt(5);
			}
		
		}
		System.out.println("In how many moves would you like to play ?");
		System.out.println();
		while(true)
		{
		try 
		{
			moves = cin.nextInt();
			break;
			
		} catch (Exception e) 
		{
			System.out.println("Wrong input is given for moves" + "\r\n" + "Retry. . . ");
			
		}
		}
		show_Grid(a);
		p1_moves = p2_moves = 0;
		while(p1_moves != moves && p2_moves != moves)
		{
			Input(1);
			if(getout == 1)
			{
				getout = 0;
				return ;
			}
			p1_moves ++;
			show_Grid(a);
			System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
			System.out.printf("Player-1 Rem. moves = %d\r\n Player-2 Rem. moves = %d\r\n",moves - p1_moves,moves - p2_moves);
			Input(2);
			if(getout == 1)
			{
				getout = 0;
				return ;
			}
			p2_moves ++;
			show_Grid(a);
			System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
			System.out.printf("Player-1 Rem. moves = %d\r\n Player-2 Rem. moves = %d\r\n",moves - p1_moves,moves - p2_moves);	
			}
		if(p1_score == p2_score)
		{
			System.out.println("Match Draw"); 
		}
		else if(p1_score >= p2_score)
		{
			System.out.println("Player 1 wins");
		}
		else 
		{
			System.out.println("Player 2 wins");
		}
			
		
		}
	
	
	
	public static int calculateScore(int [][]a)
	{
		int x1,y1,up,down,temp;
		if(dir.equals("H"))
		{
			temp = a[x][y];
			x1=x;
			score += temp;
			y1=y+1;
			
			while(y1 < 8 && a[x1][y1] == temp)
			{
		    
		    score += temp;
			gravity_1(a,x1,y1);
			y1 ++;
			
			}
			y1 = y-1;
			while(y1>=0 && a[x1][y1] == temp )
			{
			score += temp;
			gravity_1(a,x1,y1);
			y1 -= 1;
			
			}
		}
		else if(dir.equals("V"))
		{
			count = 1;
			temp = a[x][y];
			x1 = x-1;
			while((x1 >= 0 && x1 <8) && a[x1][y]==temp )
			{
				++count;
				x1--;
			}
			up = x1+1;
			x1 = x+1;
			
			while((x1 >= 0 && x1 <8) && a[x1][y] == temp )
			{
				++count;
				x1++;
			}
			down = x1 - 1;
			
			score = temp * count;
			
			///System.out.println("up =  " + up + "down = " + down);
			up --;
			while(up > -1)
			{
				a[down][y] = a[up] [y];
				down --;
				up --;
			}
			while(down > -1)
			{
				a[down] [y] = 1 + rand.nextInt(5);
				down --;
			}
		}
		///System.out.printf("\r\n __________Score: %d \r\n", score);
		return score;
		

	}
	public static void gravity_1(int[][]a,int x,int y)
	{
		while(x-1 >= 0)
		{
			a[x][y] = a[x-1] [y];
			--x;
		}
		a[0][y] = 1 + rand.nextInt(5);
	}
	public static void Input(int i)
	{
		while(true)
		{
		System.out.printf("Player %d move:",i);
		System.out.println("Please input grid position(x,y) and direction(H or V) Or Press -1 to save the game and exit.:");
		System.out.println("For example:1 2 H");
		try {
			x = cin.nextInt();
			if(x == -1)
			{
				System.out.println("what s the hell happened ?");
				break ;
			}
			y = cin.nextInt();
			dir = cin.next();
			
		} catch (Exception e) {
			
			System.out.println("Wrong input is given for player 1" + "\r\n" + "Retry. . . ");
		}
		if(x<0 || x>8 || y<0 || y>8 || (!(dir.equals("H") || dir.equals("V"))))
		{
			System.out.println(dir.equals("H"));
			System.out.println("Invalid input is given for player 1" + "\r\n" + "Retry. . . ");
			continue;
		}
		else {
			--x;
			--y;
			break;
		}
	}
		if(x == -1)
		{
			if(i == 1)
			{
				p1_moves ++;
			}
			else if(i == 2)
			{
				p2_moves ++;
			}
			Save_game();
			getout = 1;
			return ;
		}
		else if(i==1)
		{
			p1_score += calculateScore(a);
			score = 0;
		}
		else if(i==2)
		{
			p2_score += calculateScore(a);
			score = 0;
		}
	}


public static void show_Grid(int [][]a)
{
	for(int i=0; i<8;i++)
	{
		System.out.printf("%s\n","----------------------------------------------------------------------------------");
		for(int j=0; j<8; j++)
		{
			System.out.printf("|  %d  |      ", a[i][j]);
		}
		System.out.printf("%s","\n");
	
	}
	System.out.printf("%s\n","----------------------------------------------------------------------------------");
}
public static void Save_game()
{
	while(true){
	try{
		fp = new Formatter("Save.txt");
		break ;
	}catch(Exception ex)
	{
		ex.getMessage();
		System.out.println("Error to creat save file. Retry . . .");
		continue ;
	}
	}
	fp.format("%d %d %d %d %d\n", p1_moves,p2_moves,p1_score,p2_score,moves);
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
	{
		fp.format("%d ", a[i][j]);
	}
		fp.format("%s","\r\n");
	}
	
	fp.close();
}
public static void Load_game() 
{
		try
		{
			fin = new Scanner(new FileReader("Save.txt"));
		}catch(Exception ex)
		{
			System.out.println("Sorry, failed to load the requied 'Save.txt' file");
			ex.getMessage();
			return ;
		}
		
		p1_moves = fin.nextInt();
		p2_moves = fin.nextInt();
		p1_score = fin.nextInt();
		p2_score = fin.nextInt();
		moves = fin.nextInt();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
		{
			a[i][j] = fin.nextInt();
		}
		}
		fin.close();
		
		show_Grid(a);
		System.out.printf("Player-1 Score =%d\r\n Player-2 Score =%d\r\n", p1_score,p2_score);
		System.out.printf("Player-1 Rem. moves = %d\r\n Player-2 Rem. moves = %d\r\n",moves - p1_moves,moves - p2_moves);
		if(p1_moves <= p2_moves)
		{
			while(p1_moves != moves && p2_moves != moves)
			{
				Input(1);
				if(getout == 1)
				{
					getout = 0;
					break ;
				}
				p1_moves ++;
				show_Grid(a);
				System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
				System.out.printf("Player-1 Rem. moves = %d\r\n Player-2 Rem. moves = %d\r\n",moves - p1_moves,moves - p2_moves);
				Input(2);
				if(getout == 1)
				{
					getout = 0;
					break ;
				}
				p2_moves ++;
				show_Grid(a);
				System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
				System.out.printf("Player-1 Rem. moves = %d\r\n Player-2 Rem. moves = %d\r\n",moves - p1_moves,moves - p2_moves);	
				}
		}
		else 
		{
			while(p1_moves != moves && p2_moves != moves)
			{
				Input(2);
				if(getout == 1)
				{
					getout = 0;
					return ;
				}
				p2_moves ++;
				show_Grid(a);
				System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
				Input(1);
				if(getout == 1)
				{
					getout = 0;
					return ;
				}
				p1_moves ++;
				show_Grid(a);
				System.out.printf("Player-1 Score = %d\r\n Player-2 Score = %d\r\n", p1_score,p2_score);
					
				}
		}
		if(p1_score == p2_score)
		{
			System.out.println("Match Draw"); 
		}
		else if(p1_score >= p2_score)
		{
			System.out.println("Player 1 wins");
		}
		else 
		{
			System.out.println("Player 2 wins");
		}
}
}