package labtest01practice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An item in a grocery store: 
 * Jar of peanut butter, package of pasta,
 * whatever.
 */
public class Item
{
	private static final HashMap <Integer, Item> ITEMS =new HashMap<>();
	private final String aName;
	private final int aId;
	private final int aPrice; // In cents: 100 = one dollar
	
	
	/**
	 * Creates a new item.
	 * @param pName The name of the item. Not necessarily unique.
	 * @param pId A unique id for the item
	 * @param pPrice The price of the item in cents
	 */
	public Item(String pName, int pId, int pPrice)
	{
		aName = pName;
		aId = pId;
		aPrice = pPrice;
	}
	
	// returns Item, create it if doesn't exist
	/**
	 * @param pName name
	 * @param pId id 
	 * @param pPrice price
	 * @return item fitting Id 
	 */
	public Item getItem(String pName, int pId, int pPrice)
	{
		if (ITEMS.containsKey(pId))
		{
			return ITEMS.get(pId);
		}
		Item temp = new Item(pName, pId,pPrice);
		ITEMS.put(pId, temp);
		return temp;
	}
	
	/**
	 * @return The name of the item
	 */
	public String getName()
	{
		return aName;
	}
	
	/**
	 * @return The ID of the item.
	 */
	public int getId()
	{
		return aId;
	}
	
	/**
	 * @return The price of the item in cents
	 */
	public int getPrice()
	{
		return aPrice;
	}
}
