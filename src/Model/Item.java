package Model;

public class Item {
	String name;
	int buyValue;
	int sellValue;

	boolean equiped;

	public Item(String itemName, int buy, int sell, boolean isEquiped) {
		name = itemName;
		buyValue = buy;
		sellValue = sell;
	}

	public int getBuyValue() {
		return buyValue;
	}

	public int getSellValue() {
		return sellValue;
	}
}
