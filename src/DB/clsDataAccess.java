/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author reddt
 */
public class clsDataAccess {
    /**
     * Holds the connection string to the database. - NEED TO CHANGE THIS TO ORACLE DB
     */
    private static final String sConnection = "jdbc:derby://localhost:1527/Employees";
    
    /**
     * Holds the database connection.
     */
    private static Connection dbConnection;
    
    /**
     * Open the database connection 
     * @throws SQLException
     * @throws Exception 
     */
    public static void dbConnect() throws SQLException, Exception
    {
        try
        {
            //Init the connection
            dbConnection = DriverManager.getConnection(sConnection);
        }
        catch (SQLException ex) 
        {
            throw new SQLException(Thread.currentThread().getStackTrace()[1].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        catch (Exception ex) 
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "." + 
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    /**
     * Close the database connection 
     * @throws SQLException
     * @throws Exception 
     */
    public static void dbDisconnect() throws SQLException, Exception
    {
        try 
        {
            //Make sure there is a valid open connection
            if (dbConnection != null && !dbConnection.isClosed())
            {
                //Close the connection 
                dbConnection.close();
            }
        }
        catch(SQLException ex) 
        {
            throw new SQLException(Thread.currentThread().getStackTrace()[1].getClassName() + "." + 
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        catch(Exception ex)
        {
            throw new Exception(Thread.currentThread().getStackTrace()[1].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
    
    /**
     * This method takes the SQL query that is passed in and returns the results in a ResultSet.
     * @param sSQL
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public static ResultSet ExecuteSQL_Query(String sSQL) throws SQLException, Exception
    {
        //The result of the SQL query
        ResultSet resultSet = null;
        
        try
        {
            //Connect to the DB
            dbConnect();
            
            if (dbConnection != null && !dbConnection.isClosed())
            {
                //Call createStatement method with parameters TYPE_SCROLL_INSENSITE (Means can scroll through data any direction)
                //and CONCUR_READ_ONLY (Means data can only be read and not updated)
                Statement stmtSQL = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                //Execute the SQL statement
                resultSet = stmtSQL.executeQuery(sSQL);
            }
            
        } 
        catch (SQLException ex)
        {
            throw new SQLException (Thread.currentThread().getStackTrace()[1].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        catch (Exception ex) 
        {
            throw new Exception (Thread.currentThread().getStackTrace()[1].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
        return resultSet;
    }
    
    /**
     * This method takes a non SQL statement (INSERT/UPDATE/DELETE) and executes it
     * @param sSQL
     * @throws SQLException
     * @throws Exception 
     */
    public static void ExecuteNonQuerySQL(String sSQL) throws SQLException, Exception
    {
        try
        {
            //DriverManager is a class used to manage JDBC drivers 
            //The method getConnection establishs a connection to the given database URL
            try (Connection con = DriverManager.getConnection(sConnection))
            {
                //Call createStatement to get a Statement object
                Statement stmtNonQuery = con.createStatement();
                stmtNonQuery.executeUpdate(sSQL);
            }
        }
        catch(SQLException ex)
        {
            throw new SQLException(Thread.currentThread().getStackTrace()[1].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[1].getMethodName() + " -> " + ex.getMessage());
        }
    }
}
