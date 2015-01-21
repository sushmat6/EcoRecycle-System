package recycle;

import java.util.Date;

public interface IStatisticsForRCM { 
	public double getTotalCacheOrCouponsIssued();
	public int numberOfTimeMachineEmptied(Date startTime, Date endTime); // connect to db ?
	public double getTotalWeight();	
}
