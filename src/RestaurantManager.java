import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RestaurantManager {
	
	private static String input = "src/data/menu.txt";
	private static String output = "src/data/order.txt";
	private static List<MenuRecord> menu = new ArrayList<>();
	private static List<OrderRecord> order = new ArrayList<>();
	private static List<String> name = new ArrayList<>();
	private static List<Double> price = new ArrayList<>();
	private static List<Integer> check = new ArrayList<>();
	private static List<Integer> quantities = new ArrayList<>();
		public static void readFile(){
			try {
				Scanner reader = new Scanner(new File(input));
				int a = 1;
				while (reader.hasNextLine()) {
		            String[] temp = reader.nextLine().replaceAll(";", "  ").split("  ");
		            if (!temp[0].isEmpty()) {
		                if (!temp[0].equals("#")) {
		                	MenuRecord item = new MenuRecord(a,temp[0],Double.parseDouble(temp[1]));
		                	a++;
		                	menu.add(item);
		                	name.add(temp[0]);
		                	price.add(Double.parseDouble(temp[1]));
		                }
		            }
		        }
				
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Can't find file.");
				System.exit(1);
			}
		}
		public static void menuPrint(){
			for(int a=0 ; a<menu.size() ; a++){
				System.out.println(menu.get(a));
			}
		}
		public static String[] getMenuItems(){
			String[] item = new String[name.size()];
			for(int i = 0 ; i<item.length ; i++){
				item[i] = name.get(i);
			}
			return item;
		}
		public static double[] getPrices(){
			double[] prices = new double[price.size()];
			for(int i = 0 ; i<prices.length ; i++){
				prices[i] = price.get(i);
			}
			return prices;
		}
		public static void recordOrder(int id , int qty){
			String[] item = getMenuItems();
			double[] prices = getPrices();
			int b = 0;
			for(int a = 0 ; a<check.size(); a++){
				if(check.get(a) == id){
					int temp = quantities.get(a);
					quantities.set(a,temp+qty);
					OrderRecord bill = new OrderRecord(item[id-1],temp+qty,prices[id-1]);
					order.set(a,bill);
					b=1;
				}
			}
			if(b != 1){
				check.add(id);
				quantities.add(qty);
				OrderRecord bill = new OrderRecord(item[id-1],qty,prices[id-1]);
				order.add(bill);
			}
		}
		public static void billPrint(){
			for(int a=0 ; a<order.size() ; a++){
				System.out.println(order.get(a));
			}
		}
		public static void logSave() throws IOException{
			System.lineSeparator();
			DateFormat dateFormat = new SimpleDateFormat(" yyyy/MM/dd HH:mm:ss ");
			Date date = new Date();
			FileWriter writer = new FileWriter(output); 
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("--------------------------");
			bw.write(dateFormat.format(date));
			bw.write("--------------------------");
			bw.newLine();
			for(int a = 0 ; a<order.size(); a++) {
				bw.write(order.get(a).toString());
				bw.newLine();
			}
			bw.write("------------------------------------------------------------------------------");
			bw.newLine();
			bw.close();
		}

	

}
