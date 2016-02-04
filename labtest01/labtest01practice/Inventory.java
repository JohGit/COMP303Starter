package labtest01practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the inventory of a 
 * physical grocery store.
 * Flyweight implementation
 */
public class Inventory implements Iterable<Item>
{
	private final String aName; // Unique
	private final Map<Item, Integer> aInventory = new HashMap<>(); //change to Map from HashMap
	private static final HashMap<String, Inventory> INVENTORIES = new HashMap<>();
	
	/**
	 * Creates a new inventory with no items in it,
	 * and identified uniquely with pName.
	 * @param pName A unique identifier for this inventory.
	 */
	private Inventory(String pName)
	{
		aName = pName;
	}
	
	private Inventory(Inventory pInventory)
	{
		aName = pInventory.aName+"Copy";
		for (Item item : pInventory)
		{
			aInventory.put(item, pInventory.aInventory.get(item) );
		}
		
		
	}
	
	public Inventory getInventory(String pName)
	{
		if (INVENTORIES.containsKey(pName))
		{
			return INVENTORIES.get(pName);
		}
		else
		{
			Inventory temp = new Inventory(pName);
			INVENTORIES.put(pName, temp);
			return temp;
		}
		
	}
	
	/**
	 * @return The unique name of this inventory.
	 */
	public String getName()
	{
		return aName;
	}
	
	/**
	 * Adds pQuantity number of items to the inventory.
	 * @param pItem The type of item to add.
	 * @param pQuantity The amount to add.
	 */
	public void stock(Item pItem, int pQuantity)
	{
		int amount = 0;
		if( aInventory.containsKey(pItem))
		{
			amount = aInventory.get(pItem);
		}
		amount += pQuantity;
		aInventory.put(pItem, amount);
	}
	
	/**
	 * Removes pQuantity of items from the inventory,
	 * for example by selling them or tossing them in
	 * the garbage.
	 * @param pItem The type of item to dispose of
	 * @param pQuantity The amount to dispose.
	 * @pre aInventory.containsKey(pItem) && pQuantity >= aInventory.get(pItem)
	 */
	public void dispose(Item pItem, int pQuantity)
	{
		int amount = aInventory.get(pItem);
		amount -= pQuantity;
		aInventory.put(pItem, amount);
	}
	
	/**
	 * @param pItem The item to check for availability.
	 * @return How many of the items are available in the inventory.
	 */
	public int pAvailable(Item pItem)
	{
		if( aInventory.containsKey(pItem))
		{
			return aInventory.get(pItem);
		}
		else
		{
			return 0;
		}
	}

	@Override
	public Iterator<Item> iterator()
	{
		List<Item> temp = new ArrayList<Item>();
		for (Map.Entry<Item, Integer> entry : aInventory.entrySet()) {
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			temp.add(entry.getKey());
		}
		
		
		return temp.iterator();
	}
}
