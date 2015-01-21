package database;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import recycle.ItemType;

public class DatabaseConnector
{
    private static final String DATABASEURL = "jdbc:sqlserver://SFO-RSONI-D;databaseName=EcoReSystem;integratedSecurity=true";
    private static final String CLASSPATH = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static DatabaseConnector singletonDBConnector = null;
    private Connection conn = null;

    private DatabaseConnector() {
    }

    public static DatabaseConnector getInstance() {
        if (singletonDBConnector == null) {
            singletonDBConnector = new DatabaseConnector();
        }
        return singletonDBConnector;
    }

    public Connection getConnection()
        throws SQLException, ClassNotFoundException
    {
        Class.forName(CLASSPATH);
        this.conn = DriverManager.getConnection(DATABASEURL);
        return conn;
    }

    public HashMap<String, Double> getStatisticsFromNowToPastDatesByMachineId(int machineId, int daysBefore)
        throws SQLException, ClassNotFoundException
    {
        HashMap<String, Double> data = new HashMap<String, Double>();
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement("{call dbo.getStatisticsFromNowToPastDatesByMachineId(?,?)}");
            pstmt.setInt(1, machineId);
            pstmt.setInt(2, daysBefore);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                data.put("totalWeightOfItemsEmptied", new Double(rs.getDouble("totalWeightOfItemsEmptied")));
                data.put("totalCouponAmountRedeemed", new Double(rs.getDouble("totalCouponAmountRedeemed")));
                data.put("totalCashAmountRedeemed", new Double(rs.getDouble("totalCashAmountRedeemed")));
                data.put("totalCashCouponAmountRedeemed", new Double(rs.getDouble("totalCashCouponAmountRedeemed")));
                data.put("numberOfTimesItemsEmptied", new Double(rs.getDouble("numberOfTimesItemsEmptied")));
            }
            rs.close();
            pstmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
        return data;
    }

    public ArrayList<ItemType> getItemTypesByMachineId(int machineId)
        throws SQLException, ClassNotFoundException
    {
        ArrayList<ItemType> types = new ArrayList<ItemType>();
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement("{call dbo.getItemTypesByMachineId(?)}");
            pstmt.setInt(1, machineId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ItemType type = new ItemType(rs.getString("itemTypeName"), rs.getDouble("itemTypePricePerLb"));
                types.add(type);
            }
            rs.close();
            pstmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
        return types;
    }

    public void insertItemTypeByMachineId(int machineId,
                                          String itemTypeName,
                                          double itemTypePricePerLb)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.insertItemTypeByMachineId(?,?,?)}");
            cstmt.setInt(1, machineId);
            cstmt.setString(2, itemTypeName);
            cstmt.setDouble(3, itemTypePricePerLb);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }

    public void insertRecycleMachine(int machineId,
                                     String location)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.insertRecycleMachine(?,?)}");
            cstmt.setInt(1, machineId);
            cstmt.setString(2, location);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }

    public void updateRecycleMachineItemType(int machineId,
                                             String itemTypeName,
                                             double itemTypePricePerLb)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.updateRecycleMachineItemType(?,?,?)}");
            cstmt.setInt(1, machineId);
            cstmt.setString(2, itemTypeName);
            cstmt.setDouble(3, itemTypePricePerLb);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }

    public void deleteRecycleMachine(int machineId)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.deleteRecycleMachine(?)}");
            cstmt.setInt(1, machineId);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }

    public void deleteRecycleMachineItemType(int machineId, String itemTypeName)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.deleteRecycleMachineItemType(?,?)}");
            cstmt.setInt(1, machineId);
            cstmt.setString(2, itemTypeName);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }

    public void insertRecycleMachineStatistics(int id,
                                               int numberOfItems,
                                               double totalWeight,
                                               double totalCouponAmountRedeemed,
                                               double totalCashAmountRedeemed)
        throws SQLException, ClassNotFoundException
    {
        CallableStatement cstmt = null;
        try {
            cstmt = getConnection().prepareCall("{call dbo.insertRecycleMachineStatistics(?,?,?,?,?)}");
            cstmt.setInt(1, id);
            cstmt.setInt(2, numberOfItems);
            cstmt.setDouble(3, totalWeight);
            cstmt.setDouble(4, totalCouponAmountRedeemed);
            cstmt.setDouble(5, totalCashAmountRedeemed);
            cstmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (cstmt != null) {
                cstmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        }
    }
}
