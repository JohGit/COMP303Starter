package labtest01practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents a company that owns and operates
 * one or more grocery stores, each with its own inventory.
 */
public final class Corporation implements Iterable<String>
{
	/**
	 * 
	 */
	private static final Corporation COMPANY = new Corporation();
	private Map<String, Inventory> aInventories = new HashMap<String, Inventory>();
	
	
	
	private Corporation()
	{
		/**
		 * Corporation constructor, potentially add anything
		 */
	}
	
	/**
	 * @return Corporation
	 */
	public static Corporation getCorporation()
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
	
	public void printCorporation()
	{
		for (String inventname : this)
		{
			System.out.println(inventname);
			Inventory.getInventory(inventname).printInventory();
		}
	}

	@Override
	public Iterator<String> iterator()
	{
		List<String> temp = new ArrayList<String>();
		for (Map.Entry<String, Inventory> entry : aInventories.entrySet()) 
		{
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			temp.add(entry.getKey());
		}
		
		
		return temp.iterator();
	}
}
