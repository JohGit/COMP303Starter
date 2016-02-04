package labtest01practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a company that owns and operates
 * one or more grocery stores, each with its own inventory.
 */
public class Corporation
{
	private Map<String, Inventory> aInventories = new HashMap<String, Inventory>();
	
	public final Corporation COMPANY = new Corporation();
	
	private Corporation()
	{
		/**
		 * Corporation constructor, potentially add anything
		 */
	}
	
	public Corporation getCorporation()
	{
		return COMPANY;
	}
	/**
	 * @param pInventory An inventory to add to the corporation.
	 */
	public void addInventory(Inventory pInventory)
	{
		aInventories.put(pInventory.getName(), pInventory);
	}
}
