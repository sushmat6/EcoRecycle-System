package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import recycle.Item;
import recycle.ItemType;
import recycle.RecycleMachine;
import recycle.RecycleMachineMonitor;

import database.DatabaseConnector;

public class TestRecylceSystem {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // use case 1 - get all statistics
/*        try {
            HashMap<String, Double> data = DatabaseConnector.getInstance().getStatisticsFromNowToPastDatesByMachineId(1, 3);
            System.out.println(data.get("totalWeightOfItemsEmptied"));
            System.out.println(data.get("totalCouponAmountRedeemed"));
            System.out.println(data.get("totalCashAmountRedeemed"));
            System.out.println(data.get("totalCashCouponAmountRedeemed"));
            System.out.println(data.get("numberOfTimesItemsEmptied"));
        } catch(SQLException e) {
            
        } catch(ClassNotFoundException ex) {
            
        }
        
        //use case 2
        try {
            DatabaseConnector.getInstance().insertRecycleMachineStatistics(3,
                                                                     3, 10, 10, 10);
            System.out.println("inserted");
                                                         
        } catch(SQLException e) {
            
        } catch(ClassNotFoundException ex) {
            
        }
        */
        
        // use case 3
        //RecycleMachine obj = new RecycleMachine(1, "Fremont", 6, 200);
        
        /*ItemType glassType = new ItemType("glass", 2);
        Item item1 = new Item(glassType, 3, 3);
        Item item2 = new Item(glassType, 2, 2);
        
        ArrayList<Item> itemsToAdd = new ArrayList<Item>();
        itemsToAdd.add(item1);
        itemsToAdd.add(item2);
        
        if(obj.canAddItems(itemsToAdd)) {
            double totalDueAmount = obj.addItems(itemsToAdd); 
            System.out.println("total due amount:" + totalDueAmount);
        } else {
            System.out.println("can't add items");
        }
        
        // use case 4
        obj.removeSupportedItemType(glassType);
        Item item3 = new Item(glassType, 2, 2);
        itemsToAdd.clear();
        itemsToAdd.add(item3);
        if(obj.canAddItems(itemsToAdd)) {
            double totalDueAmount = obj.addItems(itemsToAdd); 
            System.out.println("total due amount:" + totalDueAmount);
        } else {
            System.out.println("can't add items for item3");
        }*/

        RecycleMachineMonitor monitor = new RecycleMachineMonitor();
        monitor.RemoveRecylceMachine(1);
        monitor.AddRecycleMachine(1, "fremont", 30, 400);
        
        //monitor.RemoveRecylceMachine(1);
        ItemType glassType = new ItemType("glass", 2);
        monitor.addRecycleItemType(1, glassType);
        monitor.RemoveRecylceMachine(1);
    }
}
