
public class OrderRecord {
	private String name;
	private int qty; 
	private double total;
	
	public OrderRecord(String name , int qty , double price){
		this.name=name;
		this.qty=qty;
		this.total=qty*price;
	}
	public String toString(){
		String bill = String.format("| %15s | %3d | %8.2f |",name,qty,total);
		return bill;
	}
}
