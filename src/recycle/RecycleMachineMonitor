package recycle;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import database.DatabaseConnector;

public class RecycleMachineMonitor
{

    // this will store all RCM that RecylcingMachineMonitor manages
    HashMap<Integer, RecycleMachine> recycleMachinesMap;

    public RecycleMachineMonitor()
    {
        this.recycleMachinesMap = new HashMap<Integer, RecycleMachine>();
    }

    public void AddRecycleMachine(int id, String location, int capacity, double totalBeginningMoney)
    {
        RecycleMachine recycleMachine = new RecycleMachine(id, location, capacity, totalBeginningMoney);
        recycleMachinesMap.put(new Integer(id), recycleMachine);

        try {
            DatabaseConnector.getInstance().insertRecycleMachine(id, location);
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
    }

    public RecycleMachine RemoveRecylceMachine(int id)
    {
        try {
            DatabaseConnector.getInstance().deleteRecycleMachine(id);
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
        return recycleMachinesMap.remove(new Integer(id));
    }

    public OperationalStatus isRecycleMachineOperational(int id)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        return recyleMachine.getOperational();
    }

    public void addRecycleItemType(int id, ItemType type)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        recyleMachine.addSupportedItemType(type);

        try {
            DatabaseConnector.getInstance().insertItemTypeByMachineId(id, type.getName(), type.getPricePerLb());
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
    }

    public void removeRecycleItemType(int id, ItemType type)
    {
        Integer machineId = new Integer(id);
        RecycleMachine recyleMachine = recycleMachinesMap.get(machineId);
        recyleMachine.removeSupportedItemType(type);

        try {
            DatabaseConnector.getInstance().deleteRecycleMachineItemType(id, type.getName());
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
    }

    public double checkTotalMoneyRemaining(int id)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        return recyleMachine.getTotalMoneyRemaining();
    }

    public void emptyRecycleMachine(int id)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        try {
            DatabaseConnector.getInstance()
                    .insertRecycleMachineStatistics(id,
                                                    recyleMachine.getNumberOfItems(),
                                                    recyleMachine.getTotalWeight(),
                                                    recyleMachine.getTotalCouponAmountRedeemed(),
                                                    recyleMachine.getTotalCashAmountRedeemed());
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
        recyleMachine.emptyItems();

    }

    public void changeItemTypePrice(int id, String typeName, double price)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        ItemType type = recyleMachine.getSupportedItemTypeByName(typeName);
        type.setPricePerLb(price);

        try {
            DatabaseConnector.getInstance().updateRecycleMachineItemType(id, typeName, price);
        }
        catch (SQLException e) {

        }
        catch (ClassNotFoundException ex) {

        }
    }

    public double getCurrentCapacity(int id)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        return recyleMachine.capacity();
    }

    public double getAvailableCapacity(int id)
    {
        RecycleMachine recyleMachine = recycleMachinesMap.get(new Integer(id));
        return recyleMachine.getAvailableCapacity();
    }
}
