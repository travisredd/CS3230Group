/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products.Database;

/**
 * Builds SQL strings
 * @author eric
 */
public class clsProductSQL {
    
    public String SelAll(){
        return "SELECT * FROM PRODUCT";
    }
    
    public String SelCategory(){
        return "SELECT CATEGORY FROM CATEGORY";
    }
    
    public String InsProd(int prodId, String prod, String desc, String cat, double cost){
        return String.format("INSERT INTO PRODUCT (PRODUCTID, PRODUCT, DESCRIPTION, CATEGORY, COST) VALUES (%d, '%s', '%s', '%s', %.2f)",
                prodId, prod, desc, cat, cost);
    }
    
    public String DltProd(int prodId){
        return String.format("DELETE FROM PRODUCT WHERE PRODUCTID = %d", prodId);
    }
    
    public String UpdProd(String newName, String newDesc, String newCat, double newCost, int newId){
        return String.format("UPDATE PRODUCT SET PRODUCT = '%s', DESCRIPTION = '%s', CATEGORY = '%s', COST = %.2f WHERE PRODUCTID = %d",
                newName, newDesc, newCat, newCost, newId);
    }
    
    public String SelOrder(int prodId){
        return String.format("SELECT ORDERID, CUSTOMER.NAME, ORDERS.DATE FROM CUSTOMER, ORDERS WHERE CUSTOMER.CUSTOMERID = ORDERS.CUSTOMERID AND PRODUCTID = %d", prodId);
    }
}
