package recycle;

import java.util.*;

public class RecycleMachine {
	private int machineId;
	String location;
	private double totalWeight;
	private ArrayList<Item> items;    
	private ArrayList<ItemType> supportedItemTypes;
	private double capacity = 0;
	private Date lastTimeMachineEmpty;     
	private double totalMoneyRemaining = 0.0;
	private double totalCouponAmountRedeemed = 0;
	private double totalBeginningMoney = 0.0;
	private OperationalStatus operationalStatus;
	
	public RecycleMachine (int machineId, String location, ArrayList<ItemType> supportedItemTypes,double capacity, double totalBeginningMoney) {
		this.machineId = machineId;
		this.location = location;
		this.totalWeight = 0.00;
		this.items = new ArrayList<Item>();
		this.supportedItemTypes = supportedItemTypes;
		this.capacity = capacity;
		this.lastTimeMachineEmpty = new Date();
		this.totalMoneyRemaining = totalBeginningMoney;
		this.totalBeginningMoney = totalBeginningMoney;
		this.operationalStatus = OperationalStatus.OFF;
	}
	
	public RecycleMachine (int machineId, String location, double capacity, double totalBeginningMoney) {
		this.machineId = machineId;
		this.location = location;
		this.totalWeight = 0.00;
		this.items = new ArrayList<Item>();
		this.supportedItemTypes = new ArrayList<ItemType>(); // no supported type at start
		this.capacity = capacity;
		this.lastTimeMachineEmpty = new Date();
		this.totalMoneyRemaining = totalBeginningMoney;
		this.totalBeginningMoney = totalBeginningMoney;
	    this.operationalStatus = OperationalStatus.OFF;
	}
	
	public int getNumberOfItems() {
	    return this.items.size();
	}
	public OperationalStatus getOperational() {
		return this.operationalStatus;
	}
	
	public void setOperational(OperationalStatus operationalStatus) {
        this.operationalStatus = operationalStatus;
	}
	
	public void addSupportedItemType(ItemType type) {
		this.supportedItemTypes.add(type);
	}
	
	public ItemType getSupportedItemTypeByName(String typeName) 
	{
	    Iterator<ItemType> iterator = this.supportedItemTypes.iterator(); 
	    while(iterator.hasNext())
	    {
	        ItemType currentItemType = (ItemType)iterator.next();
	        if(currentItemType.getName().equals(typeName)) {
	            return currentItemType;
	        }
	    }
	    return null;
	}
	
	public void removeSupportedItemType(ItemType type) 
	{
	    Iterator<ItemType> iterator = this.supportedItemTypes.iterator(); 
        while(iterator.hasNext())
        {
            ItemType currentItemType = (ItemType)iterator.next();
            if(currentItemType.getName().equals(type.getName())) {
                this.supportedItemTypes.remove(currentItemType);            }
        }
	}
	
	public double getTotalMoneyRemaining() 
	{
		return this.totalMoneyRemaining;
	}
	
	public boolean addItem(Item item) 
	{
		if(!isSupportedItemType(item)) 
		{
			return false;
		}
		else
		{
    		this.items.add(item);
    		this.totalWeight = this.totalWeight + item.getWeight();
    		return true;
		}
	}
	
	public boolean isSupportedItemType(Item item)
	{
		for (int i = 0; i < this.supportedItemTypes.size(); i++ ) 
		{ 
			if(supportedItemTypes.get(i).getName().equals(item.getType().getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean canAddItems(ArrayList<Item> itemsToAdd) {
	    // rcm total capacity should not be reached by adding items
		float totalItemsToAddWeight = 0;
		for (int j = 0; j < itemsToAdd.size(); j++) 
		{
		    // check if itemsToAdd belong to type that is part of supportedItemTypes
		    if(isSupportedItemType(itemsToAdd.get(j))) {
		        totalItemsToAddWeight += itemsToAdd.get(j).getWeight();
		    } else {
		        return false;// item type is not supported
		    }
		}
		if((this.totalWeight + totalItemsToAddWeight)  > this.capacity) 
		{
			//System.out.println ("The capacity to hold the items has been reached. ");
			return false;
		}
		
		
		return true;
	}
	
	public double addItems(ArrayList<Item> itemsToAdd)  
	{
		double totalDueAmount = 0.0;
		for (int j = 0; j < itemsToAdd.size(); j++) 
		{
			this.items.add(itemsToAdd.get(j)); 
			totalDueAmount = totalDueAmount + (itemsToAdd.get(j).getWeight() * itemsToAdd.get(j).getType().getPricePerLb() * itemsToAdd.get(j).getQuantity());
		}
		return totalDueAmount;
	}
	
	public double getTotalWeight()
	{
		return this.totalWeight;
	}
	
	public void emptyItems() 
	{
		this.items = null;
		//this.capacity = 0;
		this.totalWeight = 0.00;
		this.lastTimeMachineEmpty = new Date();
		this.totalBeginningMoney = this.totalMoneyRemaining;
		this.totalCouponAmountRedeemed = 0;
	}
	
	public ArrayList<ItemType> getAllSupportedItemTypes()
	{
		return supportedItemTypes;
	}
	
	public boolean getCash(double totalDueAmount) {
		if(totalDueAmount > this.totalMoneyRemaining) {
			return false; //print coupon
		}
		this.totalMoneyRemaining -= totalDueAmount;
		return true; //give cash.
	}
	
	public void redeemCouponAsCash(double totalDueAmount) {
		this.totalCouponAmountRedeemed += totalDueAmount;
	}
	
	public double getTotalCouponAmountRedeemed() {
		return this.totalCouponAmountRedeemed;
	}
	
	public double getTotalCacheOrCouponsIssued() {
		return this.totalCouponAmountRedeemed + (this.totalBeginningMoney - this.totalMoneyRemaining);
	}
	
	public double getTotalCashAmountRedeemed() {
	    return (this.totalBeginningMoney - this.totalMoneyRemaining);
	}
	public double capacity() {
		return this.capacity;
	}
	
	public Date getLastTimeMachineEmptied() {
		return this.lastTimeMachineEmpty;
	}
	
	/*public int numberOfTimeMachineEmptied(Date startTime, Date endTime) {
	/// Incomplete ???
	}*/
	
	public double getAvailableCapacity() {
		return this.capacity - this.totalWeight;
	}

}
