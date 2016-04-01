package Model;
public class Item {
	String name;
	int buyValue;
	int sellValue;
<<<<<<< HEAD
	boolean equiped;


	public Item(String itemName, int buy, int sell, boolean isEquiped) {
=======
	
	public Item(String itemName, int buy, int sell) {
>>>>>>> Pedram_Changes
		name = itemName;
		buyValue = buy;
		sellValue = sell;
	}
	
	public int getBuyValue(){
		return buyValue;
	}
	public int getSellValue(){
		return sellValue;
	}
}
