package labtest01practice;

/**
 * Utility class with a driver program and some 
 * sample items and inventories.
 */
public final class Driver
{
	private static final Item ITEM_CEREAL = new Item("Cereal", 1, 200);
	private static final Item ITEM_JAM = new Item("Jam", 2, 400);
	private static final Item ITEM_BUTTER = new Item("Butter", 3, 250);
	
	private static final Item[] ITEMSL = { ITEM_CEREAL, ITEM_JAM, ITEM_BUTTER };
	
	private Driver() {}
	
	/**
	 * @param pArgs Not used
	 */
	public static void main(String[] pArgs)
	{
		Corporation aCorp =  Corporation.getCorporation();
		
		Inventory aInventory = Inventory.getInventory("Store1");
		Inventory aInventory2 = Inventory.getInventory("Store2");
		
		aInventory.stock(ITEM_BUTTER, 5);
		aInventory.stock(ITEM_CEREAL, 10);
		
		aInventory2.stock(ITEM_JAM, 8);
		aInventory2.stock(ITEM_CEREAL, 7);
		
		aCorp.addInventory(aInventory);
		aCorp.addInventory(aInventory2);
		
		for( Item item : ITEMSL )
		{
			//System.out.println(item.getName());
		}
		
		for (Item item: aInventory)
		{
			System.out.println(item.getName()+" "+aInventory.pAvailable(item));
		}
		
		aInventory.dispose(ITEM_CEREAL, 5);
		
		aInventory.printInventory();
		aInventory2.printInventory();
		
		System.out.println("----");
		
		aCorp.printCorporation();
		
	}
}
