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
public class clsProduct
{

    /**
     * IntegerProperty for Product Id
     */
    private IntegerProperty iProductId;

    /**
     * String Property for Product
     */
    private StringProperty sProduct;

    /**
     * String Property for Description
     */
    private StringProperty sDescription;

    /**
     * String Property for Category
     */
    private StringProperty sCategory;

    /**
     * DoubleProperty for Cost
     */
    private DoubleProperty dCost;

    /**
     * IntegerProperty for Order Id
     */
    private IntegerProperty iOrderId;

    /**
     * String Property for Customer
     */
    private StringProperty sCustomer;

    /**
     * String Property for Date
     */
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
    public clsProduct(int prodId, String prod, String desc, String cat, double cost)
    {
        iProductId = new SimpleIntegerProperty(prodId);
        sProduct = new SimpleStringProperty(prod);
        sDescription = new SimpleStringProperty(desc);
        sCategory = new SimpleStringProperty(cat);
        dCost = new SimpleDoubleProperty(cost);
    }

    /**
     * Constructor for bottom table
     *
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

    /**
     * getter for iProductId
     * @return 
     */
    public int GetiProductId()
    {
        return iProductId.get();
    }

    /**
     * setter for iProductId
     * @param prodId 
     */
    public void SetiProductId(int prodId)
    {
        iProductId.set(prodId);
    }

    /**
     * getter for iProductId
     * @return 
     */
    public IntegerProperty GetProductIdProperty()
    {
        return iProductId;
    }

    /**
     * getter for sProduct
     * @return 
     */
    public String GetsProduct()
    {
        return sProduct.get();
    }

    /**
     * getter for sDescription
     * @return 
     */
    public String GetsDescription()
    {
        return sDescription.get();
    }

    /**
     * getter fir sCategory
     * @return 
     */
    public String GetsCategory()
    {
        return sCategory.get();
    }

    /**
     * getter for dCost
     * @return 
     */
    public double GetdCost()
    {
        return dCost.get();
    }

    /**
     * getter for iOrderId
     * @return 
     */
    public int GetiOrderId()
    {
        return iOrderId.get();
    }

    /**
     * getter for sCutomer
     * @return 
     */
    public String GetsCustomer()
    {
        return sCustomer.get();
    }

    /**
     * getter for sDate
     * @return 
     */
    public String GetsDate()
    {
        return sDate.get();
    }

    /**
     * setter for prod
     * @param prod 
     */
    public void SetsProduct(String prod)
    {
        sProduct.set(prod);
    }

    /**
     * setter for sDescription
     * @param desc 
     */
    public void SetsDescription(String desc)
    {
        sDescription.set(desc);
    }

    /**
     * setter for sCategory
     * @param cat 
     */
    public void SetsCategory(String cat)
    {
        sCategory.set(cat);
    }

    /**
     * setter for dCost
     * @param cost 
     */
    public void SetdCost(double cost)
    {
        dCost.set(cost);
    }

    /**
     * getter for sProduct
     * @return 
     */
    public StringProperty GetProductProperty()
    {
        return sProduct;
    }

    /**
     * getter for sDescription
     * @return 
     */
    public StringProperty GetDescriptionProperty()
    {
        return sDescription;
    }

    /**
     * getter for sCategory
     * @return 
     */
    public StringProperty GetCategoryProperty()
    {
        return sCategory;
    }

    /**
     * getter for dCost
     * @return 
     */
    public DoubleProperty GetCostProperty()
    {
        return dCost;
    }

    /**
     * getter for iOrderId
     * @return 
     */
    public IntegerProperty GetOrderIdProperty()
    {
        return iOrderId;
    }

    /**
     * getter for sCustomer
     * @return 
     */
    public StringProperty GetCustomerProperty()
    {
        return sCustomer;
    }

    /**
     * getter for sDate
     * @return 
     */
    public StringProperty GetDateProperty()
    {
        return sDate;
    }
}
