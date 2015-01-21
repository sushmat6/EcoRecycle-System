package recycle;

public class ItemType
{
    private String name;
    private double pricePerLb; // hard code price per lb         

    //constructor
	public ItemType(String name, double pricePerLb)
	{
		this.name = name;
		this.pricePerLb = pricePerLb;
	}
   
	//getter methods
	public String getName()
	{
		return this.name;
	}

	public double getPricePerLb()
	{
		return this.pricePerLb;
	}

	public double getPricePerKg()
	{
		return this.pricePerLb * 0.453;
	}
	
	//setter methods
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public void setPricePerLb(double pricePerLb)
	{
		this.pricePerLb = pricePerLb;
	}
	
	
}

