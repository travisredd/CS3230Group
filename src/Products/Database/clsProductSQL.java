package Products.Database;

/**
 * Builds SQL strings
 * @author eric
 */
public class clsProductSQL {
    
    /**
     * returns a query that selects all from product table
     * @return 
     */
    public String SelAll(){
        return "SELECT * FROM PRODUCT";
    }
    
    /**
     * returns a query that selects category column from category table
     * @return 
     */
    public String SelCategory(){
        return "SELECT CATEGORY FROM CATEGORY";
    }
    
    /**
     * returns a query that inserts a new product
     * @param prodId
     * @param prod
     * @param desc
     * @param cat
     * @param cost
     * @return 
     */
    public String InsProd(int prodId, String prod, String desc, String cat, double cost){
        return String.format("INSERT INTO PRODUCT (PRODUCTID, PRODUCT, DESCRIPTION, CATEGORY, COST) VALUES (%d, '%s', '%s', '%s', %.2f)",
                prodId, prod, desc, cat, cost);
    }
    
    /**
     * returns a query that deletes a product
     * @param prodId
     * @return 
     */
    public String DltProd(int prodId){
        return String.format("DELETE FROM PRODUCT WHERE PRODUCTID = %d", prodId);
    }
    
    /**
     * returns a query that updates information in a product
     * @param newName
     * @param newDesc
     * @param newCat
     * @param newCost
     * @param newId
     * @return 
     */
    public String UpdProd(String newName, String newDesc, String newCat, double newCost, int newId){
        return String.format("UPDATE PRODUCT SET PRODUCT = '%s', DESCRIPTION = '%s', CATEGORY = '%s', COST = %.2f WHERE PRODUCTID = %d",
                newName, newDesc, newCat, newCost, newId);
    }
    
    /**
     * returns a query that selects orders with a passed in product id
     * @param prodId
     * @return 
     */
    public String SelOrder(int prodId){
        return String.format("SELECT ORDERID, CUSTOMER.NAME, ORDERS.DATE FROM CUSTOMER, ORDERS WHERE CUSTOMER.CUSTOMERID = ORDERS.CUSTOMERID AND PRODUCTID = %d", prodId);
    }
}
