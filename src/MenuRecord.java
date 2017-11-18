import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuRecord {

	private String name;
	private double price;
	private int id;
	public MenuRecord(int id , String name , double price ){
		this.name = name;
		this.price = price;
		this.id = id;
	}
	public String toString(){
		String menu = String.format("|%3d | %15s | %8.2f |",id,name,price);
		return menu;
	}
}
