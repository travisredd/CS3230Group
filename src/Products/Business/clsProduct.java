/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products.Business;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author eric
 */
public class clsProduct {

    private IntegerProperty iProductId;
    
    private StringProperty sProduct;
    
    private StringProperty sDescription;
    
    private StringProperty sCategory;
    
    private DoubleProperty dCost;
    
    private IntegerProperty iOrderId;
    
    private StringProperty sCustomer;
    
    private StringProperty sDate;
    
    /**
     * Constructor
     */
    public clsProduct()
    {
        iProductId = new SimpleIntegerProperty(0);
        sProduct = new SimpleStringProperty("");
        sDescription = new SimpleStringProperty("");
        sCategory = new SimpleStringProperty("");
        dCost = new SimpleDoubleProperty(0);
    }
    
    /**
     * Constructor for top table
     * @param prodId
     * @param prod
     * @param desc
     * @param cat
     * @param cost 
     */
    public clsProduct(int prodId, String prod, String desc, String cat, double cost) {
        iProductId = new SimpleIntegerProperty(prodId);
        sProduct = new SimpleStringProperty(prod);
        sDescription = new SimpleStringProperty(desc);
        sCategory = new SimpleStringProperty(cat);
        dCost = new SimpleDoubleProperty(cost);
    }
    
    /**
     * Constructor for bottom table
     * @param ordId
     * @param name
     * @param date 
     */
    public clsProduct(int ordId, String name, Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        iOrderId = new SimpleIntegerProperty(ordId);
        sCustomer = new SimpleStringProperty(name);
        sDate = new SimpleStringProperty(dateFormat.format(date));
    }
    
    public int GetiProductId()
    {
        return iProductId.get();
    }
    
    public String GetsProduct()
    {
        return sProduct.get();
    }
    
    public String GetsDescription()
    {
        return sDescription.get();
    }
    
    public String GetsCategory()
    {
        return sCategory.get();
    }
    
    public double GetdCost()
    {
        return dCost.get();
    }
    
    public int GetiOrderId()
    {
        return iOrderId.get();
    }
    
    public String GetsCustomer()
    {
        return sCustomer.get();
    }
    
    public String GetsDate()
    {
        return sDate.get();
    }
    
    public void SetiProductId(int prodId)
    {
        iProductId.set(prodId);
    }
    
    public void SetsProduct(String prod)
    {
        sProduct.set(prod);
    }
    
    public void SetsDescription(String desc)
    {
        sDescription.set(desc);
    }
    
    public void SetsCategory(String cat)
    {
        sCategory.set(cat);
    }
    
    public void SetdCost(double cost)
    {
        dCost.set(cost);
    }
    
    public IntegerProperty GetProductIdProperty()
    {
        return iProductId;
    }
    
    public StringProperty GetProductProperty()
    {
        return sProduct;
    }
    
    public StringProperty GetDescriptionProperty()
    {
        return sDescription;
    }
    
    public StringProperty GetCategoryProperty()
    {
        return sCategory;
    }
    
    public DoubleProperty GetCostProperty()
    {
        return dCost;
    }
    
    public IntegerProperty GetOrderIdProperty()
    {
        return iOrderId;
    }
    
    public StringProperty GetCustomerProperty()
    {
        return sCustomer;
    }
    
    public StringProperty GetDateProperty()
    {
        return sDate;
    }
}
