/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.Business;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *clsProductInfo class to load the product info object
 * @author reddt
 */
public class clsProductInfo {
    
    /**
     * iProductId to hold the productId from dataset
     */
    private IntegerProperty iProductID;
    
    /**
     * sProduct to hold the product string from dataset
     */
    private StringProperty sProducts;
    
    /**
     * sDescription - holds the description
     */
    private StringProperty sDescription;
    
    /**
     * Constructor
     */
    public clsProductInfo() 
    {
        iProductID = new SimpleIntegerProperty(0);
        sDescription = new SimpleStringProperty("");
        sProducts = new SimpleStringProperty("");
    }

    /**
     * Overloaded Constructor - passing in productId, product, and description
     * @param ProductID
     * @param Product
     * @param Description 
     */
    public clsProductInfo(int ProductID, String Product, String Description)
    {
        iProductID = new SimpleIntegerProperty(ProductID);
        sProducts = new SimpleStringProperty(Product);
        sDescription = new SimpleStringProperty(Description);
    }

    /**
     * Returns string data
     * @return 
     */
    public String toString() 
    {
        return "ProductID =" + iProductID.get() + 
             ",  Product =" + sProducts.get() + 
              ", Description =" + sDescription.get();
    }
    
    /**
     * Returns productID
     * @return 
     */
    public int getsProductID() 
    {
        return iProductID.get();
    }
    
    /**
     * sets the ProductID
     * @param sCategory 
     */
    public void setsProductID(int iProductID) 
    {
        this.iProductID.set(iProductID);
    }
    
    /**
     * Returns iProductID
     * @return 
     */
    public IntegerProperty iProductIDProperty() 
    {
        return iProductID;
    }
    
    /**
     * Returns the product
     * @return 
     */
    public String getsProducts() 
    {
        return sProducts.get();
    }
    
    /**
     * sets product info
     * @param sDescription 
     */
    public void setsProducts(String sProducts) 
    {
        this.sProducts.set(sProducts);
    }
    
    /**
     * returns product property
     * @return 
     */
    public StringProperty sProductsProperty() 
    {
        return sProducts;
    }
    
    /**
     * Gets the description and returns sDescription
     * @return 
     */
    public String getsDescription() 
    {
        return sDescription.get();
    }
    
    /**
     * setsDescription sDescription passed in to clsCategories sDescription
     * @param sDescription 
     */
    public void setsDescription(String sDescription) 
    {
        this.sDescription.set(sDescription);
    }
    
    /**
     * returns sDescription StringProperty
     * @return 
     */
    public StringProperty sDescriptionProperty() 
    {
        return sDescription;
    }
}
