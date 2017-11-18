import java.io.IOException;
import java.util.Scanner;
/**
 * This is a ske-restaurant project
 * It can take an order, show the bill and save the order log
 * It read menu from txt file "src/data/menu.txt"
 * It save order to txt file "src/data/order.txt"
 * @author Ou
 */
public class Restaurant {
static Scanner sc = new Scanner(System.in);
	
	public static void optionPrint() throws IOException{
		System.out.print("1.Order\n2.Check-Bill\n3.Exit\nEnter choice : ");
		int option = sc.nextInt();
		switch (option){
			case 1: menuPrint(); break;
					
			case 2: checkBill(); break;
			
			case 3: exitProgram(); break;
					 
		}
		
	}
	public static void menuPrint(){
		System.out.printf(" %13s Menu\n","");
		System.out.println("+----+-----------------+----------+"); 
		RestaurantManager.menuPrint(); 
		System.out.println("+----+-----------------+----------+"); 
		while(true){
			System.out.print("Please order a menu(by id) : ");
			int id = sc.nextInt();
			System.out.print("How much/many : ");
			int qty = sc.nextInt();
			RestaurantManager.recordOrder(id,qty);
			while(true){
				System.out.print("Order more?(y/n) : ");
				String choice = sc.next();
				if(choice .equalsIgnoreCase("n")){
					return;
				}
				else if(choice .equalsIgnoreCase("y")){
					break;
				}
			}
		}
	}
	public static void checkBill(){
		System.out.printf(" %13s Bill\n","");
		System.out.println("+-----------------+-----+----------+"); 
		RestaurantManager.billPrint();
		System.out.println("+-----------------+-----+----------+"); 
	}
	public static void exitProgram() throws IOException{
		while(true){
			System.out.print("Do you want to save a log?(y/n) : ");
			String choice = sc.next();
			if(choice .equalsIgnoreCase("y")){
				RestaurantManager.logSave();
				break;
			}
			else if(choice .equalsIgnoreCase("n")){ break; }
		}
		System.out.print("Thank you.");
		System.exit(1);
	}
	public static void main(String[] args) throws IOException{
		RestaurantManager.readFile();
		System.out.println("------------------Ske-Restaurant------------------");
		while(true){
			optionPrint();
		}
	}
}
