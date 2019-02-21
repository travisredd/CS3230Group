/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categories.Business;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *clsCategories a class to load the category object
 * @author reddt
 */
public class clsCategories {
    
    /**
     * sCategory - holds the category name
     */
    private StringProperty sCategory;
    
    /**
     * sDescription - holds the description
     */
    private StringProperty sDescription;
    
    /**
     * Constructor
     */
    public clsCategories() 
    {
        sCategory = new SimpleStringProperty("");
        sDescription = new SimpleStringProperty("");
    }
    
    /**
     * Overloaded Constructor passes in category and description
     * @param Category
     * @param Description 
     */
    public clsCategories(String Category, String Description)
    {
        sCategory = new SimpleStringProperty(Category);
        sDescription = new SimpleStringProperty(Description);
    }
    

    

    
    /**
     * gets the category and returns sCategory
     * @return 
     */
    public String getsCategory() 
    {
        return sCategory.get();
    }
    
    /**
     * sets the category passed in to the clsCategories sCategory
     * @param sCategory 
     */
    public void setsCategory(String sCategory) 
    {
        this.sCategory.set(sCategory);
    }
    
    /**
     * Returns sCategoryProperty
     * @return 
     */
    public StringProperty sCategoryProperty() 
    {
        return sCategory;
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
