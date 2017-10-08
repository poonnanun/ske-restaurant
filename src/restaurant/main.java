package restaurant;

import java.util.Scanner;

public class main {
	public static Scanner sc = new Scanner(System.in);
	public static void menuPrint()
	{
		System.out.println("-------------- Welcome to SKE restaurant --------------");
		System.out.printf("1.) Pizza\t %4d baht.\n",250);
		System.out.printf("2.) Chicken\t %4d baht.\n",120);
		System.out.printf("3.) Coke\t %4d baht.\n",50);
		System.out.println("4.) Total");
		System.out.println("5.) Exit");
		System.out.println();
	}
	public static void readMenu()
	{
		int[] menu = new int[3];
		menu[0] = 0;
		menu[1] = 0;
		menu[2] = 0;
		int quan = 0;
			for(int i = 1 ; i>0 ; i++)
			{
				quan = 0;
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				switch(choice)
				{
				case 1:	System.out.print("Enter your quantities : ");
						quan = sc.nextInt();
						menu[0] += quan;
						break;
				
				case 2:	System.out.print("Enter your quantities : ");
						quan = sc.nextInt();
						menu[1] += quan;
						break;
				
				case 3:	System.out.print("Enter your quantities : ");
						quan = sc.nextInt();
						menu[2] += quan;
						break;
				
				case 4: billPrint(menu); break;
				
				case 5: System.exit(1); break;
				
				default : System.out.println("Wrong choice,Please try again"); break;
				}
				
			}
	}
	public static void billPrint(int[] order)
	{
		System.out.println("+---- Menu ----+-- QTY --+-- Price --+");
		itemPrint(order);
		System.out.println("+------------------------+-----------+");
		System.out.println();
	}
	public static void itemPrint(int[] order) 
	{
		if(order[0] > 0)
		{
			System.out.printf("| %-13s| %7d | %9d |\n","Pizza",order[0],order[0]*250);
		}
		if(order[1] > 0)
		{
			System.out.printf("| %-13s| %7d | %9d |\n","Chicken",order[1],order[0]*120);
		}
		if(order[2] > 0)
		{
			System.out.printf("| %-13s| %7d | %9d |\n","Coke",order[2],order[0]*50);
		}
	}
	public static void main(String[] args)
	{
		menuPrint();
		readMenu();
		
	}

}
