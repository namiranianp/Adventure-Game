package Model;

public class Item {
	String name;
	int buyValue;
	int sellValue;
	
	public Item(String itemName, int buy, int sell) {
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
