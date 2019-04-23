import java.util.Scanner;
public class test{
	public static void main(String[] args)
	{
		// start choi nua ko?
		char regame,who;
		boolean yn = true;
		 int scoreX=0;
		 int scoreO=0;
		Scanner n=new Scanner(System.in);
		boolean point=true;
		System.out.println("\tBan muon choi 'X' hay 'O' ?(press x for 'X'; o for 'O')");
		System.out.println();
		System.out.print("\t\tNguoi choi 1 chon: ");
		who=n.next().charAt(0);
		while(who!='x' && who!='X' && who!='o' && who!='O')
		{
			System.out.println();
			System.out.print("\tNguoi choi 1 chon lai (press x for 'X'; o for 'O') : ");
			who=n.next().charAt(0);
		}
		if(who=='x' || who=='X')
		{
			point=true;
		}
		else if(who=='o' || who=='O')
		{
			point= false;
		}
		do{
		//
		String[][] a ={{" "," "," "},{" "," "," "},{" "," "," "}};
		board(a,scoreX,scoreO);
		int i=0;
		while(i<9)
		{
			
			MANinput(a,point);
			board(a,scoreX,scoreO);
			i++;
			if(iswin(a)||i==9)
				break;
			MANinput(a,!point);
			board(a,scoreX,scoreO);
			i++;
			if(iswin(a))
				break;
		}
		if(iswin(a))
		{
			if(point)
			{
				if(i%2!=0)
				{
					System.out.println("nguoi X thang");
					scoreX++;
				}
				else
				{
					System.out.println("nguoi O thang");
					scoreO++;
				}
			}
			else 
			{
				if(i%2!=0)
				{
					System.out.println("\tNGUOI CHOI \"O\" THANG!\t\tScore of O +1");
					System.out.println();
					scoreO++;
				}
				else
				{
					System.out.println("\tNGUOI CHOI \"X\" THANG!\t\tScore of X +1");
					System.out.println();
					scoreX++;
				}
			}
		}
		else
		{
			System.out.println("\tHOA NHAU ROI !!");
			System.out.println();
		}
		System.out.println("choi nua khong? press(Y/N)");
		regame= n.next().charAt(0);
		//
		if(regame=='Y' || regame== 'y')
			yn=true;
		else if(regame=='N' || regame== 'n')
			yn=false;
		}while(yn);
		
		// end choi nua ko
		
	}
	//
	private static void board(String[][] a,int scoreX,int scoreO)
	{
		System.out.println();
		System.out.println();
		System.out.println("\tWELCOME TO GAME CARO(Tic-Tac-Toe) OF HAO LE");
		System.out.println();
		System.out.print("       (x)\n");
		System.out.println();
		System.out.println(" \t2\t"+a[2][0]+" | "+a[2][1]+" | "+a[2][2]);
		System.out.println("\t       -----------         scoreX: "+scoreX);
		System.out.println(" \t1\t"+a[1][0]+" | "+a[1][1]+" | "+a[1][2]);
		System.out.println("\t       -----------         scoreO: "+scoreO);
		System.out.println(" \t0\t"+a[0][0]+" | "+a[0][1]+" | "+a[0][2]);
		System.out.println();
		System.out.println();
		System.out.println("\t\t0 | 1 | 2  (y)");
		System.out.println();
	}
	
	private static boolean iswin(String[][] a)
	{
		//ngang
		
		if(a[0][0]==a[0][1]&&a[0][1]==a[0][2]&&a[0][0]!=" ")
			return true;
		else if(a[1][0]==a[1][1]&&a[1][1]==a[1][2]&&a[1][0]!=" ")
			return true;
		else if(a[2][0]==a[2][1]&&a[2][1]==a[2][2]&&a[2][0]!=" ")
			return true;
		//doc
		else if(a[2][0]==a[1][0]&&a[1][0]==a[0][0]&&a[2][0]!=" ")
			return true;
		else if(a[2][1]==a[1][1]&&a[1][1]==a[0][1]&&a[2][1]!=" ")
			return true;
		else if(a[2][2]==a[1][2]&&a[1][2]==a[0][2]&&a[2][2]!=" ")
			return true;
		// cheo
		else if(a[2][0]==a[1][1]&&a[1][1]==a[0][2]&&a[2][0]!=" ")
			return true;
		else if(a[2][2]==a[1][1]&&a[1][1]==a[0][0]&&a[2][2]!=" ")
			return true;
		// else
		else
			return false;
	}
	//

	private static void MANinput(String[][] a, boolean point)
	{
		Scanner n=new Scanner(System.in);
		
		if(point)
		{
			System.out.println("Moi nguoi choi X nhap,(toa do x,y): ");
			int x,y;
			x=n.nextInt();
			y=n.nextInt();
			while(x>2||x<0||y>2||y<0||x*(-1)>0 || y*(-1)>0 || a[x][y]!=" ")
			{
				System.out.println("nhap lai");
				x=n.nextInt();
				y=n.nextInt();
			}	
			a[x][y]="X";
		}
		else
		{
			System.out.println("Moi nguoi choi O nhap,(toa do x,y): ");
			int x,y;
			x=n.nextInt();
			y=n.nextInt();
			while(x>2||x<0||y>2||y<0||x*(-1)>0 || y*(-1)>0 || a[x][y]!=" ")
			{
				System.out.println("nhap lai");
				x=n.nextInt();
				y=n.nextInt();
			}	
			a[x][y]="O";
		}
	}
	//

}