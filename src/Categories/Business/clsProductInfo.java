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
 *
 * @author reddt
 */
public class clsProductInfo {
    
    /**
     * 
     */
    private IntegerProperty iProductID;
    
    /**
     * 
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
     * 
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
     * Returns gets sCategory and sDescriptions string data
     * @return 
     */
    public String toString() 
    {
        return "ProductID =" + iProductID.get() + 
             ",  Product =" + sProducts.get() + 
              ", Description =" + sDescription.get();
    }
    
    /**
     * gets the category and returns sCategory
     * @return 
     */
    public int getsProductID() 
    {
        return iProductID.get();
    }
    
    /**
     * sets the category passed in to the clsCategories sCategory
     * @param sCategory 
     */
    public void setsProductID(int iProductID) 
    {
        this.iProductID.set(iProductID);
    }
    
    /**
     * Returns sCategoryProperty
     * @return 
     */
    public IntegerProperty iProductIDProperty() 
    {
        return iProductID;
    }
    
    /**
     * Gets the description and returns sDescription
     * @return 
     */
    public String getsProducts() 
    {
        return sProducts.get();
    }
    
    /**
     * setsDescription sDescription passed in to clsCategories sDescription
     * @param sDescription 
     */
    public void setsProducts(String sProducts) 
    {
        this.sProducts.set(sProducts);
    }
    
    /**
     * returns sDescription StringProperty
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
